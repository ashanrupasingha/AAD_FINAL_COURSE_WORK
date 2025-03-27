package org.example.aad_finan_course_work.controller;

import jakarta.validation.Valid;
import org.example.aad_finan_course_work.dto.ContactDTO;
import org.example.aad_finan_course_work.dto.ProductDTO;
import org.example.aad_finan_course_work.dto.ResponseDTO;
import org.example.aad_finan_course_work.service.ProductService;
import org.example.aad_finan_course_work.util.JwtUtil;
import org.example.aad_finan_course_work.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveProduct(@Valid @RequestBody ProductDTO producttDTO) {
        System.out.println("save");
        try{
            int res = productService.saveProduct(producttDTO);
            switch (res) {
                case VarList.Created: {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", producttDTO));
                }
                case VarList.Not_Acceptable: {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Id already Use", null));
                }
                default: {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
