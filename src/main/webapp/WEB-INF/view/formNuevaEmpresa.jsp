<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/entrada?accion=NuevaEmpresa" var="linkServletNuevaEmpresa"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>nueva empresa</title>
</head>
<body>

    <form action="${linkServletNuevaEmpresa}" method="post">
        nueva empresa
        <input type="text" name="nombre"/>
        <input type="submit"/>
    </form>

</body>
</html>