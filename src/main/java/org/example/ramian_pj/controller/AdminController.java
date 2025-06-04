package org.example.ramian_pj.controller;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.AdminJoinDTO;
import org.example.ramian_pj.dto.AdminLoginDTO;
import org.example.ramian_pj.dto.AdminMemberDTO;
import org.example.ramian_pj.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;

    @GetMapping({"", "/"})
    public String loginPage() {
        return "admin/index";
    }

    @PostMapping
    public String login(@Valid AdminLoginDTO adminLoginDTO,
                        BindingResult bindingResult,
                        Model model,
                        HttpSession session) {

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            model.addAttribute("loginFail", errorMessages); // 리스트로 넘긴다
            return "admin/index";
        }

        AdminMemberDTO admin = adminService.login(adminLoginDTO);
        if(admin == null){
            log.info("틀렷어요 !!!!");
            model.addAttribute("loginFail", "아이디 또는 패스워드를 확인해주세요.");
            return "admin/index";
        }
        // 로그인 성공 (Session SAVE)
        session.setAttribute("admin", admin);

        // redirect 부분 TODO
        return "redirect:/admin/dashboard";
    }

    // 로그아웃 PART
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/admin";
    }

    /*
    회원가입 PAGE
     */
    @GetMapping("/join")
    public String joinForm() {
        return "admin/joinForm";
    }

    /**
     * ID 중복체크 PART
     */
    @PostMapping("/id_ck")
    @ResponseBody
    public String idCheck(@RequestBody String aid) {
        AdminMemberDTO findUserId = this.adminService.getAdminByUserId(aid);
        if (findUserId == null) {
            return "can_use";
        }
        return "no_use";
    }


    // 회원가입 요청
    @PostMapping("/join")
    public String joinForm(@Valid AdminJoinDTO adminJoinDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.info("회원가입 validation 실패!");
            return "admin/joinForm";
        }
        adminService.saveAdmin(adminJoinDTO);
        return "redirect:/admin/joinSuccess";
    }

    @GetMapping("/joinSuccess")
    public String joinFormSuccess() {
        return "admin/joinSuccess";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        log.info("대쉬 보드 진입 ");
        return "admin/admin_main";
    }
}
