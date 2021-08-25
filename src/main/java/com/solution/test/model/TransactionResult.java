package com.solution.test.model;

public class TransactionResult {

    Long numberOfTransaction;
    Long totalTransactionValue;
    String transactionFeeValue;
    String customerFirstName;
    Long customerId;
    String customerLastName;
    String transactionLastDate;

    public TransactionResult(Long numberOfTransaction, Long totalTransactionValue, String transactionFeeValue, String customerFirstName, Long customerId, String customerLastName, String transactionLastDate) {
        this.numberOfTransaction = numberOfTransaction;
        this.totalTransactionValue = totalTransactionValue;
        this.transactionFeeValue = transactionFeeValue;
        this.customerFirstName = customerFirstName;
        this.customerId = customerId;
        this.customerLastName = customerLastName;
        this.transactionLastDate = transactionLastDate;
    }

    public TransactionResult(){}

    public Long getNumberOfTransaction() {
        return numberOfTransaction;
    }

    public void setNumberOfTransaction(Long numberOfTransaction) {
        this.numberOfTransaction = numberOfTransaction;
    }

    public Long getTotalTransactionValue() {
        return totalTransactionValue;
    }

    public void setTotalTransactionValue(Long totalTransactionValue) {
        this.totalTransactionValue = totalTransactionValue;
    }

    public String getTransactionFeeValue() {
        return transactionFeeValue;
    }

    public void setTransactionFeeValue(String transactionFeeValue) {
        this.transactionFeeValue = transactionFeeValue;
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

    public String getTransactionLastDate() {
        return transactionLastDate;
    }

    public void setTransactionLastDate(String transactionLastDate) {
        this.transactionLastDate = transactionLastDate;
    }

}
