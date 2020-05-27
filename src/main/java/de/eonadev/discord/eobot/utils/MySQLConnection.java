package de.eonadev.discord.eobot.utils;

import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class MySQLConnection {
    private Connection connection;

    public MySQLConnection(String host, String port, String database, String username, String password, boolean ssl, boolean readOnly, boolean autoReconnect) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(
                    "jdbc:mysql://"+host+":"+port+"/"+database+"?serverTimezone=UTC&autoReconnect="+autoReconnect+"&useSSL="+ssl,username,password);
            connection.setSavepoint(String.valueOf(System.currentTimeMillis()));
            connection.setReadOnly(readOnly);
            sendPing();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PreparedStatement preparedStatement(String sql){
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public SQLWarning getWarnings(){
        try {
            return connection.getWarnings();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection(){
        return this.connection;
    }

    private void sendPing(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run(){
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT 1;");
                    preparedStatement.executeQuery();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 0, 60000);
    }


}
