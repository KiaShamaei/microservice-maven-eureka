package ir.digixo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Coupon {

    private Long id;
    private String code;
    private BigDecimal discount;
    private LocalDate expiryDate;


}
