package org.example.ramian_pj.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.ramian_pj.dto.AdminJoinDTO;
import org.example.ramian_pj.dto.AdminMemberDTO;
import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.SearchConditionDTO;

import java.util.List;

public interface AdminMapper {
    List<AdminMemberDTO> getAdmins();

    AdminMemberDTO getAdminById(String userid);

    int saveAdmin(AdminJoinDTO adminJoinDTO);

    List<AdminMemberDTO> getAdminsByArea(String aarea);

    List<NoticeDTO> getAdminBySearchOption(@Param("searchConditionDTO") SearchConditionDTO searchConditionDTO, @Param("offset") int offset);

    int countSearchAdmins(@Param("searchConditionDTO") SearchConditionDTO searchConditionDTO);
}
