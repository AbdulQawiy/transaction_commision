package com.solution.test.service;

import com.solution.test.dao.TransactionResultRepo;
import com.solution.test.model.TransactionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionResultService implements ITransactionResultService {

    @Autowired
    private TransactionResultRepo transactionResultRepo;

    public void logActionResult (List<TransactionResult> transactionResultList){
        transactionResultRepo.saveAll(transactionResultList);
    }
}
