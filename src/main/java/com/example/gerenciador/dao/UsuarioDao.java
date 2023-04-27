package com.example.gerenciador.dao;

import com.example.gerenciador.modelo.UsuarioEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsuarioDao {
    private EntityManager em;

    public UsuarioDao(EntityManager em) {
        this.em = em;
    }

    public UsuarioEntity findById(Integer id){
        try {
            em.getTransaction().begin();
            UsuarioEntity usuarioEntity = em.find(UsuarioEntity.class, id);
            em.getTransaction().commit();
            return usuarioEntity;
        }catch (RuntimeException e){
            em.getTransaction().rollback();
            throw e;
        }
    }
    public UsuarioEntity findByLogin(String login, String contrasena){
        TypedQuery<UsuarioEntity> query = em.createQuery("SELECT u FROM UsuarioEntity u " +
                "WHERE u.login = :login AND u.contrasena = :contrasena", UsuarioEntity.class);
        query.setParameter("login", login);
        query.setParameter("contrasena",contrasena);
        try {
            em.getTransaction().begin();
            UsuarioEntity singleResult = query.getSingleResult();
            em.getTransaction().commit();
            return singleResult;
        }catch (RuntimeException e) {
            return null;
        }
    }
    public List<UsuarioEntity> findAll(){
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT U FROM UsuarioEntity U");
            List<UsuarioEntity> resultList = query.getResultList();
            em.getTransaction().commit();
            return resultList;
        }catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public void save(UsuarioEntity usuario){
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        }catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public void update(UsuarioEntity usuario){
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        }catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    public void delete(UsuarioEntity usuario){
        try {
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        }catch (RuntimeException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

}
