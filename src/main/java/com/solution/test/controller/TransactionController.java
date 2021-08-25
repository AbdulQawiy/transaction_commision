package com.solution.test.controller;

import com.solution.test.dao.TransactionDao;
import com.solution.test.exception.BadRequestException;
import com.solution.test.model.TransactionResult;
import com.solution.test.model.Transactions;
import com.solution.test.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Value("${spring.security.authorization}")
    private String auth;

    @GetMapping(value = "/details", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionResult> getTransactionDetails(@RequestHeader(value = "clientIds", required = false) String clientIds,
                                                         @RequestHeader(value = "authorization", required = false) String authorization) throws RestClientException, SQLException, ParseException {

        if (authorization.isEmpty() || !authorization.equals(auth)) {
            throw new BadRequestException("400", "Unauthorized action");
        }

        if (clientIds == null || clientIds.isEmpty() || clientIds.equals("ALL")) {
            return transactionService.findSingleTransactionByCustomerId();
        } else if (clientIds.contains(",")) {
            return transactionService.findTransactionByCustomerIds(clientIds);
        } else if (!clientIds.contains(",")) {
            return transactionService.findTransactionByCustomerId(Long.parseLong(clientIds));
        }
        throw new BadRequestException("400", "Invalid input");
    }

}
