package org.example.aad_finan_course_work.service.impl;

import jakarta.transaction.Transactional;
import org.example.aad_finan_course_work.dto.ProductDTO;
import org.example.aad_finan_course_work.entity.Product;
import org.example.aad_finan_course_work.repo.ProductRepo;
import org.example.aad_finan_course_work.service.ProductService;
import org.example.aad_finan_course_work.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public int savePackage(ProductDTO productDTO) {
        productRepo.save(modelMapper.map(productDTO, Product.class));
        return VarList.Created;
    }

    public List<ProductDTO> getAllpackages() {
        List<Product> list = productRepo.findAll();
        return list.stream()
                .map(packages -> modelMapper.map(packages,ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updatePackage(ProductDTO packageDTO) {
        if (!productRepo.existsById(packageDTO.getProductId())) {
            throw new RuntimeException("Package does not exist!");
        }
        Product packageEntity = modelMapper.map(packageDTO, Product.class);
        productRepo.save(packageEntity);
    }
    // In ProductService interface


    // In ProductServiceImpl
    @Override
    public List<ProductDTO> getAllProductsForWebsite() {
        List<Product> products = productRepo.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

}