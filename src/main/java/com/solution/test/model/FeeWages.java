package com.solution.test.model;

public class FeeWages {

    Long transactionValueLessThan;
    String feePercentageOfTransactionValue;

    public FeeWages(){}

    public FeeWages(Long transactionValueLessThan, String feePercentageOfTransactionValue) {
        this.transactionValueLessThan = transactionValueLessThan;
        this.feePercentageOfTransactionValue = feePercentageOfTransactionValue;
    }

    public Long getTransactionValueLessThan() {
        return transactionValueLessThan;
    }

    public void setTransactionValueLessThan(Long transactionValueLessThan) {
        this.transactionValueLessThan = transactionValueLessThan;
    }

    public String getFeePercentageOfTransactionValue() {
        return feePercentageOfTransactionValue;
    }

    public void setFeePercentageOfTransactionValue(String feePercentageOfTransactionValue) {
        this.feePercentageOfTransactionValue = feePercentageOfTransactionValue;
    }
}
