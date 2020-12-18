package com.kimhs.apis.route;

import com.kimhs.apis.model.Coupon;
import com.kimhs.apis.service.CouponService;
import com.kimhs.apis.vo.CouponRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponRoute {
    private final CouponService couponService;

    @Autowired
    public CouponRoute(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/{coupon_id}")
    @ResponseBody
    public Coupon getCoupon(@PathVariable(value = "coupon_id") String couponId) throws Exception {
        return this.couponService.couponById(Integer.parseInt(couponId));
    }

    @PostMapping
    public int createCoupon(CouponRegisterVO couponRegisterVO) throws Exception {
        return this.couponService.createCoupon(couponRegisterVO);
    }
}
