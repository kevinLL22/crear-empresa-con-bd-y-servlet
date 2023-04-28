package com.example.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns ="/entrada")
public class AutorizacionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws ServletException, IOException {

        System.out.println("AutorizacionFilter");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String paramAcccion = request.getParameter("accion");

        boolean noLogeado = (session.getAttribute("usuario") == null);
        boolean NoEstaProtegido = !(paramAcccion.equals("LoginUsuario")||paramAcccion.equals("FormUsuario"));

        if (noLogeado && NoEstaProtegido){
            response.sendRedirect("/gerenciador/entrada?accion=LoginUsuario");
            return;
        }
        chain.doFilter(request, response);
    }
}
