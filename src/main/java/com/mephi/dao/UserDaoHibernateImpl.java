package com.mephi.dao;

import com.mephi.model.User;
import com.mephi.util.Util;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@NoArgsConstructor
public class UserDaoHibernateImpl implements  UserDao{
    @PersistenceContext
    private EntityManager em;
    @Override
    public void createUsersTable() throws SQLException {
        Util.statement("CREATE TABLE IF NOT EXISTS \"UserSchema\".users ( \n" +
                "id serial NOT NULL PRIMARY KEY, \n" +
                "name varchar[] NOT NULL, \n" +
                "lastName varchar[] NOT NULL,\n" +
                "age smallint Not null\n" +
                ");");
    }

    @Override
    public void dropUsersTable() throws SQLException {
        Util.statement("DROP TABLE IF EXISTS users");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        User user = new User(name, lastName,age);
        executeInsideTransaction(em -> em.persist(user));
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        Optional<User> user = Optional.ofNullable(em.find(User.class, id));
        if(user.isPresent()) System.out.println("Wrong id");
        executeInsideTransaction(em -> em.remove(user.get()));
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        Query query = em.createQuery("SELECT * from User.users");
        return query.getResultList();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        List<User> allUsers = getAllUsers();
        allUsers.forEach(user -> executeInsideTransaction(em -> em.remove(user)));
    }
    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tc = em.getTransaction();
        try {
            tc.begin();
            action.accept(em);
            tc.commit();
        }
        catch (RuntimeException e) {
            tc.rollback();
            throw e;
        }
    }
}
