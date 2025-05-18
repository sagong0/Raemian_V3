package org.example.ramian_pj.controller;


import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ClientController {

    private final Logger log = LoggerFactory.getLogger(ClientController.class);

    private final UserService userService;

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

        return userService.findUserById(mid) ? "can_use" : "no_use";
    }

    /**
     * Sub Page 추가
     */
    @GetMapping("/sub01")
    public String sub01() {
        return "client/sub/sub01";
    }
    @GetMapping("/sub02")
    public String sub02() {
        return "client/sub/sub02";
    }
    @GetMapping("/sub03")
    public String sub03() {
        return "client/sub/sub03";

    // 휴대폰 - 인증번호 (dummy Random)
    @PostMapping("/sendDummyCode")
    @ResponseBody
    public ResponseEntity<Map<String,String>> sendDummyCode(@RequestParam String phoneNumber) {
        Map<String, String> response = new HashMap<>();

        if(!phoneNumber.matches("^01[016789]\\d{3,4}\\d{4}$")){
            response.put("message", "올바르지 않은 휴대폰 번호입니다.");
            return ResponseEntity.badRequest().body(response);
        }
        String code = String.format("%06d", new Random().nextInt(999999));
        response.put("code", code);
        response.put("message", "인증번호 발급 완료");

        return ResponseEntity.ok(response);
    }
}
