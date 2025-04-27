package org.example.ramian_pj.repository;

import org.example.ramian_pj.dto.AdminMemberTestDTO;

import java.util.List;

public interface AdminRepository {
    List<AdminMemberTestDTO> getAdmins();
}
