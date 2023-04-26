package com.example.gerenciador.accion;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FormNuevaEmpresa {
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "forward:formNuevaEmpresa.jsp";
    }
}
