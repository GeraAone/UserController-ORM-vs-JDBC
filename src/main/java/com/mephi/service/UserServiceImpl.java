package com.mephi.service;
import com.mephi.dao.UserDaoHibernateImpl;
import com.mephi.model.User;
import com.mephi.util.Util;
import lombok.NoArgsConstructor;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
public class UserServiceImpl implements  UserService{

    private UserDaoHibernateImpl daoHibernate = new UserDaoHibernateImpl(Util.createEM());
    @Override
    public void createUsersTable() throws SQLException {
        daoHibernate.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        daoHibernate.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age){
        daoHibernate.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id){
        daoHibernate.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers(){
        return daoHibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        daoHibernate.cleanUsersTable();
    }
}
