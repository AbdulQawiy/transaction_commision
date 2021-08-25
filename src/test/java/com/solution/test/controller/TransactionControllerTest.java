package com.solution.test.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.solution.test.exception.BadRequestException;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClientException;

public class TransactionControllerTest {
    @Test
    public void testGetTransactionDetails() throws SQLException, ParseException, RestClientException {
        assertThrows(BadRequestException.class,
                () -> (new TransactionController()).getTransactionDetails("Client Ids", "JaneDoe"));
        assertThrows(BadRequestException.class,
                () -> (new TransactionController()).getTransactionDetails("Client Ids", ""));
    }
}

