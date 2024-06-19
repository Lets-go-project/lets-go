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

/*
package com.example.letsGo.domain.member;

import com.example.letsGo.domain.market.SalesManager;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Memeber")
public class User {
    @Id
    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsSalesManager() {
        return isSalesManager;
    }
    public void setIsSalesManager(boolean isSalesManager) {
        this.isSalesManager = isSalesManager;
    }
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
*/