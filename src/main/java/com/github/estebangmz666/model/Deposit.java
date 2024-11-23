package com.github.estebangmz666.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Deposit extends Transaction {

    public Deposit(UUID id, LocalDateTime date, BigDecimal amount, String description, Account destinationAccount) {
        super(id, date, amount, description, null, destinationAccount);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.DEPOSIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Deposit deposit = (Deposit) o;
        return getType() == deposit.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType());
    }
}