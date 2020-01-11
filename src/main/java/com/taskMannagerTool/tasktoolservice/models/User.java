package com.taskMannagerTool.tasktoolservice.models;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "users"/*,schema = "justfortest"*/)
@Component
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public int userId;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_speciality")
    private String Speciality;

    @Column(name = "user_email")
    private String userEmail;


    @OneToOne//вот тут была боль
    @JoinColumn(name = "user_role")
    private Role roles;

}
