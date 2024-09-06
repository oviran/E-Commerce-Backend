package com.viran.ecom.entity;

import com.viran.ecom.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "email", length = 25)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "role")
    private UserRole role;

    @Lob
    @Column(name = "img", columnDefinition = "longblob")
    private byte[] img;

}