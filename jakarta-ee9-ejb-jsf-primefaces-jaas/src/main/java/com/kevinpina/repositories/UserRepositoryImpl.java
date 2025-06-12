package com.kevinpina.repositories;

import com.kevinpina.entities.UserEntity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class UserRepositoryImpl implements CrudRepository<UserEntity> {

    @Inject
    private EntityManager em;

    @Override
    public List<UserEntity> list() {
        return em.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
    }

    @Override
    public UserEntity findById(Long id) {
        return em.find(UserEntity.class, id);
    }

    @Override
    public void save(UserEntity user) {
        if (user.getId() != null && user.getId() > 0) {
            em.merge(user);
        } else{
            em.persist(user);
        }
    }

    @Override
    public void deleteById(Long id) {
        em.remove(findById(id));
    }

}
