package org.spring.web.web5.dao;

import org.spring.web.web5.model.Role;
import org.spring.web.web5.model.User;

import java.util.List;

public interface IRoleDAO {

    void setUserRole(User user, String role);

    List<Role> getRoles();

    Role getRole(User user);

    Role getRoleId(int id);
}
