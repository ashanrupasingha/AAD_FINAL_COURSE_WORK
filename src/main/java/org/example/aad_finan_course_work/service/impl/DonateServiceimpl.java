
package org.example.aad_finan_course_work.service.impl;

import org.example.aad_finan_course_work.entity.Donate;

import org.example.aad_finan_course_work.repo.DonateRepo;
import org.example.aad_finan_course_work.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonateServiceimpl implements DonateService {

    @Autowired
    private DonateRepo donateRepository;

    @Override
    public void saveDonate(Donate donate) {
        donateRepository.save(donate);
    }
}
