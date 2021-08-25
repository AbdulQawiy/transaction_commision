package com.solution.test.controller;

import com.solution.test.dao.TransactionDao;
import com.solution.test.exception.BadRequestException;
import com.solution.test.model.TransactionResult;
import com.solution.test.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/transaction")
public class transactionController {

    @Autowired
    private TransactionDao transactionDao;

    @Value("${spring.security.authorization}")
    private String auth;

    @GetMapping(value = "/details", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionResult> getTransactionDetails(@RequestHeader(value = "clientIds", required = false) String clientIds,
                                                         @RequestHeader(value = "authorization", required = false) String authorization) throws RestClientException, SQLException {

        if (authorization.isEmpty() || !authorization.equals(auth)) {
            throw new BadRequestException("400", "Unauthorized action");
        }

        if (clientIds == null || clientIds.isEmpty() || clientIds.equals("ALL")) {
            return transactionDao.findTransactionByCustomerId();
        } else if (clientIds.contains(",")) {
            return transactionDao.findTransactionByCustomerIds(clientIds);
        } else if (!clientIds.contains(",")) {
            return transactionDao.findTransactionByCustomerId(Long.parseLong(clientIds));
        }
        throw new BadRequestException("400", "Invalid input");
    }

}
