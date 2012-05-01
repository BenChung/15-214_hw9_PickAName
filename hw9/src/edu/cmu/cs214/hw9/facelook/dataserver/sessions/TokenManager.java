package edu.cmu.cs214.hw9.facelook.dataserver.sessions;

import java.util.Hashtable;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Ben Chung
 * Date: 4/30/12
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class TokenManager {
    private Hashtable<UUID, Integer> tokens = new Hashtable<UUID, Integer>();
    
    private static TokenManager instance;
    public static TokenManager getInstance() {
        if (instance == null)
            instance = new TokenManager();
        return instance;
    }
    private TokenManager() {}
    
    public UUID getNewToken(int uid) {
        UUID token = UUID.randomUUID();
        tokens.put(token, uid);
        return token;
    }
    
    public int getUid(UUID token) {
        if (!tokens.contains(token))
            throw new IllegalArgumentException();
        return tokens.get(token);
    }
    
    
}
