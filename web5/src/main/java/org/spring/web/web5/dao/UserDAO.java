package org.spring.web.web5.dao;

import org.spring.web.web5.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDAO extends AbstractHibernateDAO<User> implements IUserDAO {

    public UserDAO(){
        super();
        setClazz(User.class );
    }

    @Override
    public User getUser(final long id){
        return findOne(id);
    }

    @Override
    public void setUser(User user) {
        create(user);
    }

    @Override
    public List<User> getAll(){
        return findAll();
    }

    @Override
    public void deleteUser(User user) {
        delete(user);
    }

    public void deleteUserById(long id){
        deleteById(id);
    }

    @Override
    //@Transactional
    public void updateUser(User user) {
        updateUs(user);
    }

    public void updateUserRole (User user){
        update(user);
    }

}
