package com.kimhs.apis.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductRegisterVO {
    private String name;
    private String description;
    private String listPrice;
    private String price;

    @Override
    public String toString() {
        return String.format(
                "ProductRegisterVO[name='%s', description='%s', listPrice='%s', price='%s']",
                this.name, this.description, this.listPrice, this.price
        );
    }
}