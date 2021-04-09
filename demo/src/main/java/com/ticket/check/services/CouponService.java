package com.ticket.check.services;


import com.ticket.check.domain.CacheDto;
import com.ticket.check.domain.ResponseDto;
import com.ticket.check.interfaces.FindEntityInterface;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.LongStream.range;

@Component

public class CouponService {

    private final static Set<Long> coupons = new HashSet<>();
    private final static List<Integer> sales = Arrays.asList(10, 50, 60);
    private final Random random = new Random();

    static {
        range(0, 10).mapToObj(coupons::add).collect(Collectors.toList());
    }


    public ResponseDto checkCoupon(Long couponId, Double price) {
        return coupons.contains(couponId) ? ResponseDto.builder().message("Coupon find")
                .price(price*(100-sales.get(random.nextInt(sales.size()-1)))/100).build()
                : ResponseDto.builder().message("Coupon not found").price(price).build();

    }


}
