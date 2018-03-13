package org.spring.web.web5.service;

import org.spring.web.web5.dao.IUserDAO;
import org.spring.web.web5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private IUserDAO dao;

    public UserService() {
        super();
    }

    // API

    public User getUserLoginPass(String login, String password) {
        List<User> users = getAll();
        for (User user : users){
            if (user.getLogin().equalsIgnoreCase(login)){
                if (user.getPassword().equalsIgnoreCase(password)){
                    return user;
                }
            }
        }
        return null;
    }

    public User getUser(long id) {
        return dao.getUser(id);
    }

    public void setUser(User user) {
        dao.setUser(user);
    }

    public List<User> getAll() {
        return dao.getAll();
    }

    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    public void deleteUserById(long id){
        dao.deleteUserById(id);
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }

    public void updateUserRole(User user) {
        dao.updateUserRole(user);
    }
}
