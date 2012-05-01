package edu.cmu.cs214.hw9.facelook.dataserver.conn;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 4/30/12
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoutingData implements Serializable {
    public ClientRequest request;
    public String address;
}
