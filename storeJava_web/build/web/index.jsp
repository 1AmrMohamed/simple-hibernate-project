<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Solid - Bootstrap Business Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicons -->
        <link href="img/favicon.png" rel="icon">
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Raleway:400,700,900|Lato:400,900" rel="stylesheet">

        <!-- Bootstrap CSS File -->
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Libraries CSS Files -->
        <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
        <link href="lib/hover/hoverex-all.css" rel="stylesheet">

        <!-- Main Stylesheet File -->
        <link href="css/style.css" rel="stylesheet">

        <!-- =======================================================
          Template Name: Solid
          Template URL: https://templatemag.com/solid-bootstrap-business-template/
          Author: TemplateMag.com
          License: https://templatemag.com/license/
        ======================================================= -->
    </head>

    <body>

        <!-- Fixed navbar -->
        <div class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">SOLID.</a>
                </div>
                
                <!--/.nav-collapse -->
            </div>
        </div>



        <!-- *****************************************************************************************************************
               OUR CLIENTS
               ***************************************************************************************************************** -->
        <div id="cwrap">
            <div class="container">
                <div class="row centered">
                    <h3>Login To System</h3>
                    <form   action="operationController?page=home&operation=login" method="POST">

                        <div class="form-group">
                            <input type="name" name="usrName" class="form-control" id="contact-name" placeholder="User Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" >
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" class="form-control"  placeholder="Password" >
                            
                        </div><input type="submit" value="Login" />

                    </form>
                </div>
            </div>
        </div>

        <!-- *****************************************************************************************************************
               FOOTER
               ***************************************************************************************************************** -->
        <%@include file="footer.jsp" %>