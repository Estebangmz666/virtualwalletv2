package com.github.estebangmz666.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class User extends Person {
    private ArrayList<Account> accounts;
    private ArrayList<Budget> budgets;

    public User(UUID id, String email, String password, String fullName, String direction, String cellphone, ArrayList<Account> accounts, ArrayList<Budget> budgets) {
        super(id, email, password, fullName, direction, cellphone);
        this.accounts = accounts;
        this.budgets = budgets;
    }

    public User() {
        super();
        this.accounts = new ArrayList<>();
        this.budgets = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(ArrayList<Budget> budgets) {
        this.budgets = budgets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(accounts, user.accounts) &&
                Objects.equals(budgets, user.budgets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accounts, budgets);
    }
}