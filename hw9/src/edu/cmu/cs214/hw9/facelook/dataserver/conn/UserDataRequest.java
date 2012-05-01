package edu.cmu.cs214.hw9.facelook.dataserver.conn;

import edu.cmu.cs214.hw9.facelook.dataserver.Datastore;
import edu.cmu.cs214.hw9.facelook.dataserver.model.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 4/27/12
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDataRequest implements Serializable, ClientRequest {
    private int uid = -1;
    private String username;
    private UUID token;


    public UserDataRequest(String username) {
        this.username = username;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    public int getUid() {
        return uid;
    }
    
    public String getUsername() {
        return username;
    }

    @Override
    public Object handleRequest(Datastore.DataHandle handle) throws IOException, SQLException {
        if (uid == -1 || !handle.containsUser(uid)) {
            return null;
        }
        User userData = handle.getUser(uid);
        return userData;
    }
}
