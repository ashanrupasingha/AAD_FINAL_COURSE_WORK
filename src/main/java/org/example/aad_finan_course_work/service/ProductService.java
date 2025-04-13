package org.example.aad_finan_course_work.service;

import org.example.aad_finan_course_work.dto.ProductDTO;
import java.util.List;

public interface ProductService {

     int savePackage(ProductDTO packageDTO);
     List<ProductDTO> getAllpackages();
     void updatePackage(ProductDTO packageDTO);
     List<ProductDTO> getAllProductsForWebsite();
}