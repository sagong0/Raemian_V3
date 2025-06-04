package org.example.ramian_pj.mapper;

import org.example.ramian_pj.dto.UserJoinDTO;

public interface ClientMapper {
    UserJoinDTO findUserById(String mid);
}
