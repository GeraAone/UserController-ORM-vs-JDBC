package com.mephi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;

public class Util {

    private static String conUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static String username = "postgres";
    private static String password = "******";
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static Connection connection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection db = DriverManager.getConnection(conUrl, username, password);
            return db;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void statement(String sql) throws SQLException
    {
        Connection connection = Util.connection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.execute("CREATE schema IF NOT EXISTS \"userschema\"");
        if(connection != null){
            try{
                connection.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static EntityManager createEM()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("UserManager");
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
    public static void closeEM()
    {
        entityManager.close();
        entityManagerFactory.close();
    }

}