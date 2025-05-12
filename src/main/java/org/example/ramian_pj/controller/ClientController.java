package org.example.ramian_pj.controller;


import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.UserDTO;
import org.example.ramian_pj.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ClientController {

    private final Logger log = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    @GetMapping("")
    public String index() {
        return "client/index";
    }


    // 약관 동의 PART
    @GetMapping("/agree")
    public String joinAgree() {
        return "client/join_agree";
    }

    // 약관 동의 후 회원가입 PAGE
    @GetMapping("/join")
    public String joinAgreeForm() {
        return "client/join_form";
    }


    // 회원가입 - 아이디 중복체크
    @PostMapping("/id_check")
    @ResponseBody
    public String idCheck(@RequestBody String mid) {
        log.info("mid = {}", mid);
        UserDTO findUser = clientService.findUserById(mid);
        log.info("findUser = {}", findUser);
        return "";
    }
}
