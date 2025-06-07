package org.example.ramian_pj.controller;


import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.UserJoinDTO;
import org.example.ramian_pj.service.UserService;
import org.example.ramian_pj.util.DummyCodeStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/join")
    public String joinAgreeFormSubmit(@Valid UserJoinDTO userJoinDTO, Model model){
        log.info("userJoinDto = {}", userJoinDTO);

        int result = userService.joinUser(userJoinDTO);
        log.info("result = {}", result);

        if(result <= 0){
            model.addAttribute("error", "회원가입 실패하였습니다. 잠시 후 다시 시도해주세요." );
        }

        // 성공 로직
        return "redirect:/login";
    }


    // 회원가입 - 아이디 중복체크
    @PostMapping("/id_check")
    @ResponseBody
    public String idCheck(@RequestBody String mid) {
        return userService.findUserById(mid.trim()) == null ? "can_use" : "no_use";
    }


    @GetMapping("/login")
    public String login() {
        return "client/login";
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
    }



    // 휴대폰 - 인증번호 (dummy Random)
    @PostMapping("/sendDummyCode")
    @ResponseBody
    public ResponseEntity<Map<String,String>> sendDummyCode(@RequestParam String phoneNumber) {
        HashMap<String, String> responseMap = new HashMap<>();

        if(!phoneNumber.matches("^01[016789]\\d{3,4}\\d{4}$")){
            responseMap.put("message", "올바르지 않은 휴대폰 번호입니다.");
            return ResponseEntity.badRequest().body(responseMap);
        }
        String code = String.format("%06d", new Random().nextInt(999999));
        responseMap.put("code", code);
        responseMap.put("message", "인증번호 발급 완료");

        // 추후 검증용 메모리 저장 PART
        DummyCodeStorage.codeStorageMap.put(phoneNumber, code);

        return ResponseEntity.ok(responseMap);
    }

    @PostMapping("/checkDummyCode")
    public ResponseEntity<Map<String,String >> checkDummyCode(@RequestParam String phoneNumber, @RequestParam String inputCode){
        log.info("phoneNumber : {}, inputCode : {}", phoneNumber, inputCode);
        HashMap<String, String> responseMap = new HashMap<>();

        String savedCode = DummyCodeStorage.codeStorageMap.get(phoneNumber);
        if(savedCode == null){
            responseMap.put("message", "인증번호를 확인해주세요.");
            return ResponseEntity.badRequest().body(responseMap);
        }

        if(!savedCode.equals(inputCode)){
            responseMap.put("message", "인증번호가 일치하지 않습니다.");
            return ResponseEntity.badRequest().body(responseMap);
        }

        // 인증성공 -> 메모리에서 삭제 (1회성)
        DummyCodeStorage.codeStorageMap.remove(phoneNumber);
        responseMap.put("message", "인증 성공!");
        return ResponseEntity.ok(responseMap);
    }
}
