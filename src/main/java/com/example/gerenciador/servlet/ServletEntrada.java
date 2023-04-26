package com.example.gerenciador.servlet;

import com.example.gerenciador.accion.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletEntrada", value = "/entrada")
public class ServletEntrada extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String urlResult = null;
        String paramAcccion = request.getParameter("accion");

        if(paramAcccion.equals("ListarEmpresas")){
            ListarEmpresas accion = new ListarEmpresas();
            urlResult = accion.ejecutar(request,response);

        } else if (paramAcccion.equals("EliminarEmpresa")) {
            EliminarEmpresa eliminarEmpresa = new EliminarEmpresa();
            urlResult = eliminarEmpresa.ejecutar(request,response);

        }else if (paramAcccion.equals("BuscarEmpresa")) {
            BuscarEmpresa buscarEmpresa = new BuscarEmpresa();
            urlResult = buscarEmpresa.ejecutar(request,response);

        }else if (paramAcccion.equals("ModificarEmpresa")) {
            ModificarEmpresa modificarEmpresa = new ModificarEmpresa();
            urlResult = modificarEmpresa.ejecutar(request,response);

        } else if (paramAcccion.equals("NuevaEmpresa")) {
        NuevaEmpresa modificarEmpresa = new NuevaEmpresa();
            urlResult = modificarEmpresa.ejecutar(request,response);
        }
        String[] tipoDireccion = urlResult.split(":");
        if (tipoDireccion[0].equals("forward")){
            //llamar al jsp con el dispacher
            RequestDispatcher rd = request.getRequestDispatcher(tipoDireccion[1]);
            //enviamos el request y response al jsp
            rd.forward(request,response);
        }else {
            //Al contrario que con el dispacher, ahora le decimos al navegador que vaya a esta otra dirección
            response.sendRedirect("/gerenciador/"+tipoDireccion[1]);

        }


    }

}
