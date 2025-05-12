package org.example.ramian_pj.mapper;

import org.example.ramian_pj.dto.UserDTO;

public interface ClientMapper {
    UserDTO findUserById(String mid);
}
