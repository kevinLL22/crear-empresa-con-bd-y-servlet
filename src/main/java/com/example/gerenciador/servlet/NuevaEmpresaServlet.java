package com.example.gerenciador.servlet;

import com.example.gerenciador.dao.EmpresaDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.EmpresaEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/nuevaEmpresa")
public class NuevaEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //al definir el método como "doPost" obligamos a que solo reciba post
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*Con el HttpServletRequest obtenemos respuestas del navegador
        con el HttpServletResponse devolvemos un html al navegador
        PrintWriter salida = resp.getWriter(); */

        String nombre = req.getParameter("nombre");

        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);
        EmpresaEntity empresa = new EmpresaEntity(nombre);
        empresaDao.save(empresa);
        em.close();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/nuevaEmpresaRegistrada.jsp");
        req.setAttribute("nombre",empresa.getNombre());
        requestDispatcher.forward(req,resp);

    }
}
