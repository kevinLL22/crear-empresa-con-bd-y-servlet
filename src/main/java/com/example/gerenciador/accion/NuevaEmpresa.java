package com.example.gerenciador.accion;

import com.example.gerenciador.dao.EmpresaDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.EmpresaEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import java.io.IOException;

public class NuevaEmpresa {
    public void ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*Con el HttpServletRequest obtenemos respuestas del navegador
        con el HttpServletResponse devolvemos un html al navegador
        PrintWriter salida = resp.getWriter(); */

        String nombre = request.getParameter("nombre");

        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);
        EmpresaEntity empresa = new EmpresaEntity(nombre);
        empresaDao.save(empresa);
        em.close();

        //Al contrario que con el dispacher, ahora le decimos al navegador que vaya a esta otra dirección
        response.sendRedirect("/gerenciador/entrada?accion=ListarEmpresas");
    }

}
