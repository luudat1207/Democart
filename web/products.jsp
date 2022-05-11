<%-- 
    Document   : products
    Created on : Feb 18, 2022, 11:51:32 AM
    Author     : lephu
--%>

<%@page import="models.Product"%>
<%@page import="models.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <div>
            <div>
                <a href="viewcart">Xem gio hang</a>
            </div>
            <%@include file="categorylist.jsp" %>
            <%@include file="productlist.jsp" %>
        </div>
    </body>
</html>
