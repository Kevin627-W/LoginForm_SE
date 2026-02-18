package repository;

import model.User;

public interface UserRepository {
    void save(User user);
    User findByUsername(String username);
}