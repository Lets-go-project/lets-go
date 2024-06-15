package com.example.letsGo.domain.market;

import com.example.letsGo.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table
public class SalesManager extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "sales_manager_id")
    private Long salesManagerId;

    @Size(max = 100)
//    @Column(name = "name", nullable = false, length = 100)
    private String name;

//    @OneToMany(mappedBy = "salesManager")
//    private List<Product> products = new ArrayList<>();
}
