package com.example.gerenciador.accion;

import com.example.gerenciador.dao.UsuarioDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.UsuarioEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import java.io.IOException;

public class LoginUsuario implements Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String contrasena = request.getParameter("contrasena");
        UsuarioDao usuarioDao = new UsuarioDao(FactoryEmpresa.entityManager());
        UsuarioEntity byLogin = usuarioDao.findByLogin(login, contrasena);
        if (byLogin!=null){
            System.out.println("Usuario existe");
            return "redirect:entrada?accion=ListarEmpresas";
        }
        return "redirect:entrada?accion=FormUsuario";
    }
}
