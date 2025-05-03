package org.example.ramian_pj.controller;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ClientController {

    private final Logger log = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("")
    public String index() {
        log.info("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");

        return "client/index";
    }

    @GetMapping("/agree")
    public String joinAgree() {
        return "client/join_agree";
    }
}
