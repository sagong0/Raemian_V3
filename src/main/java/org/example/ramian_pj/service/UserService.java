package org.example.ramian_pj.service;


import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.UserDTO;
import org.example.ramian_pj.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Boolean findUserById(String mid) {
        return userRepository.findUserById(mid) == null;
    }
}
