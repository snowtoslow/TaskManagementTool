package com.taskMannagerTool.tasktoolservice.models;
import javax.persistence.*;


@Table(name = "user_role")
@Entity
public class Role {

    @Id
    private String userRole;



    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}

