package com.example.ShopHandmade.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "account_id", nullable = false)
    private short accountId;

    @Column(name = "order_date_time", columnDefinition = "DATETIME", updatable = false, nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "status", columnDefinition = "VARCHAR(10)", updatable = true, nullable = false)
    private String status;

    @Column(name = "address", nullable = false)
    private String address;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<OrderItemEntity> listOrderItems;

    public static class ORDER_STATUS {
        public static final String PENDING = "PENDING";
        public static final String DELIVERED = "DELIVERED";
        public static final String CANCELLED = "CANCELLED";
    }
}
