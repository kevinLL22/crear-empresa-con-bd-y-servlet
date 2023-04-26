<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/entrada?accion=ModificarEmpresa" var="modEmpresa"/>

<html>
<head>
    <title>Modificar empresa</title>
</head>
<body>

  <form action="${modEmpresa}" method="post">
    modificar empresa:
    <input type="text" value="${empresa.nombre}" name="nombre"/>
    <input type="text" value="${empresa.fechaAbertura}" name="fechaAbertura"/>
    <input type="hidden" value="${empresa.id}" name="idEmpresa">
    <input type="submit"/>
  </form>

</body>
</html>
