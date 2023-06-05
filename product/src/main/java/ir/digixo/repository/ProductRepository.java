package ir.digixo.repository;

import ir.digixo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByName(String name);
}
