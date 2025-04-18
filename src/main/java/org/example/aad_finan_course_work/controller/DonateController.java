package org.example.aad_finan_course_work.controller;

import org.example.aad_finan_course_work.dto.DonateDTO;
import org.example.aad_finan_course_work.entity.Donate;
import org.example.aad_finan_course_work.entity.Product;
import org.example.aad_finan_course_work.service.DonateService;
import org.example.aad_finan_course_work.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:63342", "http://127.0.0.1:8080"},
        allowCredentials = "false")
public class DonateController {

    @Autowired
    private DonateService donateService;

    @Autowired
    private ProductService productService;

    @PostMapping("/donate")
    public ResponseEntity<?> saveDonation(@RequestBody DonateDTO donateDTO) {
        try {
            // Create and save the donation
            Donate donate = new Donate();
            donate.setName(donateDTO.getName());
            donate.setEmail(donateDTO.getEmail());
            donate.setPrice(donateDTO.getPrice());
            donateService.saveDonate(donate);

            // Update product price if specified
            String productName = donateDTO.getProduct();
            if (productName != null && !productName.isEmpty()) {
                Product product = productService.findByName(productName);
                if (product != null) {
                    double currentPrice = product.getPrice() != null ? product.getPrice() : 0.0;
                    double donationAmount = Double.parseDouble(donateDTO.getPrice());
                    product.setPrice(currentPrice + donationAmount);
                    productService.updateProduct(product);
                }
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Donation saved successfully");
            response.put("status", "success");

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Error processing donation: " + e.getMessage());
            errorResponse.put("status", "error");

            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Simple test endpoint to check if API is accessible
    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> testEndpoint() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "API is working correctly");
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
}