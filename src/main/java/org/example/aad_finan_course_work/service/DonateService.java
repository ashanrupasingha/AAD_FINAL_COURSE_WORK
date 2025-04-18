package org.example.aad_finan_course_work.service;

import org.example.aad_finan_course_work.entity.Donate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface DonateService {
    void saveDonate(Donate donate);
}
