package com.kimhs.apis;

import com.kimhs.apis.model.Coupon;
import com.kimhs.apis.repository.CouponRepository;
import com.kimhs.apis.service.CouponService;
import com.kimhs.apis.vo.CouponRegisterVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CouponServiceTests {
    private final CouponService couponService;
    private final CouponRepository couponRepository;

    @Autowired
    public CouponServiceTests(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
        this.couponService = new CouponService(couponRepository);
    }

    @Test
    public void testCreateCouponWhenPercentageAndPriceExists() {
        // Given
        CouponRegisterVO couponRegisterVO = new CouponRegisterVO(new Date(), 7, 1, "null", 1000, 10);

        // When
        Exception thrown = assertThrows(Exception.class, () -> this.couponService.createCoupon(couponRegisterVO));

        // Then
        assertEquals("할인 금액과 할인 비율이 동시에 존재할 수 없습니다!", thrown.getMessage());
    }

    @Test
    @Transactional
    public void testCreateCouponWhenNormal() throws Exception {
        // Given
        CouponRegisterVO couponRegisterVO = new CouponRegisterVO(new Date(), 7, 1, "null", 1000, 0);

        // When
        int couponId = this.couponService.createCoupon(couponRegisterVO);

        // Then
        Coupon coupon = this.couponRepository.getOne(couponId);

        assertEquals(coupon.getProductID(), 1);
        assertEquals(coupon.getCouponId(), "null");
        assertEquals(coupon.getDiscountPrice(), 1000);
        assertEquals(coupon.getDiscountPercentage(), 0);
        assertEquals(coupon.getAvailableDays(), 7);
        assertEquals(coupon.getExpireAt().toString(), (new Date()).toString());
    }
}
