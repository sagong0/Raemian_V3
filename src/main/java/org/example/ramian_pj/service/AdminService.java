package org.example.ramian_pj.service;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.AdminJoinDTO;
import org.example.ramian_pj.dto.AdminMemberDTO;
import org.example.ramian_pj.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;


    public List<AdminMemberDTO> test(){
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
}
