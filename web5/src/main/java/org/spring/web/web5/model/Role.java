package org.spring.web.web5.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles", schema = "test")
public class Role implements Serializable {

    private static final long serialVersionUID = 5924361831551833717L;

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "role")
    private String role;

    public Role(){}

    public Role(int id, String role){
        this.id = id;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}
