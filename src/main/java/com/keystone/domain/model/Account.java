package com.keystone.domain.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.ColumnDefault;

import com.keystone.common.enumerate.ProjectRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Account {
    
    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 64)
    @Size(max = 64, message = "Username must be at most 64 characters long")
    private String fullName;

    @Column(nullable = false)
    @Size(min = 4, max= 12 , message = "Password must be between 4 and 12 characters long")
    private String password;

    @Column(nullable = false)
    @Size(min = 4, max= 12 , message = "ConfirmPassword must be between 4 and 12 characters long")
    private String Confirmpassword;

    @Column (nullable = false, length = 254, unique = true)
    @NotBlank 
    @Email 
    private String email;

    @ColumnDefault("VIEWER")
    private ProjectRole role;

    @NotBlank 
    @Column (nullable = false)
    private boolean enabled;

    @NotBlank 
    @Column (nullable = false)
    private LocalDateTime createdAt;

    @NotBlank 
    @Column (nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist 
    public LocalDateTime OnCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        return createdAt;
    }

    @PreUpdate 
    public LocalDateTime OnUpdate() {
        this.updatedAt = LocalDateTime.now();
        return updatedAt;
    }
}
