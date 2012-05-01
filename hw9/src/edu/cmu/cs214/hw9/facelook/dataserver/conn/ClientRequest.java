package edu.cmu.cs214.hw9.facelook.dataserver.conn;

import edu.cmu.cs214.hw9.facelook.dataserver.Datastore;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 5/1/12
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ClientRequest {
    public Object handleRequest(Datastore.DataHandle handle) throws IOException, SQLException;
}
