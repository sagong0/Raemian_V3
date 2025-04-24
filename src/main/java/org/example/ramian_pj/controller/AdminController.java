package org.example.ramian_pj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping({"","/"})
    public String loginPage() {
        return "admin/index";
    }
}
