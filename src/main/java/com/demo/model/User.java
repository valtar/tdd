package com.demo.model;

//@Entity
//@Table(name = "users")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long status;
    private String login;
    private String email;

    public User(){}

    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + login + ", email=" + email + '}';
    }
}
