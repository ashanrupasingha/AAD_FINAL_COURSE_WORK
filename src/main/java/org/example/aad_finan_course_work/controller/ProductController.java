package org.example.aad_finan_course_work.controller;

import jakarta.validation.Valid;
import org.example.aad_finan_course_work.dto.ProductDTO;
import org.example.aad_finan_course_work.dto.ResponseDTO;
import org.example.aad_finan_course_work.service.ProductService;
import org.example.aad_finan_course_work.util.ResponseUtil;
import org.example.aad_finan_course_work.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public  ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ResponseDTO> savePackage(@RequestBody @Validated ProductDTO packageDTO){
        System.out.println(packageDTO+"me dan awe");
        int Result = productService.savePackage(packageDTO);
        ResponseDTO responseDTO = new ResponseDTO(VarList.Created,"product Active Successfully", Result);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllpackages() {
        List<ProductDTO> dtos = productService.getAllpackages();
        System.out.println("awaa "+ dtos);
        ResponseDTO responseDTO = new ResponseDTO(VarList.Created, "Success", dtos);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseUtil updatePackage(@PathVariable String id, @RequestBody ProductDTO packageDTO) {
        packageDTO.setProductId(Integer.parseInt(id));
        productService.updatePackage(packageDTO);
        return new ResponseUtil(200, "product updated successfully", null);
    }
    @GetMapping("/getAllForWebsite")
    public ResponseEntity<List<ProductDTO>> getAllProductsForWebsite() {
        List<ProductDTO> products = productService.getAllpackages();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseDTO> savePackage(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") Double price,
            @RequestParam(value = "image", required = false) MultipartFile image) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        productDTO.setDescription(description);
        productDTO.setPrice(price);

//        if (image != null && !image.isEmpty()) {
//            try {
//                String filename = System.currentTimeMillis() + "_" + image.getOriginalFilename();
//                Path uploadPath = Paths.get(uploadDir);
//
//                if (!Files.exists(uploadPath)) {
//                    Files.createDirectories(uploadPath);
//                }
//
//                Files.copy(image.getInputStream(), uploadPath.resolve(filename),
//                        StandardCopyOption.REPLACE_EXISTING);
//
//                productDTO.setImagePath(filename);
//            } catch (Exception e) {
//                return new ResponseEntity<>(
//                        new ResponseDTO(VarList.Not_Acceptable, "Failed to save image", null),
//                        HttpStatus.NOT_ACCEPTABLE);
//            }
//        }

        int result = productService.savePackage(productDTO);
        ResponseDTO responseDTO = new ResponseDTO(VarList.Created, "Product saved successfully", result);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}