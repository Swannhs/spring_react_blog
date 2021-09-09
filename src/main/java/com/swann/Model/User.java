package com.swann.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Username is required")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    private Date createdAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
}
