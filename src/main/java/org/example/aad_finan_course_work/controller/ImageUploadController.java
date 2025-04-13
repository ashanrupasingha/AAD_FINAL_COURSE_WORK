package org.example.aad_finan_course_work.controller;

import jakarta.annotation.Resource;
import lombok.Value;
import org.example.aad_finan_course_work.util.FileUploadUtil;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("api/v1/img")
public class ImageUploadController {

//    @PostMapping("/upload")
//    public void saveimg(@RequestParam("files")MultipartFile[] files){
//
//    String uploadDir="profileImagesFolder";
//        Arrays.asList(files).stream().forEach(file->{
//            String fileName= StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
//            System.out.println(fileName);
//
//            try {
//                FileUploadUtil.saveFile(uploadDir,fileName,file);
//            }catch (IOException ioException){
//                ioException.getMessage();
//            }
//        });
//    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//@Value("${product.images.dir}")
//private String uploadDir;
//
//    @GetMapping("/{filename}")
//    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
//        try {
//            Path file = Paths.get(uploadDir).resolve(filename);
//            Resource resource = new UrlResource(file.toUri());
//
//            if (resource.exists() || resource.isReadable()) {
//                return ResponseEntity.ok()
//                        .contentType(MediaType.IMAGE_JPEG)
//                        .body(resource);
//            } else {
//                throw new RuntimeException("Could not read the file!");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
