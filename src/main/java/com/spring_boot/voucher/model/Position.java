package com.spring_boot.voucher.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Position {
    @Id
    private String id;

    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "position")
    @JsonIgnoreProperties({"users", "position"})
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "position")
    @JsonIgnoreProperties({"vouchers", "position"})
    private List<Voucher> vouchers = new ArrayList<>();
}
