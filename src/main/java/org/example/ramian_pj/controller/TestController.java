package org.example.ramian_pj.controller;


import org.example.ramian_pj.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private TestRepository TestRepo;

    @GetMapping("/now")
    @ResponseBody
    public String now() {
        return this.TestRepo.getNow();
    }
}
