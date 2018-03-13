package org.spring.web.web5.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "test")
public class User implements Serializable { // Serializable Important to Hibernate

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @GeneratedValue
    @Column(name="id", updatable=false, nullable=false)
    private long id;

    @Column(name = "name", unique = true, updatable = false, nullable = false)
    private String name;

    @Column(name = "login", unique = true, updatable = false, nullable = false)
    private String login;

    @Column(name = "password", updatable = false, nullable = false)
    private String password;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="user_roles",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
    private List<Role> roles;

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public User(long id, String name, String login, String password) {
        super();
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User(String name, String login, String password) {
        super();
        this.name = name;
        this.login = login;
        this.password = password;
        this.roles = new ArrayList<>();
    }

    public User() {
        super();
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(Role role) {
        roles.add(role);
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + login + ", " + password  + ", " + roles.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password, roles);
    }
}
