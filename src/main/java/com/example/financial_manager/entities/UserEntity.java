package com.example.financial_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long id;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;

//    @OneToMany
//    private List<ExpenseEntity> expenses;
//
//    @OneToMany
//    private List<IncomeEntity> incomes;
//
//    @OneToMany
//    private List<StockEntity> stocks;
//
//    @OneToMany
//    @JoinColumn(name = "userId", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<LoanEntity> loans;

}
