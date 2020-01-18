package com.taskMannagerTool.tasktoolservice.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import javax.persistence.*;



@Entity
@Table(name = "users"/*,schema = "justfortest"*/)
@Component
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    @JsonIgnore
    public int userId;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_password")
    @JsonIgnore
    private String userPassword;

    @Column(name = "user_speciality")
    private String Speciality;

    @Column(name = "user_email")
    private String userEmail;




    /*@OneToOne//вот тут была боль
    @JoinColumn(name = "user_role")
    @JsonIgnore
    private Role roles;*/

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @JsonIgnore
    public int getUserId() {
        return userId;
    }
    @JsonProperty
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getUserPassword() {
        return userPassword;
    }

    @JsonProperty
    public void setUserPassword(String userPassword) {
        this.userPassword = passwordEncoder().encode(userPassword);
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
   /* @JsonIgnore
    public Role getRoles() {
        return roles;
    }
    @JsonProperty
    public void setRoles(Role roles) {
        this.roles = roles;
    }*/
}
