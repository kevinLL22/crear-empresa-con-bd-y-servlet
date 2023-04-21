package com.example.gerenciador.dao;

import com.example.gerenciador.modelo.EmpresaEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmpresaDao {

    private EntityManager em;

    public EmpresaDao(EntityManager em) {
        this.em = em;
    }
    public EmpresaEntity findById(Integer id){
        try{ // pensé en hacer uso del try with resources, pero esto cerraría el em, no la transacción
            em.getTransaction().begin();
            EmpresaEntity empresa = em.find(EmpresaEntity.class, id);
            em.getTransaction().commit();
            return empresa;
        }catch (RuntimeException e){
            em.getTransaction().rollback();
            throw e;
        }
    }

    public List<EmpresaEntity>findAll(){
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT E FROM EmpresaEntity E");
            List resultList = query.getResultList();
            em.getTransaction().commit();
            return resultList;
        }catch (RuntimeException e){
            em.getTransaction().rollback();
            throw e;
        }
    }
    public void save(EmpresaEntity empresa){
        try {
            em.getTransaction().begin();
            em.persist(empresa);
            em.getTransaction().commit();
        }catch (RuntimeException e){
            em.getTransaction().rollback();
            throw e;
        }

    }

    public void update(EmpresaEntity empresa){
        try {
            em.getTransaction().begin();
            em.merge(empresa); //merge para actualizar en la bd, esto a partir de un objeto
            em.getTransaction().commit();
        }catch (RuntimeException e){
            em.getTransaction().rollback();
            throw e;
        }
    }

    public void delete(EmpresaEntity empresa){
        try {
            em.getTransaction().begin();
            //remove recibe entidades, no ids
            em.remove(empresa);
            em.getTransaction().commit();
        }catch (RuntimeException e){
            em.getTransaction().rollback();
            throw e;
        }
    }

}
