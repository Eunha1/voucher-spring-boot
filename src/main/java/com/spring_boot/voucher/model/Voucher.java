package com.spring_boot.voucher.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "voucher")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Voucher {
    @Id
    private String id;

    private String title;

    @Column(columnDefinition = "text")
    private String description;

    private String image;

    @Column(nullable = false)
    private Integer maxUsage;

    @Column(nullable = false)
    private Integer typeVoucher;

    @Column(nullable = false)
    private Integer typeDiscount;

    @Column(nullable = false)
    private String discountValue;

    @Column(nullable = false)
    private Integer durationLimit;

    @Column(nullable = false)
    private Integer dailyLimit;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json", nullable = false)
    private JsonNode appliedMachine;

    @ManyToOne
    @JoinColumn(name = "applied_position", nullable = false)
    @JsonIgnoreProperties({"position", "vouchers"})
    private Position position;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json")
    private JsonNode applied_slot;

    private Integer status;

    private Integer count;

    @OneToOne
    @JoinColumn(name = "owner", nullable = false)
    @JsonIgnoreProperties({"admin", "vouchers"})
    private Admin admin;

    @Column(nullable = false)
    private LocalDateTime startAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "voucher")
    @JsonIgnoreProperties({"userVoucher", "user", "voucher"})
    private Set<UserVoucher> userVoucher = new HashSet<>();
}
