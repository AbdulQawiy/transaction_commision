package com.solution.test.dao;

import com.solution.test.config.ConnectionInfo;
import com.solution.test.exception.BadRequestException;
import com.solution.test.model.FeeWages;
import com.solution.test.model.TransactionResult;
import com.solution.test.model.Transactions;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.Date;

@Repository
public class TransactionDao {

    public static Connection getNewConnection(){
        ConnectionInfo connectionInfo;
        Connection conn = null;
        try {
            connectionInfo = new ConnectionInfo();
            conn = connectionInfo.getConnectionInfo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static void createRecords() throws SQLException {
        try {

            Connection conn = getNewConnection();
            DatabaseMetaData checkTransactionTable = conn.getMetaData();
            ResultSet tables = checkTransactionTable.getTables(null, null, "transactions", null);
            if (!tables.next()) {
                // Table does not exists
                String createTransactionTable = "CREATE TABLE `transactions` (\n" +
                        "          `transaction_id` bigint(20) NOT NULL,\n" +
                        "          `transaction_amount` varchar(30) NOT NULL,\n" +
                        "          `customer_first_name` varchar(50) NOT NULL,\n" +
                        "          `customer_id` bigint(20) NOT NULL,\n" +
                        "          `customer_last_name` varchar(50) NOT NULL,\n" +
                        "          `transaction_date` varchar(50) NOT NULL\n" +
                        "        )";

                Statement statement1 = conn.createStatement();
                statement1.executeUpdate(createTransactionTable);

                String createTransactionTableData = "INSERT INTO `transactions` (`transaction_id`, `transaction_amount`, `customer_first_name`, `customer_id`, `customer_last_name`, `transaction_date`) VALUES\n" +
                        "                (777, '243,33', 'Andrzej', 1, 'Andrzejowski', '11.12.2020 14:57:22'),\n" +
                        "                (778, '199,11', 'Andrzej', 1, 'Andrzejowski', '01.12.2020 13:22:11'),\n" +
                        "                (779, '33,11', 'Andrzej', 1, 'Andrzejowski', '01.12.2020 13:22:12'),\n" +
                        "                (780, '221,33', 'Andrzej', 1, 'Andrzejowski', '01.12.2020 13:22:13'),\n" +
                        "                (800, '999,99', 'Andrzej', 1, 'Andrzejowski', '15.12.2020 11:12:47'),\n" +
                        "                (782, '322,12', 'Andrzej', 1, 'Andrzejowski', '08.12.2020 09:00:00'),\n" +
                        "                (799, '332,11', 'Andrzej', 1, 'Andrzejowski', '11.12.2020 14:57:22'),\n" +
                        "                (798, '345,67', 'Andrzej', 1, 'Andrzejowski', '11.12.2020 14:57:23'),\n" +
                        "                (797, '44,22', 'Andrzej', 1, 'Andrzejowski', '11.12.2020 14:57:24'),\n" +
                        "                (796, '1,22', 'Andrzej', 1, 'Andrzejowski', '11.12.2020 14:57:25'),\n" +
                        "                (795, '22,01', 'Andrzej', 1, 'Andrzejowski', '01.12.2020 23:00:21'),\n" +
                        "                (794, '32,99', 'Andrzej', 1, 'Andrzejowski', '01.12.2020 23:00:22'),\n" +
                        "                (793, '122,99', 'Andrzej', 1, 'Andrzejowski', '01.12.2020 23:00:23'),\n" +
                        "                (792, '32,00', 'Andrzej', 1, 'Andrzejowski', '01.12.2020 23:00:24'),\n" +
                        "                (791, '277,87', 'Andrzej', 1, 'Andrzejowski', '01.12.2020 23:00:25'),\n" +
                        "                (790, '99,00', 'Andrzej', 1, 'Andrzejowski', '01.12.2020 23:00:26'),\n" +
                        "                (789, '22,32', 'Andrzej', 1, 'Andrzejowski', '03.12.2020 22:21:01'),\n" +
                        "                (788, '755,21', 'Andrzej', 1, 'Andrzejowski', '03.12.2020 22:21:02'),\n" +
                        "                (787, '99,11', 'Andrzej', 1, 'Andrzejowski', '03.12.2020 22:21:03'),\n" +
                        "                (786, '29,22', 'Andrzej', 1, 'Andrzejowski', '03.12.2020 22:21:04'),\n" +
                        "                (785, '1,22', 'Andrzej', 1, 'Andrzejowski', '03.12.2020 22:21:05'),\n" +
                        "                (784, '322,22', 'Andrzej', 1, 'Andrzejowski', '03.12.2020 22:21:06'),\n" +
                        "                (783, '9,21', 'Andrzej', 1, 'Andrzejowski', '03.12.2020 22:21:07'),\n" +
                        "                (300, '212,00', 'Anna', 2, 'Zaradna', '01.12.2020 01:01:00'),\n" +
                        "                (301, '21,22', 'Anna', 2, 'Zaradna', '01.12.2020 01:01:01'),\n" +
                        "                (302, '10,05', 'Anna', 2, 'Zaradna', '01.12.2020 01:01:02'),\n" +
                        "                (303, '22,31', 'Anna', 2, 'Zaradna', '01.12.2020 01:01:03'),\n" +
                        "                (304, '15111,21', 'Anna', 2, 'Zaradna', '01.12.2020 01:01:04'),\n" +
                        "                (316, '20,00', 'Anna', 2, 'Zaradna', '29.12.2020 11:40:31'),\n" +
                        "                (306, '24,21', 'Anna', 2, 'Zaradna', '14.12.2020 06:53:00'),\n" +
                        "                (307, '37,77', 'Anna', 2, 'Zaradna', '14.12.2020 06:53:01'),\n" +
                        "                (308, '22,31', 'Anna', 2, 'Zaradna', '14.12.2020 06:53:02'),\n" +
                        "                (309, '5999,00', 'Anna', 2, 'Zaradna', '14.12.2020 06:53:03'),\n" +
                        "                (310, '100,01', 'Anna', 2, 'Zaradna', '14.12.2020 06:53:04'),\n" +
                        "                (311, '99,99', 'Anna', 2, 'Zaradna', '14.12.2020 06:53:05'),\n" +
                        "                (312, '88,02', 'Anna', 2, 'Zaradna', '21.12.2020 21:05:05'),\n" +
                        "                (313, '100,00', 'Anna', 2, 'Zaradna', '21.12.2020 21:05:06'),\n" +
                        "                (314, '24,21', 'Anna', 2, 'Zaradna', '21.12.2020 21:05:07'),\n" +
                        "                (315, '37,77', 'Anna', 2, 'Zaradna', '21.12.2020 21:05:08'),\n" +
                        "                (402, '5,00', 'Micha?', 3, 'Micha?owski', '29.12.2020 21:00:03'),\n" +
                        "                (111, '500,00', 'Jakub', 4, 'Jakubowski', '21.12.2020 13:21:00'),\n" +
                        "                (112, '30,50', 'Jakub', 4, 'Jakubowski', '31.12.2020 00:00:01'),\n" +
                        "                (113, '441,21', 'Jakub', 4, 'Jakubowski', '16.12.2020 07:21:30'),\n" +
                        "                (114, '10,00', 'Jakub', 4, 'Jakubowski', '16.12.2020 07:21:31'),\n" +
                        "                (115, '27,31', 'Jakub', 4, 'Jakubowski', '16.12.2020 07:21:32'),\n" +
                        "                (116, '1050,00', 'Jakub', 4, 'Jakubowski', '16.12.2020 07:21:33'),\n" +
                        "                (211, '999,00', 'Jacek', 5, 'Jackowski', '21.12.2020 14:00:05'),\n" +
                        "                (212, '244,77', 'Jacek', 5, 'Jackowski', '29.12.2020 05:05:20'),\n" +
                        "                (213, '200,01', 'Jacek', 5, 'Jackowski', '04.12.2020 11:31:20'),\n" +
                        "                (223, '250,21', 'Jacek', 5, 'Jackowski', '08.12.2020 14:00:01'),\n" +
                        "                (215, '99,99', 'Jacek', 5, 'Jackowski', '22.12.2020 22:00:00'),\n" +
                        "                (216, '1700,01', 'Jacek', 5, 'Jackowski', '22.12.2020 22:00:01')";

                Statement statement2 = conn.createStatement();
                int rows2 = statement2.executeUpdate(createTransactionTableData);
                if (rows2 > 0) {
                    //success data was created;
                }
            }


            DatabaseMetaData checkFeeWageTable = conn.getMetaData();
            ResultSet feeWageTable = checkFeeWageTable.getTables(null, null, "fee_wages", null);
            if (!feeWageTable.next()) {

                String feeWagesTable = "CREATE TABLE `fee_wages` (\n" +
                        "          `transaction_value_less_than` varchar(27) DEFAULT NULL,\n" +
                        "          `fee_percentage_of_transaction_value` varchar(35) DEFAULT NULL\n" +
                        "        )";

                Statement statement3 = conn.createStatement();
                statement3.executeUpdate(feeWagesTable);

                String createFeeWageTableData = "INSERT INTO `fee_wages` (`transaction_value_less_than`, `fee_percentage_of_transaction_value`) VALUES\n" +
                        "('1000', '3,5'),\n" +
                        "('2500', '2,5'),\n" +
                        "('5000', '1,1'),\n" +
                        "('10000', '0,1');";

                Statement statement4 = conn.createStatement();
                int rows2 = statement4.executeUpdate(createFeeWageTableData);
                if (rows2 > 0) {
                    //success data was created;
                }

                conn.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //for a single customer id
    public List<TransactionResult> findTransactionByCustomerId(Long customerId) throws SQLException {
        try {
            Connection conn = getNewConnection();
            String getCustomerTransactionById = "SELECT customer_id, customer_first_name, customer_last_name, SUM(transaction_amount) as total_transaction_value, count(*) as number_of_transactions, max(transaction_date) as last_transaction_date FROM `transactions` WHERE customer_id = " + customerId + " GROUP by customer_first_name, customer_last_name, customer_id";

            TransactionResult transactionResult = new TransactionResult();
            Statement statement1 = conn.createStatement();
            ResultSet result = statement1.executeQuery(getCustomerTransactionById);

            List<TransactionResult> transactionResultList = new ArrayList<>();
            while (result.next()) {
                transactionResult.setCustomerId(result.getLong("customer_id"));
                transactionResult.setCustomerFirstName(result.getString("customer_first_name"));
                transactionResult.setCustomerLastName(result.getString("customer_last_name"));
                transactionResult.setNumberOfTransaction(result.getLong("number_of_transactions"));
                transactionResult.setTotalTransactionValue(result.getLong("total_transaction_value"));
                transactionResult.setTransactionLastDate(result.getString("last_transaction_date"));
                transactionResult.setTransactionFeeValue("5,1");
                transactionResult.setDateOfCommissionCalculation(new Date().toString());
            }
            transactionResultList.add(transactionResult);
            conn.close();
            return transactionResultList;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //for ids separated by commas
    public List<TransactionResult> findTransactionByCustomerIds(String customerIds) throws SQLException {
        try {
            Connection conn = getNewConnection();
            String[] customerIdArray = customerIds.replaceAll("\\s+","").trim().split(",");
            StringBuilder customerIdQuery = new StringBuilder();
            int count = 0;
            for (String customerId : customerIdArray) {
                if (!customerId.trim().isEmpty())
                    customerIdQuery.append("customer_id = ").append(customerId);

                if (count < customerIdArray.length-1) {
                    customerIdQuery.append(" or ");
                }

                count++;
            }

            String getCustomerTransactionById = "SELECT customer_id, customer_first_name, customer_last_name, SUM(transaction_amount) as total_transaction_value, count(*) as number_of_transactions, max(transaction_date) as last_transaction_date  FROM `transactions` WHERE " + customerIdQuery + " GROUP by customer_first_name, customer_last_name, customer_id";

            List<TransactionResult> transactionResultList = new ArrayList<>();
            Statement statement1 = conn.createStatement();
            ResultSet result = statement1.executeQuery(getCustomerTransactionById);
            while (result.next()) {
                TransactionResult transactionResult = new TransactionResult();
                transactionResult.setCustomerId(result.getLong("customer_id"));
                transactionResult.setCustomerFirstName(result.getString("customer_first_name"));
                transactionResult.setCustomerLastName(result.getString("customer_last_name"));
                transactionResult.setNumberOfTransaction(result.getLong("number_of_transactions"));
                transactionResult.setTotalTransactionValue(result.getLong("total_transaction_value"));
                transactionResult.setTransactionLastDate(result.getString("last_transaction_date"));
                transactionResult.setTransactionFeeValue("5,1");
                transactionResult.setDateOfCommissionCalculation(new Date().toString());
                transactionResultList.add(transactionResult);
            }
            conn.close();
            return transactionResultList;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //for ALL
    public List<TransactionResult> findTransactionByCustomerId() throws SQLException {
        try {
            Connection conn = getNewConnection();
            String getCustomerTransactionById = "SELECT customer_id, customer_first_name, customer_last_name, SUM(transaction_amount) as total_transaction_value, count(*) as number_of_transactions, max(transaction_date) as last_transaction_date  FROM `transactions` WHERE customer_id > 0 GROUP by customer_first_name, customer_last_name, customer_id";

            Statement statement1 = conn.createStatement();
            List<TransactionResult> transactionResultList = new ArrayList<>();
            ResultSet result = statement1.executeQuery(getCustomerTransactionById);
            while (result.next()) {
                TransactionResult transactionResult = new TransactionResult();
                transactionResult.setCustomerId(result.getLong("customer_id"));
                transactionResult.setCustomerFirstName(result.getString("customer_first_name"));
                transactionResult.setCustomerLastName(result.getString("customer_last_name"));
                transactionResult.setNumberOfTransaction(result.getLong("number_of_transactions"));
                transactionResult.setTotalTransactionValue(result.getLong("total_transaction_value"));
                transactionResult.setTransactionLastDate(result.getString("last_transaction_date"));
                transactionResult.setTransactionFeeValue("5,1");
                transactionResult.setDateOfCommissionCalculation(new Date().toString());
                transactionResultList.add(transactionResult);
            }
            conn.close();
            return transactionResultList;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Map<Long, List<Transactions>> findCustomerTransactionByCustomerIds(List<Long> uniqueCustomerIds) throws SQLException, ParseException {

        Connection conn = getNewConnection();
        Map<Long, List<Transactions>> resultToFill = new HashMap<>(Collections.emptyMap());
        Transactions transaction;
        StringBuilder customerIdQuery = new StringBuilder();
        int count = 0;
        for (Long customerId : uniqueCustomerIds) {
            if (customerId != null) {
                resultToFill.put(customerId, new ArrayList<>());
                customerIdQuery.append("customer_id = ").append(customerId);
            }

            if (count < uniqueCustomerIds.size()-1) {
                customerIdQuery.append(" or ");
            }

            count++;
        }

        List<FeeWages> feeWagesList = getFeeWages();

        String getCustomerTransactionByIds = "SELECT * FROM `transactions` WHERE "+customerIdQuery;
        Statement statement1 = conn.createStatement();
        ResultSet result = statement1.executeQuery(getCustomerTransactionByIds);

        while (result.next()) {
            transaction = new Transactions();
            List<Transactions> existingTransactions = resultToFill.get(result.getLong("customer_id"));
            transaction.setTransactionId(result.getLong("transaction_id"));
            transaction.setTransactionDate(result.getString("transaction_date"));
            transaction.setCustomerId(result.getLong("customer_id"));
            transaction.setTransactionAmount(result.getString("transaction_amount"));
            transaction.setCustomerFirstName(result.getString("customer_first_name"));
            transaction.setCustomerLastName(result.getString("customer_last_name"));
            transaction.setTransactionPercentageCommission(determinePercentageCommission(result.getString("transaction_amount"), feeWagesList));
            existingTransactions.add(transaction);
            resultToFill.replace(result.getLong("customer_id"), existingTransactions);
        }
        conn.close();
        return resultToFill;
    }

    public List<FeeWages> getFeeWages() throws SQLException {
        Connection conn = getNewConnection();
        List<FeeWages> feeWagesList = new ArrayList<>();
        String getFeeWages = "SELECT * FROM `fee_wages`";
        Statement getFeeWagesStatement = conn.createStatement();
        ResultSet feeWagesResult = getFeeWagesStatement.executeQuery(getFeeWages);

        while (feeWagesResult.next()) {
            FeeWages feeWages = new FeeWages();
            feeWages.setTransactionValueLessThan(feeWagesResult.getLong("transaction_value_less_than"));
            feeWages.setFeePercentageOfTransactionValue(feeWagesResult.getString("fee_percentage_of_transaction_value"));
            feeWagesList.add(feeWages);
        }
        conn.close();
        return feeWagesList;
    }

    public String determinePercentageCommission(String transactionAmount, List<FeeWages> feeWagesList) throws ParseException {
        transactionAmount = transactionAmount.replaceAll(",", "");//remove commas

        //we first sort the feeWages by transaction_value_less_than
        Comparator<FeeWages> compareByTransactionValueLessThan = Comparator.comparing(FeeWages::getTransactionValueLessThan);
        feeWagesList.sort(compareByTransactionValueLessThan);

        String result = "";
        for(FeeWages feeWage: feeWagesList){
            if(Float.parseFloat(transactionAmount) <= feeWage.getTransactionValueLessThan()){
                result = feeWage.getFeePercentageOfTransactionValue().replaceAll(",", ".");
                break;
            }
        }

        if(result.trim().isEmpty()){
            throw new BadRequestException("400", "Transaction value "+transactionAmount+" has no match in fee wages data given");
        }

        return result;
    }
}
