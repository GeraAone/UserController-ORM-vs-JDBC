package com.mephi.service;
import com.mephi.dao.UserDaoHibernateImpl;
import com.mephi.model.User;
import com.mephi.util.Util;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class UserServiceImpl implements  UserService{
    @Inject
    private UserDaoHibernateImpl daoHibernate;
    @Override
    public void createUsersTable() throws SQLException {
        daoHibernate.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        daoHibernate.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        daoHibernate.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        daoHibernate.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return daoHibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        daoHibernate.cleanUsersTable();
    }
}
