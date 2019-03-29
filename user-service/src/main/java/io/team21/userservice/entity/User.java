package io.team21.userservice.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    protected User() {
    }

    public void setId(int id) {
          this.id = id;
    }

    public void setFirstName(String firstName) {
          this.firstName = firstName;
    }

    public void setLastName(String lastName) {
          this.lastName = lastName;
    }

    public void setUserName(String userName) {
          this.userName = userName;
    }

    public void setPassword(String password) {
          this.password = password;
    }

    public int getId() {
         return id;
    }

    public String getFirstName() {
         return firstName;
    }
    public String getLastName() {
         return lastName;
    }

    public String getUserName() {
         return userName;
    }

    public String getPassword() {
         return password;
    }
}