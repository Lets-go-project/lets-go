package com.example.letsGo.domain.market;

import com.example.letsGo.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product extends BaseEntity {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

//    @Enumerated(EnumType.STRING)
//    private ProductsType productType;
    private int productType;

    private String productName;

    private int productPrice;

    private int productSellPrice;

    private int productState;

    private String productDescription;

    private String productImg;

    private String productSemiImg;

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
