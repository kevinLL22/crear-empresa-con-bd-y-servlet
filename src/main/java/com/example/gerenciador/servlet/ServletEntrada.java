package com.example.gerenciador.servlet;

import com.example.gerenciador.accion.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Constructor;

@WebServlet(name = "ServletEntrada", value = "/entrada")
public class ServletEntrada extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String paramAcccion = request.getParameter("accion");

        boolean noLogeado = (session.getAttribute("usuario") == null);
        boolean NoEstaProtegido = !(paramAcccion.equals("LoginUsuario")||paramAcccion.equals("FormUsuario"));

        if (noLogeado && NoEstaProtegido){
            response.sendRedirect("/gerenciador/entrada?accion=LoginUsuario");
            return;
        }

        String nombreClase = "com.example.gerenciador.accion."+paramAcccion;
        Class clase = null;
        Accion accion = null;
        try {
            clase = Class.forName(nombreClase);
            //Constructor <?> constructor = clase.getDeclaredConstructor();
            //Object objeto = constructor.newInstance();  <-- alternativa a "clase.newInstance"
            accion = (Accion) clase.newInstance();
        } catch (ClassNotFoundException |InstantiationException | IllegalAccessException  e) {
            throw new RuntimeException(e);
        }

        String urlResult = accion.ejecutar(request,response);
        String[] tipoDireccion = urlResult.split(":");
        if (tipoDireccion[0].equals("forward")){
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoDireccion[1]);//llamar al jsp con el dispacher
            rd.forward(request,response);//enviamos el request y response al jsp
        }else {
            response.sendRedirect("/gerenciador/"+tipoDireccion[1]);//Al contrario que con el dispacher, ahora le decimos al navegador que vaya a esta otra dirección
        }
        /*if(paramAcccion.equals("ListarEmpresas")){
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
            NuevaEmpresa nuevaEmpresa = new NuevaEmpresa();
            urlResult = nuevaEmpresa.ejecutar(request,response);

        } else if (paramAcccion.equals("FormNuevaEmpresa")) {
            FormNuevaEmpresa formNuevaEmpresa = new FormNuevaEmpresa();
            urlResult = formNuevaEmpresa.ejecutar(request,response);
        }*/
        //Forward = vamos a un jsp   redirect = llamamos a otra acción, otra petición
    }

}
