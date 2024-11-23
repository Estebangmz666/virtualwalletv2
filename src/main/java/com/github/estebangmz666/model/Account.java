package com.github.estebangmz666.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Account {
    private UUID id;
    private String number;
    private AccountType type;
    private BigDecimal balance;
    private User referenceUser;

    public Account(UUID id, String number, AccountType type, BigDecimal balance, User referenceUser) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.referenceUser = referenceUser;
    }

    public Account() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getReferenceUser() {
        return referenceUser;
    }

    public void setReferenceUser(User referenceUser) {
        this.referenceUser = referenceUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(number, account.number) &&
                type == account.type &&
                Objects.equals(balance, account.balance) &&
                Objects.equals(referenceUser, account.referenceUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, type, balance, referenceUser);
    }
}