package com.example.financial_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assets")
public class AssetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long asset_id;
    @Column(nullable = false)
    private String assetName;
    @Column(nullable = false)
    private double assetPrice;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<StockEntity> stockEntities;

    @OneToMany
    private List<LoanEntity> loanEntities;

    @OneToMany
    private List<InvestmentEntity> investmentEntities;
}
