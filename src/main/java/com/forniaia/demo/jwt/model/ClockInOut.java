package com.forniaia.demo.jwt.model;

import com.forniaia.demo.jwt.enums.ETimeEntryType;
import com.forniaia.demo.jwt.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "CLOCKINOUT")
public class ClockInOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID autogenerado como clave primaria


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Assuming you have an "Employee" entity.

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ETimeEntryType type;  // Assuming TimeEntryType is an enum.

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


}
