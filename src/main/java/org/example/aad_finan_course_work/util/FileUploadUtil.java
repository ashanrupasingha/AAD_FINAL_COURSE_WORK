package org.example.aad_finan_course_work.util;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
 public  static void  saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {

     Path uploadPath= Paths.get("/home/ashan/Advance API Development/AAD_Finan_Course_work/src/main/resources/static//");

     if (!Files.exists(uploadPath)) {

     }Files.createDirectories(uploadPath);

     try(InputStream inputStream=multipartFile.getInputStream()) {
         Path filePath=uploadPath.resolve(fileName);
         Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
     }catch (IOException ioException){
        ioException.getMessage();
     }
 }

}
