package org.example.aad_finan_course_work.dto;

import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter

public class ProductDTO {
    private int productId;
    private String name;
    private Double price;
    private String description;
    private String imagePath;

    public ProductDTO() {
    }


    public ProductDTO(int productId, String name, Double price, String description, String imagePath) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
