package ir.digixo.service;


import ir.digixo.discount.Coupon;
import ir.digixo.discount.DiscountClient;
import ir.digixo.dto.ProductRequest;
import ir.digixo.entity.Product;

import ir.digixo.notification.NoticationRequest;
import ir.digixo.notification.NotificationClient;
import ir.digixo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private NotificationClient notificationClient;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscountClient discountClient;

    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product(productRequest.getName(), productRequest.getDescription(), productRequest.getPrice());


        //without load Balance
        //Coupon coupon = restTemplate.getForObject("http://localhost:8085/api/v1/coupons/{code}", Coupon.class,productRequest.getCode())
        //with load Balance
        //Coupon coupon = restTemplate.getForObject("http://DISCOUNT/api/v1/coupons/{code}", Coupon.class,productRequest.getCode());
        //with FeignClient
        Coupon coupon = discountClient.getDiscount(productRequest.getCode());
        BigDecimal subtract = new BigDecimal("100").subtract(coupon.getDiscount());
        product.setPrice(subtract.multiply(product.getPrice()).divide(new BigDecimal("100")));
        Product save = productRepository.save(product);
        this.sendSms(save);
        return save;
    }

    public List<Product> findByName(String name){
        return productRepository.findByName(name);
    }

    public void sendSms(Product save){
        var notifi = new NoticationRequest();
        notifi.setMessage("add request : " + save.getId());
        notifi.setSender("product");
        notifi.setSenderAt(LocalDateTime.now());

        notificationClient.addNotification(notifi);

    }

}
