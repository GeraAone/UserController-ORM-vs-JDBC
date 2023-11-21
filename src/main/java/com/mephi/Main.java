package com.mephi;

import com.mephi.dao.UserDaoHibernateImpl;
import com.mephi.service.UserServiceImpl;
import com.mephi.util.Util;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserDaoHibernateImpl dao = new UserDaoHibernateImpl(Util.createEM());
        dao.saveUser("max", "lavrov", (byte)23);
        Util.closeEM();
    }
}
