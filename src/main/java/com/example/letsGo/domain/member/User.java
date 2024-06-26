package com.example.letsGo.domain.member;

import com.example.letsGo.domain.salesmanager.SalesManager;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
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
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_sequence")
//    @SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

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