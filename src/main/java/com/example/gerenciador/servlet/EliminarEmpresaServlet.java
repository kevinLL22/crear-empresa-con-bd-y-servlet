package com.example.gerenciador.servlet;

import com.example.gerenciador.dao.EmpresaDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.EmpresaEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;
import java.io.IOException;

@WebServlet(name = "EliminarEmpresaServlet", value = "/eliminarEmpresa")
public class EliminarEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);
        Integer id = Integer.parseInt(request.getParameter("idEmpresaEliminar"));
        EmpresaEntity eliminarEste = empresaDao.findById(id);
        empresaDao.delete(eliminarEste);
        em.close();
        response.sendRedirect("ListaEmpresasServlet");
    }
}
