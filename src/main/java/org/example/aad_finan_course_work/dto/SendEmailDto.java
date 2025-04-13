package org.example.aad_finan_course_work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailDto {
    private String toMail;
    private String message;
    private String subject;
}
