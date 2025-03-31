package org.example.aad_finan_course_work.service;

import org.example.aad_finan_course_work.dto.ProductDTO;

import java.util.List;

public interface ProductService {
     public int saveProduct(ProductDTO productDTO);
     List<ProductDTO> getAllProducts();
}
