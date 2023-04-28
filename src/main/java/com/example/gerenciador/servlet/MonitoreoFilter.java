package com.example.gerenciador.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/*Nuestro web filter va a la misma ruta que el servlet principal, así tenemos control de qué
* se ejecuta primero y en dónde*/
@WebFilter(urlPatterns = "/entrada")
public class MonitoreoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MonitoreoFilter");
        long before = System.currentTimeMillis();
        String accion = request.getParameter("accion");
        //Ejecución del controlador
        chain.doFilter(request,response);

        long after = System.currentTimeMillis();
        System.out.println("tiempo de ejecución de accion: " +accion+" -> " + (after-before));

    }

}
