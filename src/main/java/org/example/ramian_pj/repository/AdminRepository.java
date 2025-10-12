package org.example.ramian_pj.repository;

import org.example.ramian_pj.dto.AdminJoinDTO;
import org.example.ramian_pj.dto.AdminMemberDTO;
import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.SearchConditionDTO;

import java.util.List;

public interface AdminRepository {
    List<AdminMemberDTO> getAdmins();

    AdminMemberDTO findAdminByUserId(String aid);

    int saveAdmin(AdminJoinDTO adminJoinDTO);

    List<AdminMemberDTO> getAdminsByArea(String aarea);

    List<NoticeDTO> getAdminsBySearch(SearchConditionDTO searchConditionDTO, int offset);

    int countSearchAdmins(SearchConditionDTO searchConditionDTO);
}
