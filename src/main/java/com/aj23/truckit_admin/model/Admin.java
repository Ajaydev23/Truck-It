package com.aj23.truckit_admin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    @Email
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private UserType userType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    private Boolean activeStatus;

    private Boolean deleteStatus;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date modifiedAt;

    private Integer updatedBy;

    private Integer createdBy;

}
