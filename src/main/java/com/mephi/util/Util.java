package com.mephi.util;

import java.sql.*;

public class Util {

    private static String conUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "()2003()";

    public static Connection connection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection(conUrl, username, password);
            return db;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String statement(String sql) throws SQLException
    {
        Connection connection = Util.connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        statement.execute("CREATE schema IF NOT EXISTS \"UserSchema\"");
        if(connection != null){
            try{
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return resultSet.toString();
    }
}