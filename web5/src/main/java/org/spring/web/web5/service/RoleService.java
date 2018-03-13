package org.spring.web.web5.service;

import org.spring.web.web5.dao.IRoleDAO;
import org.spring.web.web5.model.Role;
import org.spring.web.web5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private IRoleDAO dao;

    public RoleService() {
        super();
    }

    // API


    public Role getRole(User user) {
        return dao.getRole(user);
    }

    public Role getRoleId(int id){
        return dao.getRoleId(id);
    }


    public void setUserRole(User user, String role) {
        dao.setUserRole(user, role);
    }

    public List<Role> getRoles() {
        return dao.getRoles();
    }
}
