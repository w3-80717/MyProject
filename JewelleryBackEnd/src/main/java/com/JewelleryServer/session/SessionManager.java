package com.JewelleryServer.session;

import com.JewelleryServer.pojo.User;
import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    private static final Map<String, User> sessions = new HashMap<>();

    public static void storeSession(String sessionId, User user) {
        sessions.put(sessionId, user);
    }

    public static User getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public static void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}
