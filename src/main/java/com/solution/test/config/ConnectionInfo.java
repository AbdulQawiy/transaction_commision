package com.solution.test.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInfo {

    String url = "jdbc:mysql://localhost:3306/transaction_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "";

    Connection connectionInfo = DriverManager.getConnection(url, user, password);

    public ConnectionInfo() throws SQLException {
    }

    public ConnectionInfo(String url, String user, String password, Connection connectionInfo) throws SQLException {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionInfo = connectionInfo;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnectionInfo() {
        return connectionInfo;
    }
}
