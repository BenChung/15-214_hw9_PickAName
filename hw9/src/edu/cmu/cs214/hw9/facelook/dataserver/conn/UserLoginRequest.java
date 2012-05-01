package edu.cmu.cs214.hw9.facelook.dataserver.conn;

import edu.cmu.cs214.hw9.facelook.dataserver.Datastore;
import edu.cmu.cs214.hw9.facelook.dataserver.sessions.TokenManager;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 4/30/12
 * Time: 6:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserLoginRequest implements Serializable, UserRequest {
    @Override
    public void setUID(int uid) {
        this.uid = uid;
    }

    @Override
    public int getUID() {
        return uid;
    }

    private String username;
    private String password;
    private int uid = -1;
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String pwd) {
        password = pwd;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getUsername() {
        return username;
    }

    @Override
    public Object handleRequest(Datastore.DataHandle handle) throws IOException {
        UUID token = TokenManager.getInstance().getNewToken(uid);
        return new LoginData(token);
    }
}
