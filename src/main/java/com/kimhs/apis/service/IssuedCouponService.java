package com.kimhs.apis.service;

import com.kimhs.apis.model.Coupon;
import com.kimhs.apis.model.IssuedCoupon;
import com.kimhs.apis.repository.CouponRepository;
import com.kimhs.apis.repository.IssuedCouponRepository;
import com.kimhs.apis.util.DateUtil;
import com.kimhs.apis.vo.IssueCouponVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Optional;

@Controller
public class IssuedCouponService {
    private final IssuedCouponRepository issuedCouponRepository;
    private final CouponRepository couponRepository;

    @Autowired
    public IssuedCouponService(IssuedCouponRepository issuedCouponRepository,
                               CouponRepository couponRepository) {
        this.issuedCouponRepository = issuedCouponRepository;
        this.couponRepository = couponRepository;
    }

    public int issueCoupon(IssueCouponVO issueCouponVO) throws Exception {
        Optional<Coupon> SearchedCoupon = this.couponRepository.findById(issueCouponVO.getCouponId());
        Coupon coupon = SearchedCoupon.orElseThrow(() -> new Exception("해당 쿠폰을 찾지 못하였습니다."));

        Date expireDate = null;
        Date addedDate = DateUtil.addDays(new Date(), coupon.getAvailableDays());

        int compareDate = addedDate.compareTo(coupon.getExpireAt());
        if (compareDate >= 1) {
            expireDate = coupon.getExpireAt();
        } else if (compareDate <= -1) {
            expireDate = addedDate;
        } else {
            expireDate = addedDate;
        }

        IssuedCoupon issuedCoupon = IssuedCoupon.builder()
                .couponId(issueCouponVO.getCouponId())
                .expiredAt(expireDate)
                .userId(issueCouponVO.getUserId())
                .build();

        this.issuedCouponRepository.save(issuedCoupon);
        this.issuedCouponRepository.flush();

        return issuedCoupon.getIssuedCouponId();
    }
}
