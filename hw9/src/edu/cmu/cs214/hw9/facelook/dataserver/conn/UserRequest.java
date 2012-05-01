package edu.cmu.cs214.hw9.facelook.dataserver.conn;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 5/1/12
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserRequest extends ClientRequest {
    public void setUID(int uid);
    public int getUID();
}
