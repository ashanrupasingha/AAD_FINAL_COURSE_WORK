package org.example.aad_finan_course_work.controller;


import org.example.aad_finan_course_work.dto.AuthDTO;
import org.example.aad_finan_course_work.dto.ResponseDTO;
import org.example.aad_finan_course_work.dto.UserDTO;

import org.example.aad_finan_course_work.service.impl.UserServiceImpl;
import org.example.aad_finan_course_work.util.JwtUtil;
import org.example.aad_finan_course_work.util.VarList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;



@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final ResponseDTO responseDTO;

    //constructor injection
    public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserServiceImpl userService, ResponseDTO responseDTO) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.responseDTO = responseDTO;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseDTO> authenticate(@RequestBody UserDTO userDTO) {
        System.out.println("Kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getEmail(), userDTO.getPassword()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ResponseDTO(VarList.Unauthorized, "Invalid Credentials", e.getMessage()));
        }

        UserDTO loadedUser = userService.loadUserDetailsByUsername(userDTO.getEmail());
        if (loadedUser == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseDTO(VarList.Conflict, "Authorization Failure! Please Try Again", null));
        }

        String token = jwtUtil.generateToken(loadedUser);
        if (token == null || token.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseDTO(VarList.Conflict, "Authorization Failure! Please Try Again", null));
        }

        AuthDTO authDTO = new AuthDTO();
        authDTO.setEmail(loadedUser.getEmail());
        authDTO.setEmail(loadedUser.getRole());
        authDTO.setToken(token);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(VarList.Created, "Success", authDTO));
    }
}

/*
    @GetMapping
    public ResponseEntity<ResponseDTO> checkRole(@RequestParam String email) {
        User user = userService.findByEmail(email);

        ResponseDTO response = new ResponseDTO();

        if (user != null) {
            if ("Admin".equals(user.getRole())) {
                response.setCode(200);  // Success code
                response.setMessage("User is Admin.");
                response.setData("Admin");
            } else if ("User".equals(user.getRole())) {
                response.setCode(200);  // Success code
                response.setMessage("User is a regular User.");
                response.setData("User");
            } else {
                response.setCode(404);  // Not Found
                response.setMessage("Role not found.");
                response.setData(null);
            }
        } else {
            response.setCode(404);  // Not Found
            response.setMessage("Email not found.");
            response.setData(null);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

*/