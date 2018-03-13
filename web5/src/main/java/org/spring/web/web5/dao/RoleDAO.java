package org.spring.web.web5.dao;



import org.spring.web.web5.model.Role;
import org.spring.web.web5.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAO extends AbstractHibernateDAO<Role> implements IRoleDAO {

    public RoleDAO(){
        super();
        setClazz(Role.class );
    }

    @Override
    public void setUserRole(User user, String role) {

    }

    public Role getRole(User user) {
        return findOneAnother(user);
    }

    @Override
    public List<Role> getRoles() {
        return findAll();
    }

    public Role getRoleId (int id){
        return findOneiD(id);
    }

}
