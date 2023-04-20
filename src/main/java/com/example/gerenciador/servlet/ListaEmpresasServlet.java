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
import java.util.List;

@WebServlet(urlPatterns = "/ListaEmpresasServlet")
public class ListaEmpresasServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);
        List<EmpresaEntity> empresasList = empresaDao.findAll();

        //llamar al jsp con el dispacher
        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");

        //añadimos al request un parametro, para poder mandarlo después junto al request
        request.setAttribute("empresasList", empresasList);

        //enviamos el request y response al jsp
        rd.forward(request,response);
    }

}
