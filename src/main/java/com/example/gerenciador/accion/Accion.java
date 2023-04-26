package com.example.gerenciador.accion;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Accion {
    String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
