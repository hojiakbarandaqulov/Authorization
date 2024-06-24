package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.enums.ProfileRole;
import org.example.enums.ProfileStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "profile")
@Data
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ProfileRole role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProfileStatus status;

    @Column(name = "visible")
    private Boolean visible=Boolean.TRUE;

}
