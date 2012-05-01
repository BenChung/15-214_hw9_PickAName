package edu.cmu.cs214.hw9.facelook.dataserver.conn;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 4/30/12
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginData implements Serializable{
    public LoginData (UUID token) {
        userToken = token;
    }
    
    public UUID userToken;
}
