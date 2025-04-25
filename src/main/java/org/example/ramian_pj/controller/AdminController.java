package org.example.ramian_pj.controller;

import org.example.ramian_pj.dto.AdminLoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

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
        log.info("join form !!!!!!");
        return "admin/joinForm";
    }

    /**
     * ID 중복체크 PART
     */
    @PostMapping("/id_ck")
    @ResponseBody
    public String idCheck(@RequestBody String aid) {
        log.info("aid = {}", aid);
        return null;
    }
}
