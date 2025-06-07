package org.example.ramian_pj.service;


import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.UserJoinDTO;
import org.example.ramian_pj.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserJoinDTO findUserById(String mid) {
        return userRepository.findUserById(mid);
    }

    public int joinUser(UserJoinDTO userJoinDTO) {
        userJoinDTO.setMpw(passwordEncoder.encode(userJoinDTO.getMpw()));
        return userRepository.joinUser(userJoinDTO);
    }
}
