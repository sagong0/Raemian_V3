package org.example.ramian_pj.service;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.AdminMemberTestDTO;
import org.example.ramian_pj.repository.AdminRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public List<AdminMemberTestDTO> test(){

        return this.adminRepository.getAdmins();
    }
}
