package com.kimhs.apis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int couponId;

    @Column
    Date expireAt;

    @Column
    String productID;

    @Column
    String category;

    @Column
    int discountPrice = 0;

    @Column
    int discountPercentage = 0;
}
