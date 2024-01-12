package com.example.DistributedSystems.DAO;

import com.example.DistributedSystems.Entity.FarmerUnion;
import com.example.DistributedSystems.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<User> getUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUser(Integer user_id) {
        return entityManager.find(User.class, user_id);
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        System.out.println("user "+ user.getId());
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(Integer user_id) {
        System.out.println("Deleting student with id: " + user_id);
        entityManager.remove(entityManager.find(User.class, user_id));
    }

    @Override
    @Transactional
    public List<FarmerUnion> getFarmerUnion(Integer user_id) {
        User user = entityManager.find(User.class, user_id);
        return user.getFarmerUnion();
    }
}