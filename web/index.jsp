<%-- 
    Document   : index
    Created on : Aug 25, 2020, 3:52:11 PM
    Author     : Usuario
--%>

<%@page import="pe.edu.unmsm.sistemas.Item"%>
<%@page import="pe.edu.unmsm.sistemas.Carrito"%>
<%@page import="pe.edu.unmsm.sistemas.Articulo"%>
<%@page import="pe.edu.unmsm.sistemas.Articulos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="/MiniProyecto/css/estilos.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="fondo1">
            <jsp:include page="nabvar.jsp"/>


            <div class="container mt-5">
                <div class="row">
                    <%
                        Articulos catalogo = Articulos.Singleton();
                        Carrito carrito = (Carrito) session.getAttribute("carrito");
                        for (Articulo articulo : catalogo.getArticulos()) {
                    %>
                    <div class="col-md-4">
                        <div class="card my-2">
                            <div class="card-header text-center">
                                En venta
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-7">
                                        <form action="index.jsp" method="post">
                                            <p><strong>Producto: </strong><%= articulo.getDescripcion()%> </p>
                                            <p><strong>Precio: </strong>S/. <%= articulo.getPrecioDeVenta()%> </p>
                                            <p><strong>Stock: </strong> <%= articulo.getStock()%> </p>
                                            <button class="btn btn-primary mt-2" 
                                                    data-toggle="modal" data-target="#exampleModal<%= articulo.getCodigo()%>"
                                                    type="button"                                                    
                                                    >Agregar</button>
                                            <!-- Modal -->
                                            <div class="modal fade" id="exampleModal<%= articulo.getCodigo()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="exampleModalLabel">Ingrese la cantidad de productos</h5>
                                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                <span aria-hidden="true">&times;</span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="form-group">
                                                                <label>Precio: </label>
                                                                <input class="form-control" value="<%=articulo.getPrecioDeVenta()%>"
                                                                       name="precio"
                                                                       readonly
                                                                       ></input>
                                                            </div>
                                                            <div class="form-group">
                                                                <label>Cantidad: </label>
                                                                <%
                                                                    int cantidad = 0;
                                                                    if (carrito!=null && carrito.getItem(articulo.getDescripcion())!=null){
                                                                        cantidad = carrito.getItem(articulo.getDescripcion()).getCantidad();
                                                                    }
                                                                %>
                                                                <input class="form-control" type="number"
                                                                       name="cantidad" value="<%=cantidad%>"
                                                                       ></input>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                                            <button type="submit" class="btn btn-primary"
                                                                    name="nombre"
                                                                    value="<%= articulo.getDescripcion()%>"
                                                                    >Agregar al carrito</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div clas="col-md-5">
                                        <img src="/MiniProyecto/imagenes/<%= articulo.getUrl()%>.jpg" width="140" height="155">
                                    </div>                              
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                        
                        //Verificando si es que existe la instancia de "Carrito"
                        if (carrito == null) {
                            System.out.println("Creando el carrito en la sesion desde index.jsp");
                            carrito = new Carrito();
                            session.setAttribute("carrito", carrito);
                        } else {
                            //Obteniendo valores via post

                            if (request.getParameter("nombre") != null && request.getParameter("cantidad") != null && request.getParameter("precio") != null) {
                                if (!request.getParameter("cantidad").equals("") && !request.getParameter("cantidad").equals("0") && !request.getParameter("precio").equals("")) {
                                    
                                    //Obteniendo parametros
                                    String nombre = request.getParameter("nombre");
                                    int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                                    double precio = Double.parseDouble(request.getParameter("precio"));
                                    out.println(nombre + cantidad + precio);
                                    
                                    //Agregando item al carrito
                                    if(carrito.getItem(nombre) == null){
                                        Item item = new Item(nombre, cantidad, precio);
                                        carrito.agregarItem(item);
                                    }else{
                                        carrito.actualizarCantidadItem(nombre, cantidad);
                                    }
                                }else
                                {
%>
                                <script>alert("El campo cantidad debe ser mayor a 0");</script>
<% 
                                }
                            }
                        }
                        out.println(carrito.toString());
                        //Agregando el carrito como atributo de sesion
                        session.setAttribute("productos", carrito);
                    %>
                </div>
            </div>
        </div>  

    </body>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</html>
