package edu.cmu.cs214.hw9.facelook.dataserver.model;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 5/1/12
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {
    private String username;
    private String email;
    private String password;
    private int uid;
    
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.uid = uid;
    }

    public User(int uid, String username, String email) {
        this.username = username;
        this.email = email;
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPlaintextPassword(String password) {
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
