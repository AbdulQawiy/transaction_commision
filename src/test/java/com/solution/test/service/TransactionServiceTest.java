package com.solution.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.solution.test.dao.TransactionDao;
import com.solution.test.model.TransactionResult;
import com.solution.test.model.Transactions;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TransactionService.class, TransactionDao.class, TransactionResultService.class})
@ExtendWith(SpringExtension.class)
public class TransactionServiceTest {
    @MockBean
    private TransactionDao transactionDao;

    @MockBean
    private TransactionResultService transactionResultService;

    @Autowired
    private TransactionService transactionService;

    @Test
    public void testGetCustomerTransaction() throws SQLException, ParseException {
        when(this.transactionDao.findCustomerTransactionByCustomerIds((List<Long>) any()))
                .thenReturn(new HashMap<Long, List<Transactions>>(1));
        assertTrue(this.transactionService.getCustomerTransaction(new ArrayList<TransactionResult>(), "ALL").isEmpty());
        verify(this.transactionDao).findCustomerTransactionByCustomerIds((List<Long>) any());
    }

    @Test
    public void testGetCustomerTransaction2() throws SQLException, ParseException {
        HashMap<Long, List<Transactions>> resultLongListMap = new HashMap<Long, List<Transactions>>(1);
        resultLongListMap.put(0L, new ArrayList<Transactions>());
        when(this.transactionDao.findCustomerTransactionByCustomerIds((List<Long>) any())).thenReturn(resultLongListMap);
        HashMap<Long, Float> actualCustomerTransaction = this.transactionService
                .getCustomerTransaction(new ArrayList<TransactionResult>(), "ALL");
        assertEquals(1, actualCustomerTransaction.size());
        Float expectedGetResult = new Float(0.0f);
        assertEquals(expectedGetResult, actualCustomerTransaction.get(0L));
        verify(this.transactionDao).findCustomerTransactionByCustomerIds((List<Long>) any());
    }

    @Test
    public void testGetCustomerTransaction3() throws SQLException, ParseException {
        when(this.transactionDao.findCustomerTransactionByCustomerIds((List<Long>) any()))
                .thenReturn(new HashMap<Long, List<Transactions>>(1));
        assertTrue(this.transactionService.getCustomerTransaction(new ArrayList<TransactionResult>(), ",").isEmpty());
        verify(this.transactionDao).findCustomerTransactionByCustomerIds((List<Long>) any());
    }

    @Test
    public void testGetCustomerTransaction4() throws SQLException, ParseException {
        when(this.transactionDao.findCustomerTransactionByCustomerIds((List<Long>) any()))
                .thenReturn(new HashMap<Long, List<Transactions>>(1));
        assertTrue(this.transactionService.getCustomerTransaction(new ArrayList<TransactionResult>(), "42").isEmpty());
        verify(this.transactionDao).findCustomerTransactionByCustomerIds((List<Long>) any());
    }
}

