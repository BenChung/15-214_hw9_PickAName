package edu.cmu.cs214.hw9.facelook.dataserver;

import edu.cmu.cs214.hw9.facelook.dataserver.conn.*;
import edu.cmu.cs214.hw9.facelook.dataserver.sessions.TokenManager;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 4/27/12
 * Time: 12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static Datastore store;
    public static void main(String[] args) throws Exception{
        store = Datastore.getInstance();
        ServerSocket conn = ServerSocketFactory.getDefault().createServerSocket(3421);
        ExecutorService execService = Executors.newCachedThreadPool();
                
        try {
            while (true) {
                execService.submit(new ClientHandler(conn.accept()));
            }
        } finally {
            conn.close();
        }
    }
    
    private static class ClientHandler implements Callable<Boolean> {
        private Socket clientBoundSocket;

        public ClientHandler(Socket clientBoundSocket) {

            this.clientBoundSocket = clientBoundSocket;
        }
        
        @Override
        public Boolean call() throws Exception {
            ObjectInputStream inputStream = null;
            Datastore.DataHandle handle = null;
            try {
                handle = store.getHandle();
                inputStream = new ObjectInputStream(clientBoundSocket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(clientBoundSocket.getOutputStream());
                ClientRequest inputObj = (ClientRequest)inputStream.readObject();
                inputObj.handleRequest(handle);
                    
            } finally {
                if (inputStream != null)
                    inputStream.close();
                clientBoundSocket.close();
            }
            return true;
        }
    }
}
