package org.example.aad_finan_course_work.controller;

import org.example.aad_finan_course_work.service.DonateService;
import org.example.aad_finan_course_work.service.UserService;
import org.example.aad_finan_course_work.service.impl.DonateServiceimpl;
import org.example.aad_finan_course_work.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/donate")
public class DonateController {

    @Autowired
    private final DonateServiceimpl donateService;
    private final JwtUtil jwtUtil;

    public DonateController(DonateServiceimpl donateService, JwtUtil jwtUtil) {
        this.donateService = donateService;
        this.jwtUtil = jwtUtil;
    }

}
