<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate(); // Elimina la sesión actual
    response.sendRedirect("login.jsp"); // Redirige a la página de login
%>