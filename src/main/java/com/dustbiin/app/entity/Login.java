package com.dustbiin.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_pass")
    private String password;
    @Column(name = "phone_numb")
    private String phoneNumb;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_type")
    private Byte userType;
    @Column(name = "status")
    private Byte status;
    @Column(name = "last_login_date")
    private Date lastLoginDate;
}
