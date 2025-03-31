package org.example.aad_finan_course_work.service;


import org.example.aad_finan_course_work.dto.ProductDTO;
import org.example.aad_finan_course_work.dto.UserDTO;

import java.util.List;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String email);

}
