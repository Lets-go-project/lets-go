package com.example.letsGo.domain.market;

import com.example.letsGo.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.context.annotation.Primary;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Builder
@Setter
@Getter
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product extends BaseEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Size(max = 100)
    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Size(max = 50)
    @Column(name = "product_type", nullable = false, length = 50)
    private int productType;

    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @Size(max = 500)
    @Column(name = "product_description", length = 500)
    private String productDescription;

    @Column(name = "product_price", nullable = false)
    private Double productPrice;

    @Column(name = "product_sell_price", nullable = false)
    private Double productSellPrice;

    @Column(name = "product_img")
    private String productImg;

    @Column(name = "product_semi_img")
    private String productSemiImg;

    @Size(max = 50)
    @Column(name = "product_state", nullable = false, length = 50)
    private String productState;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productType=" + productType +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productSellPrice=" + productSellPrice +
                ", productState=" + productState +
                ", productDescription='" + productDescription + '\'' +
                ", productImg='" + productImg + '\'' +
                ", productSemiImg='" + productSemiImg + '\'' +
                '}';
    }
}
