<%-- 
    Document   : productlist
    Created on : Feb 19, 2022, 11:11:16 AM
    Author     : lephu
--%>

<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div style="width: 60%; float: left;">
    <% ArrayList<Product> pros = (ArrayList<Product>) request.getAttribute("products"); %>
    <% if (pros != null && pros.size()!= 0){%>
    <div >
                <h1>List of products</h1>
                
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Category</th>
                            <th>UnitPrice</th>
                            <th>UnitsInStock</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(Product e: pros) {%>
                        <tr>
                            <td><%= e.getProductId()%></td>
                            <td><%= e.getProductName()%></td>
                            <td><%= e.getCategory().getCatName()%></td>
                            <td><%= e.getUnitPrice()%></td>
                            <td><%= e.getUnitsInStock()%></td>
                            <td><a href="addtocart?pid=<%=e.getProductId()%>&cid=<%=e.getCategory().getCatId()%>">Add to cart</a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
    <%}%>
</div>
