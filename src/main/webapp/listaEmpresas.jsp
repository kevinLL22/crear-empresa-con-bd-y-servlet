<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Lista de empresas</title>
</head>
<body>

    <ul>
        <c:forEach items="${empresasList}" var="empresa">
            <li> ${empresa.nombre} </li>
        </c:forEach>

    </ul>

</body>
</html>
