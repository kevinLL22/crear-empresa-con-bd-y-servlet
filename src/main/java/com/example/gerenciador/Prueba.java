package com.example.gerenciador;

import com.example.gerenciador.dao.EmpresaDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.EmpresaEntity;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prueba {
    public static void main(String[] args) {


    }

    public static void pruebaSave(){
        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);
        EmpresaEntity empresaEntity = new EmpresaEntity("otra tienda");
        empresaDao.save(empresaEntity);
        em.close();

    }

    public static void pruebaUpdate(){
        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);

        //getters
        Integer idModEmpresa = 4;
        String nombre = "mod 4";
        Date fechaAbertura= null;
        try {
            fechaAbertura=new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-20 17:47:52.0");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //la fecha me llega como yyyy-mm-dd así que ese es el formato que uso para el parse

        //entity
        EmpresaEntity empresa = empresaDao.findById(idModEmpresa);

        empresa.setNombre(nombre);
        empresa.setFechaAbertura(fechaAbertura);
        empresaDao.update(empresa);
        em.close();

    }
}
