package com.mephi;

import com.mephi.dao.UserDao;
import com.mephi.dao.UserDaoHibernateImpl;
import com.mephi.model.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserDao jdbc = new UserDaoHibernateImpl();
        try {
            jdbc.saveUser("Maxim", "Laveykin", (byte) 20);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
