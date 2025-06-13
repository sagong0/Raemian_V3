package org.example.ramian_pj.mapper;

import org.example.ramian_pj.dto.UserJoinDTO;

import java.util.List;

public interface ClientMapper {
    UserJoinDTO findUserById(String mid);

    int joinUser(UserJoinDTO userJoinDTO);

    List<UserJoinDTO> getAllUsers();
}
