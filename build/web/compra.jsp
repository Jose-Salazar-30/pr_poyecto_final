<%@page import="java.util.HashMap"%>
<%@page import="modelo.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registrar Compra</title>
    <!-- Agregar Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEJ6A6qmxPZ02v4j2O5b5JZOIcu+9F3/ba1HkRqaJ2cPTfY00LNCfF+j0vNa0" crossorigin="anonymous">
    
    <!-- Agregar estilos personalizados -->
    <style>
        body {
            background-color: #f7f7f7;
            font-family: 'Arial', sans-serif;
        }

        .container {
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            margin-top: 30px;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #004085;
        }

        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }

        .btn-danger:hover {
            background-color: #c82333;
            border-color: #bd2130;
        }

        .form-label {
            font-weight: bold;
        }

        .form-control {
            border-radius: 8px;
        }

        .table th, .table td {
            vertical-align: middle;
        }

        .table-bordered th, .table-bordered td {
            border-color: #dee2e6;
        }

        .table-bordered td {
            padding: 10px;
        }

        .input-group-text {
            background-color: #f1f1f1;
        }

        .input-group input {
            border-radius: 5px;
        }

        .input-group-text {
            border-radius: 5px;
        }

        .my-4 {
            color: #007bff;
            font-weight: bold;
        }

        h2, h3 {
            text-align: center;
            margin-bottom: 30px;
        }
        
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }

        .btn-add {
            width: 100%;
        }

        .tooltip-inner {
            background-color: #007bff;
        }

        /* Centrar la tabla de detalles de compra */
        .detalles-container {
            display: flex;
            justify-content: center;
            margin-bottom: 30px;
        }

        /* Centrar el título y los campos del formulario */
        .form-section {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            text-align: center;
        }

        .form-control, .form-select {
            width: 100%;
            max-width: 400px;
        }

        .form-label {
            text-align: center;
        }

        /* Alinear el botón de registro */
        .btn-submit {
            width: 100%;
            max-width: 200px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <!-- Centrar el título -->
        <h1 class="mt-4 mb-3 text-center">Registrar Nueva Compra</h1>
        
        <form action="sr_compra" method="POST">
            <div class="form-section">
                <!-- Campos de la compra -->
                <div class="mb-3">
                    <label for="no_orden_compra" class="form-label">No Orden de Compra:</label>
                    <input type="number" name="no_orden_compra" class="form-control" id="no_orden_compra" required>
                </div><br>

                <div class="mb-3">
                    <label for="fecha_orden" class="form-label">Fecha de Orden:</label>
                    <input type="date" name="fecha_orden" class="form-control" id="fecha_orden" required>
                </div><br>

                <div class="mb-3">
                    <label for="fecha_ingreso" class="form-label">Fecha de Ingreso:</label>
                    <input type="date" name="fecha_ingreso" class="form-control" id="fecha_ingreso" required>
                </div><br>

                <div class="mb-3">
                    <label for="id_proveedor" class="form-label">Proveedor ID:</label>
                    <select name="id_proveedor" id="id_proveedor" class="form-select" required>
                        <%
                            Proveedor proveedor = new Proveedor();
                            HashMap<String,String> drop1 = proveedor.drop_proveedor();
                            for (String i: drop1.keySet()){
                                out.println("<option value='"+ i + "'>" + drop1.get(i) +"</option>");
                            }
                        %>
                    </select>
                </div><br>

                <!-- Campos para Detalles de la Compra -->
                <h3 class="mt-4 mb-3 text-center">Detalles de la Compra</h3>

                <div class="mb-3">
                    <label for="cantidad" class="form-label">Cantidad:</label>
                    <input type="number" name="cantidad" class="form-control" id="cantidad" required>
                </div><br>

                <div class="mb-3">
                    <label for="precio_costo_unitario" class="form-label">Precio Costo Unitario:</label>
                    <input type="number" name="precio_costo_unitario" class="form-control" id="precio_costo_unitario" required>
                </div><br>

                <div class="mb-3">
                    <label for="id_producto" class="form-label">ID Producto:</label>
                    <input type="number" name="id_producto" class="form-control" id="id_producto" required>
                </div><br>

                <button type="submit" class="btn btn-primary btn-submit">Registrar Compra</button>
            </div>
        </form>
    </div>

    <!-- Agregar Bootstrap JS (opcional) -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9gybGyKbHEV7z5t6t3/tqW5w4tKccB2vRpnJ7tU2dKzKpi6A0p/9" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0YPsm5K7J9+du/5p5g/2zF34TeT4jpUs5QpzpGiVAsY9FyT+" crossorigin="anonymous"></script>
</body>
</html>
