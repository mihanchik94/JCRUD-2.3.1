package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(long id) {
        entityManager.createQuery("DELETE FROM User WHERE id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> allUsers = entityManager.createQuery("SELECT user FROM User user", User.class);
        return allUsers.getResultList();
    }
}
