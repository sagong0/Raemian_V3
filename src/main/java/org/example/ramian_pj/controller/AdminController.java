package org.example.ramian_pj.controller;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.AdminJoinDTO;
import org.example.ramian_pj.dto.AdminLoginDTO;
import org.example.ramian_pj.dto.AdminMemberDTO;
import org.example.ramian_pj.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public String login(@Valid AdminLoginDTO adminLoginDTO, BindingResult bindingResult) {
        log.info(adminLoginDTO.toString());

        if (bindingResult.hasErrors()) {
            log.info("Admin login failed !");
            //TODO :  실패 로직

            return "admin";
        }
        else {
            //TODO :  성공 로직
            log.info("Admin logged in successfully !");
            return "redirect:/admin/dashboard";
        }
    }

    /*
    회원가입 PAGE
     */
    @GetMapping("/join")
    public String joinForm() {
        return "admin/joinForm";
    }

    @PostMapping("/join")
    public String joinForm(@Valid AdminJoinDTO adminJoinDTO, BindingResult bindingResult) {
        /**
         * 1. 해당 adminJoinDTO --> service.saveAdmin(adminJoinDTO)
         * 2. 성공시 -> redirect
         *    실패시 -> joinForm 으로
         */
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
}
