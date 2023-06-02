package ir.digixo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
    @SequenceGenerator(name = "product_seq",allocationSize = 10)
    private Long id;
    @JsonProperty("name")
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private BigDecimal price;


    public Product() {

    }
}
