package org.example.ramian_pj.mapper;

import org.example.ramian_pj.dto.AdminJoinDTO;
import org.example.ramian_pj.dto.AdminMemberDTO;

import java.util.List;

public interface AdminMapper {
    List<AdminMemberDTO> getAdmins();

    AdminMemberDTO getAdminById(String userid);

    int saveAdmin(AdminJoinDTO adminJoinDTO);
}
