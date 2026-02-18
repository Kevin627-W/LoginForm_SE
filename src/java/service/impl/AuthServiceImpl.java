package service.impl;

import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.AuthService;
import util.PasswordUtil;

public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository = new UserRepositoryImpl();

    public void register(String username, String password) {
        String hashed = PasswordUtil.hash(password);
        userRepository.save(new User(username, hashed));
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) return null;

        String hashed = PasswordUtil.hash(password);
        return user.getPassword().equals(hashed) ? user : null;
    }
}