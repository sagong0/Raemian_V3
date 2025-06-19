package org.example.ramian_pj.controller;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.*;
import org.example.ramian_pj.service.AdminService;
import org.example.ramian_pj.service.UserService;
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
    private final UserService userService;

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
            model.addAttribute("loginFail", "아이디 또는 패스워드를 확인해주세요.");
            return "admin/index";
        }


        // 로그인 성공 (Session SAVE)
        session.setAttribute("admin", admin);

        // redirect 부분 TODO
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/joinSuccess")
    public String joinFormSuccess() {
        return "admin/joinSuccess";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<UserJoinDTO> allUsers = userService.getAllUsers();
        model.addAttribute("Users", allUsers);
        return "admin/admin_main";
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
            return "admin/joinForm";
        }
        adminService.saveAdmin(adminJoinDTO);
        return "redirect:/admin/joinSuccess";
    }

    @GetMapping("/userList")
    public String userList(@ModelAttribute SearchConditionDTO searchConditionDTO, Model model){
        log.info("searchConditionDTO = {}", searchConditionDTO);
        PageDTO pageInfo = userService.getPagedUsers(searchConditionDTO);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("searchConDTO", searchConditionDTO);
        return "/admin/user_list";
    }

    @PostMapping("/userList/delete")
    @ResponseBody
    public String userListDel(@RequestParam String mid){
        userService.toggleDeleteStatus(mid);
        return "OK";
    }

    /**
     * 공지사항
     */
    @GetMapping("/notice")
    public String noticeMain(){
        return "/admin/notice_main";
    }

    @GetMapping("/notice/write")
    public String noticeWriteForm(){

        return "/admin/notice_write";
    }

}
