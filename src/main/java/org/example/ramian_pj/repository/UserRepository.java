package org.example.ramian_pj.repository;

import org.example.ramian_pj.dto.UserJoinDTO;

public interface UserRepository {
    UserJoinDTO findUserById(String mid);

    int joinUser(UserJoinDTO userJoinDTO);
}
