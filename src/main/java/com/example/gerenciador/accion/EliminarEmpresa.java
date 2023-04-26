package com.example.gerenciador.accion;

import com.example.gerenciador.dao.EmpresaDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.EmpresaEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import java.io.IOException;

public class EliminarEmpresa {

    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);
        Integer id = Integer.parseInt(request.getParameter("idEmpresaEliminar"));
        EmpresaEntity eliminarEste = empresaDao.findById(id);
        empresaDao.delete(eliminarEste);
        em.close();
        return "redirect:/entrada?accion=ListarEmpresas";
    }

}
