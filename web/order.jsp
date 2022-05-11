<%-- 
    Document   : order
    Created on : Feb 19, 2022, 11:41:37 AM
    Author     : lephu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.Shipper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% ArrayList<Shipper> shippers = (ArrayList<Shipper>) request.getAttribute("shippers");%>
    </head>
    <body>
        <h1>Mua hang</h1>
        <%@include file="productlist.jsp" %>
        <form action="order" method="post">
            <input type="date" name="RequiredDate">
            <select name="Shipper">
                <% for(Shipper s: shippers) {%>
                <option value="<%= s.getShipId()%>"><%=s.getCompanyName()%></option>
                <%}%>
            </select>
            <input type="text" name="ShipName">
            <input type="text" name="ShipAddress">
            <input type ="submit" name="btSubmit" value="Submit">
        </form>
    </body>
</html>
