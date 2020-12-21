package com.kimhs.apis.datamodel.dto;

import com.kimhs.apis.model.Product;
import com.kimhs.apis.model.Review;

import java.util.Collection;

public class ProductWithReviewDTO {
    private int productId;
    private String name;
    private String description;
    private int listPrice;
    private int price;
    private String category;
    private String imageUrl;
    private Collection<Review> review;

    public ProductWithReviewDTO(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.listPrice = product.getListPrice();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.imageUrl = product.getImageUrl();
        this.review = product.getReview();
    }

    @Override
    public String toString() {
        return String.format(
                "Product[productId='%s', name='%s', description='%s', listPrice=%d, price=%d, category='%s', imageUrl='%s']",
                this.productId, this.name, this.description, this.listPrice, this.price, this.category, this.imageUrl
        );
    }
}
