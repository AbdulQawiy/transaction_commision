package com.solution.test.model;

public class Transactions {

    Long transactionId;
    String transactionAmount;
    String customerFirstName;
    Long customerId;
    String customerLastName;
    String transactionDate;
    String transactionPercentageCommission;

    public Transactions(){}
    public Transactions(Long transactionId, String transactionAmount, String customerFirstName, Long customerId, String customerLastName, String transactionDate, String transactionPercentageCommission) {
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.customerFirstName = customerFirstName;
        this.customerId = customerId;
        this.customerLastName = customerLastName;
        this.transactionDate = transactionDate;
        this.transactionPercentageCommission = transactionPercentageCommission;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionPercentageCommission() {
        return transactionPercentageCommission;
    }

    public void setTransactionPercentageCommission(String transactionPercentageCommission) {
        this.transactionPercentageCommission = transactionPercentageCommission;
    }
}
