package org.example.ramian_pj.service;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.domain.AdminMemberSearchType;
import org.example.ramian_pj.domain.ClientMemberSearchType;
import org.example.ramian_pj.domain.SortOption;
import org.example.ramian_pj.dto.*;
import org.example.ramian_pj.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;


    public List<AdminMemberDTO> getAllAdmins(){
        return this.adminRepository.getAdmins();
    }

    public AdminMemberDTO getAdminByUserId(String aid) {
        return this.adminRepository.findAdminByUserId(aid);
    }

    public boolean saveAdmin(AdminJoinDTO adminJoinDTO) {
        // PW 암호화 처리
        adminJoinDTO.setApw1(passwordEncoder.encode(adminJoinDTO.getApw1()));
        return this.adminRepository.saveAdmin(adminJoinDTO) > 0;
    }


    // 로그인 처리
    public AdminMemberDTO login(AdminLoginDTO adminLoginDTO) {

        AdminMemberDTO findAdmin = adminRepository.findAdminByUserId(adminLoginDTO.getAid());

        // 없는 아이디
        if(findAdmin == null){
            return null;
        }

        // 비밀번호 검증
        if(!passwordEncoder.matches(adminLoginDTO.getApw(), findAdmin.getPw())){
            return null;    // 비밀번호 틀림
        }

        return findAdmin;
    }


    /**
     * 지역 Admin 출력
     */
    public List<AdminMemberDTO> getAdminsByArea(String aarea) {
        return adminRepository.getAdminsByArea(aarea);
    }

    public PageDTO getPagedAdmins(SearchConditionDTO searchConditionDTO) {
        // 검색 조건 화이트 리스트 검증
        if(!AdminMemberSearchType.values().contains(searchConditionDTO.getSearchType())){
            // 기본 검색 기준 -> userID
            searchConditionDTO.setSearchType("userid");
        }
        // 정렬 기준 화이트 리스트 검증
        if(!SortOption.adminValues().contains(searchConditionDTO.getSortBy())){
            // 기본 정렬 값 - created_at
            searchConditionDTO.setSortBy("created_at");
        }

        // 내림차순 및 오름차순 검증
        if(!"desc".contains(searchConditionDTO.getOrder())){
            searchConditionDTO.setOrder("asc");
        }

        int offset = (searchConditionDTO.getPage() - 1) * searchConditionDTO.getPageSize();
        List<NoticeDTO> notices = adminRepository.getAdminsBySearch(searchConditionDTO, offset);
        int totalCount = adminRepository.countSearchAdmins(searchConditionDTO);

        return new PageDTO(notices, totalCount, searchConditionDTO.getPage(), searchConditionDTO.getPageSize());
    }

    public int updateAdminStatus(Integer id, String status) {
        return adminRepository.updateAdminStatus(id, status);
    }
}
