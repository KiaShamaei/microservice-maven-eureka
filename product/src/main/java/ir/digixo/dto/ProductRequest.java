package ir.digixo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductRequest {
    @JsonProperty("name")
    private String name;
    private String description;
    private BigDecimal price;
    private String code;
}
