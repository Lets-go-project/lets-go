package com.example.letsGo.domain.member;

import com.example.letsGo.domain.salesmanager.SalesManager;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "Member")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_sequence")
    @SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence", allocationSize = 1)
    @Column(name = "USER_ID")
    private int user_Id;
    private String id;
    private String password;
    private String name;
    private String gender;
    private String email;
    private Date birth;
    private String address;
    private boolean isSalesManager;
    private String profilePicture;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SalesManager salesManager;
}