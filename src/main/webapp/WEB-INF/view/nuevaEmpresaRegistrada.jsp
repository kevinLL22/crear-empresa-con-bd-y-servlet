<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Empresa registrada</title>
</head>
<body>
<c:import url="logout-parcial.jsp"></c:import>

    <c:if test="${ not empty nombre }">
        <p>Empresa ${ nombre } registrada</p>
    </c:if>
    <c:if test="${ empty nombre}">
        <p>No se ha registrado una nueva empresa</p>
    </c:if>

</body>
</html>