package com.spring_boot.voucher.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @Id
    private String id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String phone;

    private Integer status = 1;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    @JsonIgnoreProperties({"admin", "users"})
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    @JsonIgnoreProperties({"position", "users"})
    private Position position;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"userVoucher", "user", "voucher"})
    private Set<UserVoucher> userVoucher = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
