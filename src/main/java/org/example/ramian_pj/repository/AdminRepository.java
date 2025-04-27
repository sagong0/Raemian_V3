package org.example.ramian_pj.repository;

import org.example.ramian_pj.dto.AdminMemberDTO;

import java.util.List;

public interface AdminRepository {
    List<AdminMemberDTO> getAdmins();

    AdminMemberDTO findAdminByUserId(String aid);
}
