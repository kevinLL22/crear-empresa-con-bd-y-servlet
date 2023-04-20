<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/nuevaEmpresa" var="linkServletNuevaEmpresa"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>nueva empresaEntity</title>
</head>
<body>


    <form action="${linkServletNuevaEmpresa}" method="post">
        nueva empresa Entity
        <input type="text" name="nombre"/>
        <input type="submit"/>
    </form>
</body>
</html>