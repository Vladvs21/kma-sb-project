package com.example.financial_manager.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loans")
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loan_id;
    @Column(nullable = false)
    private String loanSource;
    @Column(nullable = false)
    private double loanAmount;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "asset_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.NO_ACTION)
//    private AssetEntity assetEntity;
}
