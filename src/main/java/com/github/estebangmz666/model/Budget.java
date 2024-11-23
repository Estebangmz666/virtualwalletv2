package com.github.estebangmz666.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Budget {
    private UUID id;
    private String name;
    private BigDecimal totalAmount;
    private BigDecimal spentAmount;
    private Category category;

    public Budget(UUID id, String name, BigDecimal totalAmount, BigDecimal spentAmount, Category category) {
        this.id = id;
        this.name = name;
        this.totalAmount = totalAmount;
        this.spentAmount = spentAmount;
        this.category = category;
    }

    public Budget() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(BigDecimal spentAmount) {
        this.spentAmount = spentAmount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        return Objects.equals(id, budget.id) &&
                Objects.equals(name, budget.name) &&
                Objects.equals(totalAmount, budget.totalAmount) &&
                Objects.equals(spentAmount, budget.spentAmount) &&
                category == budget.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, totalAmount, spentAmount, category);
    }
}