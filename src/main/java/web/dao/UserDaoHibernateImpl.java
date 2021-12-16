package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public UserDaoHibernateImpl () {
    }

    @Override
    public void addUser (User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById (long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public List<User> getAllUsers () {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void update (User user, long id) {
        user.setId(id);
        entityManager.merge(user);
    }

    @Override
    public User getUserById (long id) {
        return entityManager.find(User.class, id);
    }
}
