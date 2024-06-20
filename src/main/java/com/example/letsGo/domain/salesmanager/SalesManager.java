package com.example.letsGo.domain.salesmanager;

import com.example.letsGo.domain.common.BaseEntity;
import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "SALES_MANAGER")
public class SalesManager extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_manager_id")
    private Long salesManagerId;

    @Size(max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "salesManager")
    private List<Product> products = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User member;
}
