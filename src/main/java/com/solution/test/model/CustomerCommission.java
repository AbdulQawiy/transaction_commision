package com.solution.test.model;

public class CustomerCommission {
    Long customerId;
    Float transactionFee;

    public CustomerCommission(Long customerId, Float transactionFee) {
        this.customerId = customerId;
        this.transactionFee = transactionFee;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Float getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(Float transactionFee) {
        this.transactionFee = transactionFee;
    }
}
