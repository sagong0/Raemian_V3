package org.example.ramian_pj.controller;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.*;
import org.example.ramian_pj.service.AdminService;
import org.example.ramian_pj.service.NoticeService;
import org.example.ramian_pj.service.ReserveService;
import org.example.ramian_pj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;
    private final UserService userService;
    private final NoticeService noticeService;
    private final ReserveService reserveService;

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
        if (admin == null) {
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
        List<AdminReserveDTO> reservesForAdmin = reserveService.getAllReservesForAdmin();
        log.info("*>*******");
        log.info("reservesForAdmin: {}", reservesForAdmin);

        model.addAttribute("Users", allUsers);
        model.addAttribute("reserves", reservesForAdmin);
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
        if (bindingResult.hasErrors()) {
            return "admin/joinForm";
        }
        adminService.saveAdmin(adminJoinDTO);
        return "redirect:/admin/joinSuccess";
    }

    @GetMapping("/userList")
    public String userList(@ModelAttribute SearchConditionDTO searchConditionDTO, Model model) {
        log.info("searchConditionDTO = {}", searchConditionDTO);
        PageDTO pageInfo = userService.getPagedUsers(searchConditionDTO);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("searchConDTO", searchConditionDTO);
        return "/admin/user_list";
    }

    @PostMapping("/userList/delete")
    @ResponseBody
    public String userListDel(@RequestParam String mid) {
        userService.toggleDeleteStatus(mid);
        return "OK";
    }

    /**
     * 공지사항
     */
    @GetMapping("/notice")
    public String noticeMain(@ModelAttribute SearchConditionDTO searchConditionDTO, Model model) {
        PageDTO noticePageInfo = noticeService.getPagedNotices(searchConditionDTO);

        model.addAttribute("noticePageInfo", noticePageInfo);
        model.addAttribute("searchConDTO", searchConditionDTO);

        return "/admin/notice_main";
    }

    /**
     * 공지사항
     * 상세 페이지
     */
    @GetMapping("/notice/{nidx}")
    public String noticeDetail(@PathVariable Long nidx,
                               Model model) {

        NoticeDTO notice = noticeService.getNoticeByIdx(nidx);
        log.info("notice={}", notice);

        // 2) 없을 경우 예외처리 (선택)
        if (notice == null) {
            model.addAttribute("msg", "존재하지 않는 공지입니다.");
            return "redirect:/admin/notice";
        }

        model.addAttribute("notice", notice);

        return "/admin/notice_detail";
    }




    @GetMapping("/notice/write")
    public String noticeWriteForm() {

        return "/admin/notice_write";
    }

    @Transactional
    @PostMapping("/notice/write")
    public String noticeWrite(
            @ModelAttribute NoticeDTO noticeDTO,
            Model model,
            RedirectAttributes rd
    ) {
        MultipartFile file = noticeDTO.getNfile();
        // 파일 저장위치 TODO -> CDN 경로 수정 필요
        String uploadDir = "D:/temp/";

        try{
            // 1) 공지사항 먼저 일단 저장 -> notice_id 생성위해 ( 외래키 )
            noticeService.saveNotice(noticeDTO);
//            log.info("생성된 noticeId = {}", noticeDTO.getNoticeId()); // 여기가 0이면 문제!
            if (noticeDTO.getNoticeId() == null || noticeDTO.getNoticeId() == 0) {
                rd.addFlashAttribute("error", "공지 저장에 실패했습니다.");
                return "redirect:/notice";
            }


            // 2) 파일이 존재 할 경우만 처리
            if(file != null && !file.isEmpty()){
                String originalFileName = file.getOriginalFilename();
                String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

                String savedFileName = UUID.randomUUID().toString() + "_" + extension;

                // 저장 될 경로 지정
                File dest = new File(uploadDir + savedFileName);
                // 해당 경로에 저장
                file.transferTo(dest);

                NoticeFileDTO fileDTO = new NoticeFileDTO();
                fileDTO.setNoticeId(noticeDTO.getNoticeId());
                fileDTO.setFileName(savedFileName);
                fileDTO.setFilePath("/upload/notice/" + savedFileName);
                fileDTO.setFileSize(file.getSize());
                fileDTO.setContentType(file.getContentType());

                // DB 저장
                noticeService.saveNoticeFile(fileDTO);
                rd.addFlashAttribute("success", "공지 등록이 완료되었습니다.");
                return "redirect:/admin/notice";
            }

            // 파일이 없어도 여기로 와서 성공 처리
            rd.addFlashAttribute("success", "공지 등록이 완료되었습니다.");
            return "redirect:/admin/notice";
        }
        catch (IOException e){
            e.printStackTrace();
            rd.addFlashAttribute("error", "처리 중 오류가 발생했습니다.");
            return "redirect:/admin/notice/";
        }
    }



    @PostMapping("/notice/delete")
    @ResponseBody
    public String noticeDel(@RequestParam String nid) {
        int resultSign = noticeService.deleteNotice(nid);
        log.info("resultSign = {}", resultSign);
        if(resultSign <= 0){
            return "NO_OK";
        }

        return "OK";
    }




    /**
     * 관리자 현황 PART
     */
    @GetMapping("/member")
    public String adminMember(
            @RequestParam(value = "aarea", required = false,defaultValue = "all") String aarea,
            Model model) {

        List<AdminMemberDTO> admins;

        if("all".equals(aarea)){
            admins = adminService.getAllAdmins();
        }
        else {
            admins = adminService.getAdminsByArea(aarea);
        }

        model.addAttribute("admins", admins);

        return "admin/admin_mgm";
    }




}


