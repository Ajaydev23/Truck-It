package com.aj23.truckit_admin.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
}
