package com.example.gerenciador.accion;

import com.example.gerenciador.dao.EmpresaDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.EmpresaEntity;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

public class ListarEmpresas {
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);
        List<EmpresaEntity> empresasList = empresaDao.findAll();
        //añadimos al request un parametro, para poder mandarlo después junto al request
        request.setAttribute("empresasList", empresasList);
        em.close();
        return "forward:/listaEmpresas.jsp";
    }
}
