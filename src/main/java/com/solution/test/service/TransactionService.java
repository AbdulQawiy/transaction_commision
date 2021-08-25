package com.solution.test.service;

import com.solution.test.config.ConnectionInfo;
import com.solution.test.dao.TransactionDao;
import com.solution.test.dao.TransactionResultRepo;
import com.solution.test.exception.BadRequestException;
import com.solution.test.exception.NotFoundException;
import com.solution.test.model.CustomerCommission;
import com.solution.test.model.FeeWages;
import com.solution.test.model.TransactionResult;
import com.solution.test.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private TransactionResultService transactionResultService;

    //for ALL
    public List<TransactionResult> findSingleTransactionByCustomerId() throws SQLException, ParseException {
        try {
            List<TransactionResult> resultWithCommission = new ArrayList<>();
            List<TransactionResult> results =  transactionDao.findTransactionByCustomerId();
            if(results == null || results.isEmpty()){
                throw new NotFoundException("404", "No results found");
            }
            HashMap<Long, Float> customerCommissions = getCustomerTransaction(results, "ALL");
            //we now map fee commissions to transactionResult by customer id being the hashmap key
            for(TransactionResult transactionResult: results){
                transactionResult.setTransactionFeeValue(customerCommissions.get(transactionResult.getCustomerId()).toString());
                resultWithCommission.add(transactionResult);
            }

            transactionResultService.logActionResult(resultWithCommission);

            return resultWithCommission;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //for a single customer id
    public List<TransactionResult> findTransactionByCustomerId(Long customerId) throws SQLException, ParseException {
        try {
            List<TransactionResult> resultWithCommission = new ArrayList<>();
            List<TransactionResult> results = transactionDao.findTransactionByCustomerId(customerId);
            if(results == null || results.isEmpty()){
                throw new NotFoundException("404", "No results found");
            }
            //calculate commission per individual
            HashMap<Long, Float> customerCommissions = getCustomerTransaction(results, customerId.toString());

            //we now map fee commissions to transactionResult by customer id being the hashmap key
            for(TransactionResult transactionResult: results){
                transactionResult.setTransactionFeeValue(customerCommissions.get(transactionResult.getCustomerId()).toString());
                resultWithCommission.add(transactionResult);
            }

            transactionResultService.logActionResult(resultWithCommission);

            return resultWithCommission;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //for ids separated by commas
    public List<TransactionResult> findTransactionByCustomerIds(String customerIds) throws SQLException, ParseException {
        try {

            List<TransactionResult> resultWithCommission = new ArrayList<>();
            List<TransactionResult> results =  transactionDao.findTransactionByCustomerIds(customerIds);
            if(results == null || results.isEmpty()){
                throw new NotFoundException("404", "No results found");
            }
            HashMap<Long, Float> customerCommissions = getCustomerTransaction(results, customerIds);

            //we now map fee commissions to transactionResult by customer id being the hashmap key
            for(TransactionResult transactionResult: results){
                transactionResult.setTransactionFeeValue(customerCommissions.get(transactionResult.getCustomerId()).toString());
                resultWithCommission.add(transactionResult);
            }

            transactionResultService.logActionResult(resultWithCommission);

            return resultWithCommission;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public HashMap<Long, Float> getCustomerTransaction(List<TransactionResult> transactionResultList, String customerIds) throws SQLException, ParseException {

        HashMap<Long, Float> result = new HashMap<>();
        Map<Long, List<Transactions>> transactions = new HashMap<>(Collections.emptyMap());
        if(customerIds.equalsIgnoreCase("ALL")){
            //get uniqueCustomerIds
            List<Long> uniqueCustomerIds = transactionResultList.stream().map(TransactionResult::getCustomerId).collect(Collectors.toList());

            //get each transaction for each customer
            transactions = transactionDao.findCustomerTransactionByCustomerIds(uniqueCustomerIds);
        }
        else {
            //get uniqueCustomerIds
            List<Long> uniqueCustomerIds = new ArrayList<>();
            if(customerIds.contains(",")){
                String[] customerIdArray = customerIds.replaceAll("\\s+","").trim().split(",");
                for(String custId :customerIdArray){
                    uniqueCustomerIds.add(Long.parseLong(custId));
                }
            }
            else {
                uniqueCustomerIds.add(Long.parseLong(customerIds));
            }

            //get each transaction for each customer
            transactions = transactionDao.findCustomerTransactionByCustomerIds(uniqueCustomerIds);
        }

        //no get total commissions for each customer
        for (Map.Entry<Long, List<Transactions>> transactionPerCustomer : transactions.entrySet()) {
            Float commissionSum = 0f;
            for(Transactions customerTransaction: transactionPerCustomer.getValue()){
                commissionSum = commissionSum + Float.parseFloat(customerTransaction.getTransactionPercentageCommission());
            }
            result.put(transactionPerCustomer.getKey(), commissionSum);
        }

        return result;
    }

}
