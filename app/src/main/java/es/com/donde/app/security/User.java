package es.com.donde.app.security;

import es.com.donde.app.model.PersistentObject;

/**
 * Created by santiago on 6/3/14.
 */
public class User extends PersistentObject {
       String userId;
       String token;
       String screenName;

    public User() {
    }

    public User(String userId, String token, String screenName) {
        this.userId = userId;
        this.token = token;
        this.screenName = screenName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }

    public String getScreenName () { return screenName ; }
}
