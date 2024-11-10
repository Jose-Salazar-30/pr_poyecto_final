<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        
        <!-- Agregar estilo para el fondo -->
        <style>
            body {
                background-image: url('images/font.jpg'); /* Cambia esta URL con la ruta de tu imagen */
                background-size: cover; /* Hace que la imagen cubra toda la pantalla */
                background-position: center center; /* Centra la imagen */
                background-attachment: fixed; /* Hace que la imagen de fondo se quede fija al hacer scroll */
                height: 100vh; /* Asegura que el fondo cubra toda la altura de la ventana */
                margin: 0;
                padding: 0;
                font-family: 'Arial', sans-serif; /* Establece una fuente predeterminada */
            }
        </style>

    </head>
    <body>
        
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="marca.jsp">Marcas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="producto.jsp">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="puesto.jsp">Puestos</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="empleado.jsp">Empleados</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="cliente.jsp">Clientes</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="proveedor.jsp">Proveedores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="venta.jsp">Ventas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="compra.jsp">Compras</a>
                        </li> 
                    </ul>
                    <!-- Botón de cerrar sesión -->
                    <a href="logout.jsp" class="btn btn-danger ml-3">Cerrar Sesión</a>
                </div>
            </div>
        </nav>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    </body>
</html>
