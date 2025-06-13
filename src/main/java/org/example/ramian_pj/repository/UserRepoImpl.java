package org.example.ramian_pj.repository;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.UserJoinDTO;
import org.example.ramian_pj.mapper.ClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class UserRepoImpl implements UserRepository {

    private final ClientMapper clientMapper;

    @Override
    public UserJoinDTO findUserById(String mid) {
        return clientMapper.findUserById(mid);
    }

    @Override
    public int joinUser(UserJoinDTO userJoinDTO) {
        return clientMapper.joinUser(userJoinDTO);
    }

    @Override
    public List<UserJoinDTO> getAllUsers() {
        return clientMapper.getAllUsers();
    }
}
