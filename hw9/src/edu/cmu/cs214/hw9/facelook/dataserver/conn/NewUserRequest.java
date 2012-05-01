package edu.cmu.cs214.hw9.facelook.dataserver.conn;

import edu.cmu.cs214.hw9.facelook.dataserver.Datastore;
import edu.cmu.cs214.hw9.facelook.dataserver.model.User;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 4/30/12
 * Time: 8:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewUserRequest implements Serializable, ClientRequest{
    private User newUser;

    public NewUserRequest(User newUser) {

        this.newUser = newUser;
    }
    
    public User getNewUser() {
        return newUser;
    }

    @Override
    public Object handleRequest(Datastore.DataHandle handle) throws IOException, SQLException {
        handle.setUser(newUser);
        UserLoginRequest ulr = new UserLoginRequest();
        ulr.setUsername(newUser.getUsername());
        ulr.setPassword(newUser.getPassword());
        return ulr.handleRequest(handle);
    }
}
