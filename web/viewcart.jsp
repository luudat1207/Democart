<%-- 
    Document   : viewcart
    Created on : Feb 19, 2022, 11:09:39 AM
    Author     : lephu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% String mess = request.getAttribute("mess").toString(); %>
    </head>
    <body>
        <h1><%=mess%></h1>
        <%@include file="categorylist.jsp" %>
        <%@include file="productlist.jsp" %>
        <div>
            <a href="order">Mua hang</a>
        </div>
    </body>
</html>
