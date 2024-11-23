package com.github.estebangmz666.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Transfer extends Transaction {

    public Transfer(UUID id, LocalDateTime date, BigDecimal amount, String description, Account sourceAccount, Account destinationAccount) {
        super(id, date, amount, description, sourceAccount, destinationAccount);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.TRANSFER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Transfer transfer = (Transfer) o;
        return getType() == transfer.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType());
    }
}