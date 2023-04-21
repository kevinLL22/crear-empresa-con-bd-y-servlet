package com.example.gerenciador.servlet;

import com.example.gerenciador.dao.EmpresaDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.EmpresaEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ModificarEmpresaServlet", value = "/modEmpresa")
public class ModificarEmpresaServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);
        //getters
        Integer idModEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
        String nombre = request.getParameter("nombre");
        Date fechaAbertura= null;
        try {
            fechaAbertura=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaAbertura"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //entity
        EmpresaEntity empresa = empresaDao.findById(idModEmpresa);

        empresa.setNombre(nombre);
        empresa.setFechaAbertura(fechaAbertura);
        empresaDao.update(empresa);
        em.close();
        response.sendRedirect("ListaEmpresasServlet");
    }
}
