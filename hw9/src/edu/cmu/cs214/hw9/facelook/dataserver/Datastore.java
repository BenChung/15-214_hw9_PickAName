package edu.cmu.cs214.hw9.facelook.dataserver;

import edu.cmu.cs214.hw9.facelook.dataserver.conn.RoutingData;
import edu.cmu.cs214.hw9.facelook.dataserver.conn.UserDataRequest;
import edu.cmu.cs214.hw9.facelook.dataserver.model.User;

import java.sql.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 4/27/12
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Datastore {
    public static class DataHandle {
        private Connection connection;

        private DataHandle(Connection connection) {
            this.connection = connection;
        }

        public User getUser(int userID) throws SQLException {
            PreparedStatement preparedStatement =  connection.prepareStatement("SELECT (UserID, Username, Email) FROM Users WHERE UserID=?");
            preparedStatement.setInt(0, userID);
            ResultSet returned = preparedStatement.executeQuery();
            if (!returned.next()) {
                return null;
            }
            User userdata = new User(returned.getInt("UserID"), returned.getString("username"), returned.getString("email"));
            return userdata;
        }

        public boolean setUser(User newUser) throws SQLException {
            PreparedStatement preparedStatement =  connection.prepareStatement("SELECT count(UserID) FROM Users WHERE UserID=?");
            preparedStatement.setInt(0, newUser.getUid());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return false;
            }
            int n = resultSet.getInt(0);
            if (n == 1) {
                preparedStatement = connection.prepareStatement("UPDATE USERS (Username, Email, Password) WHERE UserID= ? VALUES (?,?,?)");
                preparedStatement.setInt(0, newUser.getUid());
                preparedStatement.setString(1, newUser.getUsername());
                preparedStatement.setString(2, newUser.getEmail());
                preparedStatement.setString(3, newUser.getPassword());
                preparedStatement.execute();
                return true;
            }
            else if (n == 0) {
                preparedStatement = connection.prepareStatement("INSERT INTO USERS (Username, Email, Password) VALUES (?,?,?)");
                preparedStatement.setString(0, newUser.getUsername());
                preparedStatement.setString(1, newUser.getEmail());
                preparedStatement.setString(2, newUser.getPassword());
                preparedStatement.execute();
                return true;
            }
            return false;
            
        }

        public boolean containsUser(int userID) throws SQLException {
            if (userID == -1)
                return false;

            PreparedStatement preparedStatement =  connection.prepareStatement("SELECT count(UserID) FROM Users WHERE UserID=?");
            preparedStatement.setInt(0, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            int n = resultSet.getInt(0);
            if (n == 0 || n > 1)
                return false;
            return true;
        }

        public RoutingData getHostForRequest(UserDataRequest request) throws SQLException {
            PreparedStatement preparedStatement =  connection.prepareStatement("SELECT (Conn, Uid) FROM Sharding WHERE Uid=?");
            preparedStatement.setInt(0, request.getUid());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next())
                return null;


            RoutingData out = new RoutingData();
            out.address = resultSet.getString(0);
            out.request = request;

            return out;
        }
        
        public int getUIDForUsername(String username) throws SQLException {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT UserID FROM Users WHERE Username=?");
            preparedStatement.setString(0, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return -1;

            return resultSet.getInt(0);
        }

    }
    
    
    
    private static Datastore instance;
    private Connection conn;

    public static Datastore getInstance() {
        if (instance == null)
            instance = new Datastore();
        return instance;
    }

    private Datastore() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:facelook.db");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public DataHandle getHandle() {
        return new DataHandle(conn);
    }
}
