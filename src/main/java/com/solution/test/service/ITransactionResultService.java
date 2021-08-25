package com.solution.test.service;

import com.solution.test.model.TransactionResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITransactionResultService {
    void logActionResult(List<TransactionResult> transactionResultList);
}

