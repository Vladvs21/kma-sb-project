package com.example.financial_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stock_id;
    @Column(nullable = false)
    private String nameOfCompany;
    @Column(nullable = false)
    private double price;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<AssetEntity> assetEntities;
}
