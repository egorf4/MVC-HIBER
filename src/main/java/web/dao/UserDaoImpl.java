package web.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        if (user.getId() == 0) {
            em.persist(user);
        } else {
            em.merge(user);
        }

    }

    @Override
    public User getUser(int id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Query query = em.createQuery("delete from User where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = em.unwrap(Session.class);
        return session.createQuery("from User", User.class).list();
    }

}
