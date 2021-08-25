package com.solution.test.dao;

import com.solution.test.model.TransactionResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionResultRepo extends MongoRepository<TransactionResult, Long> {

}
