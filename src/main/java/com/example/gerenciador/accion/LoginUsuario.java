package com.example.gerenciador.accion;

import com.example.gerenciador.dao.UsuarioDao;
import com.example.gerenciador.factory.FactoryEmpresa;
import com.example.gerenciador.modelo.UsuarioEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;

public class LoginUsuario implements Accion {
    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String contrasena = request.getParameter("contrasena");
        UsuarioDao usuarioDao = new UsuarioDao(FactoryEmpresa.entityManager());
        UsuarioEntity usuario = usuarioDao.findByLogin(login, contrasena);
        if (usuario!=null){
            System.out.println("Usuario existe");
            HttpSession session = request.getSession();
            /*¿Por qué se está usando un http session en lugar de un "htttp request"?
             porque las peticiones request mueren cuando se está enviando otra request, en este caso
             el navegador solicita otra vista, así que la request ahora es diferente, pero, al ser el mismo
             navegador la session es la misma*/
            session.setAttribute("usuario",usuario);
            return "redirect:entrada?accion=ListarEmpresas";
        }
        return "redirect:entrada?accion=FormUsuario";
    }
}
