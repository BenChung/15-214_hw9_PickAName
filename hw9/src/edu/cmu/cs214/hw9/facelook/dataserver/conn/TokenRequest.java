package edu.cmu.cs214.hw9.facelook.dataserver.conn;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 5/1/12
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TokenRequest extends ClientRequest{
    public void setToken(UUID token);
    public UUID getToken();
}
