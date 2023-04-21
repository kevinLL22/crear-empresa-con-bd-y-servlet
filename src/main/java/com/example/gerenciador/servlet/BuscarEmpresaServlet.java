package com.example.gerenciador.servlet;

import com.example.gerenciador.dao.EmpresaDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.EmpresaEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;
import java.io.IOException;

@WebServlet(name = "BuscarEmpresaServlet", value = "/buscarEmpresa")
public class BuscarEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //obtenemos los parametros del formulario a partir del nombre de este
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));

        //Nos conectamos con la bd
        EntityManager em = FactoryEmpresa.entityManager();

        //Creamos el dao de la entidad
        EmpresaDao empresaDao = new EmpresaDao(em);

        EmpresaEntity empresa = empresaDao.findById(idEmpresa);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/modificarEmpresa.jsp");
        //podemos pasar, como string, la entidad
        request.setAttribute("empresa",empresa);

        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
