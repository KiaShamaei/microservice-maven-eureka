package ir.digixo.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CouponRequestModel {
    private Long id;
    private String code;
    private BigDecimal discount;
    private LocalDate expiryDate;
}
