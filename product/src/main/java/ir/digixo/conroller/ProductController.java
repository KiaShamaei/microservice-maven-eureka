package ir.digixo.conroller;

import ir.digixo.dto.ProductRequest;

import ir.digixo.entity.Product;
import ir.digixo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product createProduct(@RequestBody ProductRequest productRequest){

        log.info("new product created {}",productRequest);
      return productService.createProduct(productRequest);

    }
}
