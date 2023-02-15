<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>

<!-- *****************************************************************************************************************
       OUR CLIENTS
       ***************************************************************************************************************** -->
<div id="cwrap">
    <div class="container">
        <div class="row centered">
            <h3>Insert New Product</h3>
            <form   action="operationController?page=showProducts&operation=createProduct" method="POST">

                <div class="form-group">
                    <input type="name" name="productId" class="form-control" id="contact-name" placeholder="product Id" data-rule="minlen:4" data-msg="Please enter at least 4 chars" >
                </div>
                <div class="form-group">
                    <input type="name" name="productName" class="form-control"  placeholder="product Name" >

                </div>
                
                <div class="form-group">
                    <input type="name" name="productQty" class="form-control" id="contact-name" placeholder="product Qty" data-rule="minlen:4" data-msg="Please enter at least 4 chars" >
                </div>
                <div class="form-group">
                    <input type="name" name="productPrice" class="form-control"  placeholder="product Price" >

                </div>
                
                
                <input type="submit" value="Save Data" />

            </form>
        </div>
    </div>
</div>

<!-- *****************************************************************************************************************
       FOOTER
       ***************************************************************************************************************** -->
<%@include file="footer.jsp" %>