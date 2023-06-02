package ir.digixo.controller;


import ir.digixo.entity.Coupon;
import ir.digixo.model.CouponRequestModel;
import ir.digixo.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/coupons")
public class CouponController {


    @Autowired
    private CouponRepository couponRepository;


    /*
    {
    "code":"spring10",
    "discount":"10",
    "date":"2023-05-04"
}
    * */
    @PostMapping
    public Coupon createCoupon(@RequestBody CouponRequestModel model)
    {
        var coupon = new Coupon();
        coupon.setCode(model.getCode());
        coupon.setDiscount(model.getDiscount());
        coupon.setExpiryDate(model.getExpiryDate());
        return   couponRepository.save(coupon);
    }
    @GetMapping("{code}")
    public Coupon findByCouponCode(@PathVariable("code") String coupon)
    {
        System.out.println("service invoked!!");
        Optional<Coupon> coupon1 = couponRepository.findByCode(coupon);
        return coupon1.get();
    }
}
