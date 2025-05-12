package org.example.ramian_pj.service;


import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.UserDTO;
import org.example.ramian_pj.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO findUserById(String mid) {
        return userRepository.findUserById(mid);
    }
}
