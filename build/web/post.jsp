<%-- 
    Document   : index
    Created on : Aug 25, 2020, 3:52:11 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card">
                        <div class="card-body">
                            <form action="post.jsp" method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Humano, Esribe tu nombre</label>
                                    <input type="text" class="form-control" name="NombreDelHumano">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Humano, Esribe tu edad</label>
                                    <input type="number" class="form-control" name="edadDelHumano">
                                </div>
                                <button type="submit" class="btn btn-primary">Enviar</button>
                            </form>
                        </div>
                        <div class="alert alert-success" role="alert">
                            <%
                                String nombre = request.getParameter("NombreDelHumano");
                                String edad = request.getParameter("edadDelHumano");
                                if (nombre != null && edad != null) {
                                    int edadNumero = Integer.parseInt(edad);
                                    String saludar = "Hola, " + nombre + " , que tal los " + edadNumero + "s";
                                    out.println(saludar);
                                }else{
                                    out.println("Ingresar datos");
                                }
                            %>   
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</html>
