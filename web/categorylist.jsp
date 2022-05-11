<%-- 
    Document   : categorylist
    Created on : Feb 19, 2022, 11:13:21 AM
    Author     : lephu
--%>

<%@page import="models.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div style="width: 30%; float: left;">
    <%
            ArrayList<Category> cats = (ArrayList<Category>) request.getAttribute("cats");
            
    %>
    <div >
                
        <%for(Category c: cats){%>
        <div style="margin:4px;">
        <a href ="products?cid=<%=c.getCatId()%>"><%=c.getCatName()%></a>
        </div>
        <%}%>
    </div>
</div>
