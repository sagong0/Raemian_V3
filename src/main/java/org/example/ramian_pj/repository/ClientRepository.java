package org.example.ramian_pj.repository;

import org.example.ramian_pj.dto.UserDTO;

public interface ClientRepository {
    UserDTO findUserById(String mid);
}
