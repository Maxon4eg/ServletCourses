package com.akhambir;

import com.akhambir.dao.UserDaoImpl;
import com.akhambir.factory.Factory;
import com.akhambir.model.User;
import org.junit.Assert;
import org.junit.Test;

public class UnitTests {

    @Test
    public void testGetUser() {
        UserDaoImpl dao = new UserDaoImpl(Factory.getConnection());
        User user = new User("MAX", "12345", "TEKEN", "mail@com");
        dao.create(user);
        Assert.assertEquals("user from database ", user, dao.getUser(user));
    }
}
