package io.github.mscmmc.financialcontrol.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entidade para a transação financeira.
 * Um gasto ou receita relacionado a uma categoria.
 */
@Entity //< Apenas classes anotadas com @Entity entram no contexto de persistência do Hibernate.
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Description cannot be empty")
    private String description;

    @NotNull(message="Amout is required")
    @Positive(message="Amount must be positive")
    private BigDecimal amount; //< BigDecimal: precisão matemática

    @NotNull(message="Date is required")
    private LocalDate date;

    //! Cria uma coluna "category_id" na tabela de "transactions"
    @ManyToOne(optional = false) //< Transaction possui UMA categoria
    @JoinColumn(name = "category_id")
    private Category category;

    /// Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
