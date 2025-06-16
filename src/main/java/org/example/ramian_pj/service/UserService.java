package org.example.ramian_pj.service;


import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.domain.SearchType;
import org.example.ramian_pj.domain.SortOption;
import org.example.ramian_pj.dto.SearchConditionDTO;
import org.example.ramian_pj.dto.UserJoinDTO;
import org.example.ramian_pj.dto.UserLoginDTO;
import org.example.ramian_pj.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

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

    public void getPagedUsers(SearchConditionDTO searchConditionDTO) {
        // 검색 조건 화이트 리스트 검증
        if(!SearchType.values().contains(searchConditionDTO.getSearchType())){
            // 기본 검색 기준 -> userID
            searchConditionDTO.setSearchType("userid");
        }
        // 정렬 기준 화이트 리스트 검증
        if(!SortOption.values().contains(searchConditionDTO.getSortBy())){
            // 기본 정렬 값 - created_at
            searchConditionDTO.setSortBy("created_at");
        }
    }
}
