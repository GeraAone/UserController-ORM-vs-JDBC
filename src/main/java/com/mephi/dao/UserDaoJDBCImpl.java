package com.mephi.dao;

import com.mephi.model.User;
import com.mephi.util.Util;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class UserDaoJDBCImpl implements UserDao{

    private  List<User> userList = new ArrayList<>();
    @Override
    public void createUsersTable() throws SQLException {
        Util.statement("CREATE TABLE IF NOT EXISTS \"userschema\".users ( \n" +
                "id serial NOT NULL PRIMARY KEY, \n" +
                "name varchar(256) NOT NULL, \n" +
                "lastName varchar(256) NOT NULL,\n" +
                "age smallint Not null\n" +
                ");");

    }

    @Override
    public void dropUsersTable() throws SQLException {
        Util.statement("DROP TABLE IF EXISTS \"userschema\".users");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String ageStr = Byte.toString(age);
        Util.statement("INSERT INTO users(name, lastName, age) VALUES\n" +
                "(" + name + ", " + lastName + ", " + ageStr + ");");
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        String idStr = Long.toString(id);
        Util.statement("DELETE from users \n" +
                "WHERE id = " + idStr + ";");
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        Connection connection = Util.connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM \"userschema\".users");
        while(resultSet.next())
        {
            User user = new User(resultSet.getString("name"), resultSet.getString("lastName"), resultSet.getByte("age"));
            userList.add(user);
        }
        connection.close();
        return userList;
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        Util.statement("Truncate TABLE \"userschema\".users");
    }
}
