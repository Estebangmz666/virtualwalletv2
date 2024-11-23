package com.github.estebangmz666.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ExchangeRate {
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal rate;
    private LocalDateTime updatedAt;

    public ExchangeRate(String currencyFrom, String currencyTo, BigDecimal rate, LocalDateTime updatedAt) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.rate = rate;
        this.updatedAt = updatedAt;
    }

    public ExchangeRate() {
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRate that = (ExchangeRate) o;
        return Objects.equals(currencyFrom, that.currencyFrom) &&
                Objects.equals(currencyTo, that.currencyTo) &&
                Objects.equals(rate, that.rate) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyFrom, currencyTo, rate, updatedAt);
    }
}