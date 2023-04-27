<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:url value="/entrada?accion=LoginUsuario" var="linkLogin"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <form action="${linkLogin}" method="post">
        <h3>nuevo usuario</h3>
        <label>Login</label>
        <input type="text" name="login"/>

        <label>Contraseña</label>
        <input type="password" name="contrasena"/>
        <input type="submit"/>
    </form>

</body>
</html>