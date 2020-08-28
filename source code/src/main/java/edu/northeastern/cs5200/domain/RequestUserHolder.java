package edu.northeastern.cs5200.domain;

import javax.persistence.Entity;

import org.springframework.core.NamedThreadLocal;

import edu.northeastern.cs5200.models.User;

public class RequestUserHolder {
    private RequestUserHolder(){
    }

    private static final ThreadLocal<User> userHolder = new NamedThreadLocal<>("Request user");

    public static void set(User user) {
        userHolder.set(user);
    }

    public static User get() {
        return userHolder.get();
    }

    public static void clear() {
        userHolder.remove();
    }
}
