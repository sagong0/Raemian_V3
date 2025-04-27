package org.example.ramian_pj.repository;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.AdminMemberTestDTO;
import org.example.ramian_pj.mapper.AdminMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminRepoImpl implements AdminRepository{

    private final AdminMapper adminMapper;

    @Override
    public List<AdminMemberTestDTO> getAdmins() {
        return adminMapper.getAdmins();
    }
}
