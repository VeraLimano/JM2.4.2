package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserByName(String name) {
        Query query = (Query) entityManager.createQuery
                ("SELECT usName FROM User usName WHERE usName.name = :name2");
        query.setParameter("name2", name);
        return (User) query.getSingleResult();
    }

    @Override
    public Role getRole(String role) {
        Query query = (Query) entityManager.createQuery
                ("SELECT usRole FROM Role usRole WHERE usRole.role = :name2");
        query.setParameter("name2", role);
        return (Role) query.getSingleResult();
    }

    @Override
    public List index() {
        return entityManager.createQuery("SELECT us FROM User us").getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updateUser) {
        User userChange = (User) show(id);
        entityManager.merge(updateUser);
    }


    @Override
    public void delete(int id) {
        User userDelete = (User) show(id);
        entityManager.remove(userDelete);
    }

//    private final Map<String, User> userMap = Collections.singletonMap("test",
//            new User(1L, "test", "test", Collections.singleton(new Role(1L, "ROLE_USER")))); // name - уникальное значение, выступает в качестве ключа Map
//
//    @Override
//    public User getUserByName(String name) {
//        if (!userMap.containsKey(name)) {
//            return null;
//        }
//
//        return userMap.get(name);
//    }
}

