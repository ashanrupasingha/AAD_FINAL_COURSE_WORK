package org.example.aad_finan_course_work.service.impl;

import jakarta.transaction.Transactional;
import org.example.aad_finan_course_work.dto.ContactDTO;
import org.example.aad_finan_course_work.dto.ProductDTO;
import org.example.aad_finan_course_work.dto.UserDTO;
import org.example.aad_finan_course_work.entity.Contact;
import org.example.aad_finan_course_work.entity.Product;
import org.example.aad_finan_course_work.entity.User;
import org.example.aad_finan_course_work.repo.ContactRepo;
import org.example.aad_finan_course_work.repo.ProductRepo;
import org.example.aad_finan_course_work.service.ProductService;
import org.example.aad_finan_course_work.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public int saveProduct(ProductDTO productDTO) {

        boolean b = productRepo.existsByName(productDTO.getName());
        if (!b){
            productDTO.setProductId(1);
            Product product = new Product(productDTO.getProductId(), productDTO.getDescription(), productDTO.getPrice(), productDTO.getName(), productDTO.getImagePath());
            Product save = productRepo.save(product);
            if (save != null){
                return VarList.Created;
            } else {
                return VarList.Bad_Request;
            }
        }
        return VarList.Bad_Request;
        }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> list = productRepo.findAll();
        return list.stream().map(product -> modelMapper.map(product,ProductDTO.class)).collect(Collectors.toList());
    }
}

