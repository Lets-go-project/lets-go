package com.example.letsGo.domain.market;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@Setter
@Getter
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order implements Serializable {
    @Id
    private Long orderId;
    private Double price;
    private Date date;
    private int status;
    private String name;
    private int zipcode;
    private String address;
    private String address2;
    private String phone;
    private String req;
}