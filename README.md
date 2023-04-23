# crear-empresa-con-bd-y-servlet

## Introducción

Proyecto de creación de una empresa usando servlet y conectándose a una base de datos. En este proyecto es posible: Crear una empresa a partir de un formulario, listar, editar y eliminar las empresas existentes.

## Cómo usarlo

Después de bajar el proyecto edita el archivo “persistence.xml” que se encuentra en “/src/main/resources/META-INF/” con los valores de conexión a tu base de datos. Después, puedes correr el proyecto haciendo uso de un IDE o exportándolo como un .war y corriéndolo en un servidor

### Para mis compañeros de alura

Si solo quieren los archivos que permiten la conexión con la bd solo necesitan las carpetas dao, factory y modelo, y el archivo de persistence.xml. Todo lo demás lo pueden ir creando según avancen en las clases. En la clase “BuscarEmpresaServlet” pueden ver un buen ejemplo de cómo se está creando la conexión con la bd y encontrando algún registro.
