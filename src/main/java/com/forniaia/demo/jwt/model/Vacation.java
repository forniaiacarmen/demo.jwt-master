package com.forniaia.demo.jwt.model;

import com.forniaia.demo.jwt.enums.EVacationStatus;
import com.forniaia.demo.jwt.enums.EVacationType;
import com.forniaia.demo.jwt.user.User;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "VACATION")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private User user;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EVacationType vacationType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EVacationStatus status;

//    @Column(name = "created_at", updatable = false, nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", nullable = false)
//    private LocalDateTime updatedAt;
//
//    @Column(name = "created_by")
//    private String createdBy;
//
//    @Column(name = "updated_by")
//    private String updatedBy;
//
//    @PrePersist
//    public void prePersist() {
//        LocalDateTime now = LocalDateTime.now();
//        this.createdAt = now;
//        this.updatedAt = now;
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    // Getters and Setters
//    // ...
}
