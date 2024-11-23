package com.github.estebangmz666.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Withdrawal extends Transaction {

    public Withdrawal(UUID id, LocalDateTime date, BigDecimal amount, String description, Account sourceAccount) {
        super(id, date, amount, description, sourceAccount, null);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.WITHDRAWAL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Withdrawal that = (Withdrawal) o;
        return getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType());
    }
}