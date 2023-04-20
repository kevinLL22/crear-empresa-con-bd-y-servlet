<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Lista de empresas</title>
</head>
<body>
    <c:if test="${ not empty nombre }">
        <h3>Nueva empresa registrtada</h3>
        <p>Empresa ${ nombre } registrada</p>
    </c:if>
    <c:if test="${ empty nombre}">
        <p>No se ha registrado una nueva empresa</p>
    </c:if>
    <h1>Lista de empresas</h1>
    <ul>
        <c:forEach items="${empresasList}" var="empresa">
            <li> ${empresa.nombre} - <fmt:formatDate value="${empresa.fechaAbertura}" pattern="dd/MM/YYYY"/> </li>
        </c:forEach>

    </ul>

</body>
</html>
