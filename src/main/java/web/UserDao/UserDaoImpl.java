package web.UserDao;


import org.springframework.stereotype.Repository;
import web.config.model.User;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
   private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> res = entityManager.createQuery("from User",User.class).getResultList();
        return res;

    }

    @Override
    public void saveUser(User user) {
        if(user.getId() == null){
            entityManager.persist(user);
        } else {
            User userUpdate = getUserById(user.getId());
            userUpdate.setName(user.getName());
            userUpdate.setSurname(user.getSurname());
            userUpdate.setEmail(user.getEmail());
            entityManager.merge(userUpdate);
        }

    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class,id));
    }

}
