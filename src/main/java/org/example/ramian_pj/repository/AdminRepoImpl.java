package org.example.ramian_pj.repository;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.AdminJoinDTO;
import org.example.ramian_pj.dto.AdminMemberDTO;
import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.SearchConditionDTO;
import org.example.ramian_pj.mapper.AdminMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminRepoImpl implements AdminRepository{

    private final AdminMapper adminMapper;

    @Override
    public List<AdminMemberDTO> getAdmins() {
        return adminMapper.getAdmins();
    }

    @Override
    public AdminMemberDTO findAdminByUserId(String aid) {
        return adminMapper.getAdminById(aid);
    }

    @Override
    public int saveAdmin(AdminJoinDTO adminJoinDTO) {
        return adminMapper.saveAdmin(adminJoinDTO);
    }

    @Override
    public List<AdminMemberDTO> getAdminsByArea(String aarea) {
        return adminMapper.getAdminsByArea(aarea);
    }

    @Override
    public List<NoticeDTO> getAdminsBySearch(SearchConditionDTO searchConditionDTO, int offset) {
        return adminMapper.getAdminBySearchOption(searchConditionDTO, offset);
    }

    @Override
    public int countSearchAdmins(SearchConditionDTO searchConditionDTO) {
        return adminMapper.countSearchAdmins(searchConditionDTO);
    }

    @Override
    public int updateAdminStatus(Integer id, String status) {
        return adminMapper.updateAdminStatus(id, status);
    }
}
