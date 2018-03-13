package org.spring.web.web5.dao;

import org.spring.web.web5.model.User;

import java.util.List;

public interface IUserDAO {

    User getUser(long id);

    void setUser(User user);

    List<User> getAll();

    void deleteUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    void updateUserRole (User user);

}
