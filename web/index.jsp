<%-- 
    Document   : index
    Created on : 21/10/2024, 12:25:44 p. m.
    Author     : josej
--%>

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
    </head>
    <body>
        <h1>Hello</h1>
        
        <a href="marca.jsp">Marcas</a>
        
    </body>
</html>
