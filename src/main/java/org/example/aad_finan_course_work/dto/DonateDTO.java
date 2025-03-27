package org.example.aad_finan_course_work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DonateDTO {
    private int donateId;
    private String name;
    private String email;
    private String price;


}
