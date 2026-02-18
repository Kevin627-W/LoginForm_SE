package service;

import model.User;

public interface AuthService {
    void register(String username, String password);
    User login(String username, String password);
}