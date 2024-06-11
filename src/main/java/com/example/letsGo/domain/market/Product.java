package com.example.letsGo.domain.market;

import com.example.letsGo.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product extends BaseEntity implements Serializable {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private int productType;

    private String productName;

    private int productPrice;

    private int productSellPrice;

    private int productState;

    private String productDescription;

    private String productImg;

    private String productSemiImg;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
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
