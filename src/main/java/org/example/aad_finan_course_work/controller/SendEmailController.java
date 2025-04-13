package org.example.aad_finan_course_work.controller;

import org.example.aad_finan_course_work.dto.SendEmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/email")
public class SendEmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send")
    public String sendEmail(@RequestBody SendEmailDto sendEmailDto){


        try {
            SimpleMailMessage message=new SimpleMailMessage();
            message.setSubject(sendEmailDto.getSubject());
            message.setTo(sendEmailDto.getToMail());
            message.setText(sendEmailDto.getMessage());
            message.setFrom("894697001@smtp-brevo.com");
            javaMailSender.send(message);
            return "Success";

        }catch (Exception e){
            return e.getMessage();
        }
    }


}
