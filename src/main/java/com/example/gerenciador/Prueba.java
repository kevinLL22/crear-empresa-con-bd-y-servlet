package com.example.gerenciador;

import com.example.gerenciador.dao.EmpresaDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.EmpresaEntity;

import javax.persistence.EntityManager;

public class Prueba {
    public static void main(String[] args) {

        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);
        EmpresaEntity empresaEntity = new EmpresaEntity("otra tienda");

        empresaDao.save(empresaEntity);
        em.close();

    }
}
