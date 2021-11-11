package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UsersDao implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allread() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User show(int id) {
        TypedQuery<User> tp = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        tp.setParameter("id", id);
        return tp.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void update(int id, User usernew) {
        User userold = show(id);
        userold.setFirstName(usernew.getFirstName());
        userold.setLastName(usernew.getLastName());
        entityManager.merge(userold);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }
}

