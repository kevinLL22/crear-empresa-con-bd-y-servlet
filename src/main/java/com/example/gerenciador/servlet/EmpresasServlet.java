package com.example.gerenciador.servlet;

import com.example.gerenciador.dao.EmpresaDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.EmpresaEntity;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpresasServlet", value = "/empresas")
public class EmpresasServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = FactoryEmpresa.entityManager();
        EmpresaDao empresaDao = new EmpresaDao(em);
        List<EmpresaEntity> empresasList = empresaDao.findAll();

        String valor = request.getHeader("Accept");//Con el header sé que tipo de dato es pedido

        if (valor.contains("xml")){
            //Devolviendo un xml
            XStream xStream = new XStream();
            xStream.alias("empresa",EmpresaEntity.class); //Con esta linea cambio el nombre que muestra por cada objeto
            String toXML = xStream.toXML(empresasList);
            response.setContentType("Application/xml");
            response.getWriter().print(toXML);

        }else if (valor.contains("json")){
            //Devolviendo un json:
            Gson gson = new Gson();
            String toJson = gson.toJson(empresasList);
            response.setContentType("Application/json"); //De esta forma decimos que el tipo de dato que devolvemos es un json
            response.getWriter().print(toJson);

        }else {
            response.setContentType("Application/json"); //De esta forma decimos que el tipo de dato que devolvemos es un json
            response.getWriter().print("{'message':'No content'}");
        }


    }


}
