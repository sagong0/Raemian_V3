package org.example.ramian_pj.repository;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.UserDTO;
import org.example.ramian_pj.mapper.ClientMapper;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepository {

    private final ClientMapper clientMapper;

    @Override
    public UserDTO findUserById(String mid) {
        return clientMapper.findUserById(mid);
    }
}
