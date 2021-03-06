package com.kimhs.apis.route;

import com.kimhs.apis.datamodel.dto.CouponDTO;
import com.kimhs.apis.datamodel.dto.IssuedCouponDTO;
import com.kimhs.apis.model.Coupon;
import com.kimhs.apis.model.IssuedCoupon;
import com.kimhs.apis.service.CouponService;
import com.kimhs.apis.service.IssuedCouponService;
import com.kimhs.apis.datamodel.vo.CouponRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponRoute {
    private final CouponService couponService;
    private final IssuedCouponService issuedCouponService;

    @Autowired
    public CouponRoute(CouponService couponService,
                       IssuedCouponService issuedCouponService) {
        this.couponService = couponService;
        this.issuedCouponService = issuedCouponService;
    }

    @GetMapping("/{coupon_id}")
    @ResponseBody
    public CouponDTO getCoupon(@PathVariable(value = "coupon_id") String couponId) throws Exception {
        return this.couponService.couponById(Integer.parseInt(couponId));
    }

    @PostMapping
    public int createCoupon(CouponRegisterVO couponRegisterVO) throws Exception {
        return this.couponService.createCoupon(couponRegisterVO);
    }

    @PostMapping("/{coupon_id}/issue")
    public int issueCoupon(@PathVariable(value = "coupon_id") String couponId,
                           @RequestParam(value = "user_id") String userId) throws Exception {
        return this.issuedCouponService.issueCoupon(Integer.parseInt(couponId), Integer.parseInt(userId));
    }

    @GetMapping("/issued-coupon/{issued_coupon_id}")
    @ResponseBody
    public IssuedCouponDTO getIssuedCoupon(@PathVariable(value = "issued_coupon_id") String issuedCouponId) throws Exception {
        return this.issuedCouponService.issueCouponById(Integer.parseInt(issuedCouponId));
    }
}
