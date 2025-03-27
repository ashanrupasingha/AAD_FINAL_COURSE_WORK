package org.example.aad_finan_course_work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Table(name = "donate")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Donate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donateId;
    private String name;
    private String email;
    private String price;





}
