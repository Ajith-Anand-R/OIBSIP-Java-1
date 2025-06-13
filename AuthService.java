package service;

import db.Database;
import model.User;

public class AuthService {
    public User login(String userId, String password) {
        for (User user : Database.users) {
            if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
} 