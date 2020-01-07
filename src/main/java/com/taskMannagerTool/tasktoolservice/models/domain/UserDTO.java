package com.taskMannagerTool.tasktoolservice.models.domain;


import org.springframework.stereotype.Component;

@Component
public class UserDTO {

   /* @NotEmpty(message = REQUIRED)*/
    private String username;


    /*@NotEmpty(message = USER_PASSWORD_MESSAGE)
    @Pattern(regexp = USER_PASSWORD_REGEX)*/
    private String password;

    /*@Email
    @NotEmpty(message = USER_EMAIL_MESSAGE)
    @Pattern(regexp = USER_EMAIL_REGEX)*/
    private String email;

    private String role;


   /* @Pattern(regexp = USER_INFO_REGEX)*/
    private String firstName;


   /* @Pattern(regexp = USER_INFO_REGEX)*/
    private String lastName;

    private String userSpeciality;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserSpeciality() {
        return userSpeciality;
    }

    public void setUserSpeciality(String userSpeciality) {
        this.userSpeciality = userSpeciality;
    }
}
