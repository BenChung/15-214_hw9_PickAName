package edu.cmu.cs214.hw9.gui;

import edu.cmu.cs214.hw9.facelook.dataserver.model.User;
import edu.cmu.cs214.hw9.facelook.dataserver.conn.LoginData;
import edu.cmu.cs214.hw9.facelook.dataserver.conn.NewUserRequest;
import edu.cmu.cs214.hw9.facelook.dataserver.conn.UserLoginRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 4/30/12
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Comms {
    private static final String server = "localhost";
    private UUID token;
    
    private static Comms instance;
    public static Comms getInstance() {
        if (instance == null)
            instance = new Comms();
        return instance;
    }
    private Comms() {}
    
    public boolean register(String username, String email, String password) {
        try {
            Socket serversock = new Socket(server, 3421);
            ObjectOutputStream oos = new ObjectOutputStream(serversock.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(serversock.getInputStream());
            User newUser = new User(username, email, password);
            oos.writeObject(new NewUserRequest(newUser));
            Object returned = ois.readObject();
            
            if (returned == null)
                return false;
            
            this.token = ((LoginData)returned).userToken;
            
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
