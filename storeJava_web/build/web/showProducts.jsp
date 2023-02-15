<%@page import="com.stock.entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>

<!-- *****************************************************************************************************************
       OUR CLIENTS
       ***************************************************************************************************************** -->
<div id="cwrap">
    <div class="container">
        <div class="row centered">
            <h3>This Is All Products</h3>
            <table border="0" width="75%">
                    <tr>
                        <th>Product Id</th>
                        <th>Product Name</th>
                        <th>Product Price</th>
                        <th>Product QTY</th>
                    </tr>
                    
                    <%
                        ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
                        for (Product product : products) { %>
                        
                            <tr> <td><%= product.getProductId()%></td> <td><%= product.getProductName()%></td> <td><%= product.getProductPrice() %></td> <td><td><%= product.getProductQty() %></td> </tr>
                    <%    }
                    %>
                    
                    
            </table>

        </div>
    </div>
</div>

<!-- *****************************************************************************************************************
       FOOTER
       ***************************************************************************************************************** -->
<%@include file="footer.jsp" %>