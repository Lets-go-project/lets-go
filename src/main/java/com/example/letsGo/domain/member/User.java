package com.example.letsGo.domain.member;

import com.example.letsGo.domain.market.Cart;
import com.example.letsGo.domain.market.SalesManager;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "Member")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String id;

    private String password;

    private String name;

    private String gender;

    @Email
    private String email;

    private Date birth;

    private String address;

    @Column(name = "ISSALESMANAGER", columnDefinition = "int default 0")
    private int isSalesManager;

    private String profilePicture;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SalesManager salesManager;

}
