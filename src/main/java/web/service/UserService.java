package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User get(long id);
    void update(User user);
    void delete(long id);
    List<User> getAllUsers();
}
