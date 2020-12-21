package com.kimhs.apis;

import com.kimhs.apis.repository.CouponRepository;
import com.kimhs.apis.service.CouponService;
import com.kimhs.apis.datamodel.vo.CouponRegisterVO;
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
    public CouponServiceTests() {
        this.couponRepository = mock(CouponRepository.class);
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
        this.couponService.createCoupon(couponRegisterVO);

        // Then
        verify(this.couponRepository).flush();
    }
}
