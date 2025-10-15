package org.example.ramian_pj.service;


import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.domain.ClientMemberSearchType;
import org.example.ramian_pj.domain.SortOption;
import org.example.ramian_pj.dto.PageDTO;
import org.example.ramian_pj.dto.SearchConditionDTO;
import org.example.ramian_pj.dto.UserJoinDTO;
import org.example.ramian_pj.dto.UserLoginDTO;
import org.example.ramian_pj.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // 모든 회원 조회
    public List<UserJoinDTO> getAllUsers(){
        return userRepository.getAllUsers();
    };

    public UserJoinDTO findUserById(String mid) {
        return userRepository.findUserById(mid);
    }

    public int joinUser(UserJoinDTO userJoinDTO) {
        userJoinDTO.setMpw(passwordEncoder.encode(userJoinDTO.getMpw()));
        return userRepository.joinUser(userJoinDTO);
    }

    public UserJoinDTO userLogin(UserLoginDTO userLoginDTO) {
        UserJoinDTO findUser = userRepository.findUserById(userLoginDTO.getAid());

        if(findUser == null){
            return null;
        }

        // 비밀번호 틀린 경우
        if(!passwordEncoder.matches(userLoginDTO.getApw(), findUser.getMpw())){
            return null;
        }

        // 아디 비번 맞을 경우
        return findUser;
    }

    public PageDTO getPagedUsers(SearchConditionDTO searchConditionDTO) {
        // 검색 조건 화이트 리스트 검증
        if(!ClientMemberSearchType.values().contains(searchConditionDTO.getSearchType())){
            // 기본 검색 기준 -> userID
            searchConditionDTO.setSearchType("userid");
        }
        // 정렬 기준 화이트 리스트 검증
        if(!SortOption.values().contains(searchConditionDTO.getSortBy())){
            // 기본 정렬 값 - created_at
            searchConditionDTO.setSortBy("created_at");
        }

        // 내림차순 및 오름차순 검증
        if(!"desc".contains(searchConditionDTO.getOrder())){
            searchConditionDTO.setOrder("asc");
        }

        // 건너 뛸 행수
        // EX
        // 0, offset : 5 - 1 Page
        // 5, offset : 10 - 2 Page
        // 10.offset :  15 - 3 Page
        int offset = (searchConditionDTO.getPage() - 1) * searchConditionDTO.getPageSize();
        List<UserJoinDTO> searchedUsers = userRepository.getUsersBySearch(searchConditionDTO, offset);
        int totalCount = userRepository.countSearchUsers(searchConditionDTO);

        log.info("searchedUsers = {}", searchedUsers);
        log.info("totalCount = {}", totalCount);

        return new PageDTO(searchedUsers, totalCount, searchConditionDTO.getPage(), searchConditionDTO.getPageSize());

    }

    public void toggleDeleteStatus(String mid) {
        userRepository.toggleDeleteStatus(mid);
    }
}
