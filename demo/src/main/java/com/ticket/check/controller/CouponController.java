package com.ticket.check.controller;


import com.ticket.check.domain.ResponseDto;
import com.ticket.check.services.CouponService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;


    @GetMapping("/{couponId}/{price}")
    public ResponseDto getTicket(@PathVariable Long couponId, @PathVariable Double price) {
        return couponService.checkCoupon(couponId, price);
    }


}
