package ir.digixo.discount;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("http://DISCOUNT")
public interface DiscountClient {
    @GetMapping("api/v1/coupons/{input}")
    public Coupon getDiscount(@PathVariable("input") String input);

}
