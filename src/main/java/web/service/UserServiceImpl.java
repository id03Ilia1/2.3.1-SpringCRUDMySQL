package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> allread() {
        return userDao.allread();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void update(int id, User usernew) {
        userDao.update(id, usernew);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
