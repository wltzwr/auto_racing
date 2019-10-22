package com.autohome.autoracing.context;

import org.springframework.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserContext {

    private static  Map<String, Map<String, Object>> userContext = new ConcurrentHashMap<>();

    public static Map<String, Object> getUserContext(String username){
        Assert.notNull(username, "username must not be null.");
        return userContext.get(username);
    }

    public static void setUserContext(String username, String fieldName, Object value){
        getUserContext(username).put(fieldName, value);
    }


}
