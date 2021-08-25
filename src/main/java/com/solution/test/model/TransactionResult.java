package com.solution.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties
@Document
public class TransactionResult {

    @Transient
    public static final String SEQUENCE_NAME = "transaction_commission_result";

    @Id
    String id;
    Long numberOfTransaction;
    Long totalTransactionValue;
    String transactionFeeValue;
    String customerFirstName;
    Long customerId;
    String customerLastName;
    String transactionLastDate;
    String dateOfCommissionCalculation;

    public TransactionResult(String id, Long numberOfTransaction, Long totalTransactionValue, String transactionFeeValue, String customerFirstName, Long customerId, String customerLastName, String transactionLastDate, String dateOfCommissionCalculation) {
        this.id = id;
        this.numberOfTransaction = numberOfTransaction;
        this.totalTransactionValue = totalTransactionValue;
        this.transactionFeeValue = transactionFeeValue;
        this.customerFirstName = customerFirstName;
        this.customerId = customerId;
        this.customerLastName = customerLastName;
        this.transactionLastDate = transactionLastDate;
        this.dateOfCommissionCalculation = dateOfCommissionCalculation;
    }

    public TransactionResult(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getDateOfCommissionCalculation() {
        return dateOfCommissionCalculation;
    }

    public void setDateOfCommissionCalculation(String dateOfCommissionCalculation) {
        this.dateOfCommissionCalculation = dateOfCommissionCalculation;
    }
}
