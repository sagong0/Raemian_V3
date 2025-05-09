package org.example.ramian_pj.repository;

import org.example.ramian_pj.dto.AdminJoinDTO;
import org.example.ramian_pj.dto.AdminMemberDTO;

import java.util.List;

public interface AdminRepository {
    List<AdminMemberDTO> getAdmins();

    AdminMemberDTO findAdminByUserId(String aid);

    int saveAdmin(AdminJoinDTO adminJoinDTO);
}
