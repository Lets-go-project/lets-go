package domain.market;

import domain.common.BaseEntity;
import domain.enums.ProductsType;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private ProductsType productType;

    private String productName;

    private int productPrice;

    private int productSellPrice;

    private boolean productState;

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
