package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> allread();
    void save(User user);
    User show (int id);
    void update(int id, User usernew);
    void delete(int id);
}
