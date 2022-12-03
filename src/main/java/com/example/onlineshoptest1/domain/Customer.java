package com.example.onlineshoptest1.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 250, nullable = false)
    private String description;
    @Column(length = 50, nullable = false)
    private String email;



    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}