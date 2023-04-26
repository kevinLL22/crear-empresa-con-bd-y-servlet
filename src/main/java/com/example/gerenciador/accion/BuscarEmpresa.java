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

public class BuscarEmpresa {
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //obtenemos los parametros del formulario a partir del nombre de este
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));

        //Nos conectamos con la bd
        EntityManager em = FactoryEmpresa.entityManager();

        //Creamos el dao de la entidad
        EmpresaDao empresaDao = new EmpresaDao(em);

        EmpresaEntity empresa = empresaDao.findById(idEmpresa);

        //podemos pasar, como string, la entidad
        request.setAttribute("empresa",empresa);
        em.close();
        return "forward:modificarEmpresa.jsp";
    }

}
