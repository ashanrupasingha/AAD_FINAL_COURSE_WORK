package org.example.aad_finan_course_work.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
 //   @Column(name = "image_path")
    private int productId;
    private String name;
    private Double price;
    private String description;
    private String imagePath;




    // Add this method to get full image URL
//    public String getImageUrl() {
//        if (imagePath == null || imagePath.isEmpty()) {
//            return "/img/default-product.jpg";
//        }
//        return imagePath.startsWith("http") ? imagePath : "/product-images/" + imagePath;
//    }
}

