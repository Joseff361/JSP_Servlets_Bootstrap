<%-- 
    Document   : carrito
    Created on : Aug 26, 2020, 8:57:21 PM
    Author     : Usuario
--%>

<%@page import="pe.edu.unmsm.sistemas.Usuario"%>
<%@page import="pe.edu.unmsm.sistemas.PaypalStrategy"%>
<%@page import="pe.edu.unmsm.sistemas.TarjetaDeCreditoStrategy"%>
<%@page import="pe.edu.unmsm.sistemas.VaciarCarrito"%>
<%@page import="pe.edu.unmsm.sistemas.Carrito"%>
<%@page import="pe.edu.unmsm.sistemas.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="/MiniProyecto/css/estilos.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <title>Carrito</title>

    </head>
    <body> 

        <div class="fondo2">
            <jsp:include page="nabvar.jsp"/>
            <div class="row mt-5">
                <div class="col-md-7 mx-auto">
                    <div class="card">
                        <h1 class="text-center">Carrito de Compras</h1>
                        <%
                        Usuario usuario = (Usuario)(session.getAttribute("usuario"));
                        %>
                        <p>Cliente: <%= usuario.getNombre1() +  " " + usuario.getNombre2() + " " + usuario.getApellido() %></p>
                        <p>Enviar a: <%= usuario.getDireccion() %></p>
                        <p>Datos de la tarjeta:</p>
                        <p>*Numero: <%= usuario.getTarjeta().getNumero() %></p>
                        <p>*Fecha vencimiento: <%= usuario.getTarjeta().getMesVencimiento()+"/"+ usuario.getTarjeta().getAnioVencimiento()%></p>
                        <p>*CVV: <%= usuario.getTarjeta().getCVV() %></p>
                        
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="text-center">
                                        <form action="calcularPrecio" method="get">
                                            <%
                                                String precio = "0.0";
                                                if (session.getAttribute("precioFinal") != null) {
                                                    precio = session.getAttribute("precioFinal").toString();
                                                }
                                            %>
                                            <p>Precio Final: S/.<%=precio%></p>
                                            <button class="btn btn-success"
                                                    type="submit"
                                                    value="tarjeta"
                                                    name="modalidad"
                                                    >Pago con tarjeta</button>
                                            <br><br>
                                            <button class="btn btn-warning"
                                                    type="submit"
                                                    value="paypal"
                                                    name="modalidad"
                                                    >Pago mediante paypal</button>
                                        </form>
                                        <%
                                            String msg = "";
                                            if (session.getAttribute("modalidad") != null) {
                                                msg = session.getAttribute("modalidad").toString();
                                            }
                                            if (session.getAttribute("carrito") != null) {
                                                Carrito carrito = (Carrito) session.getAttribute("carrito");
                                                System.out.println("==========" + carrito.getItems().toString());
                                                if (!msg.equals("") && carrito.getItems().toString().equals("[]")) {
                                        %>
                                        <br>
                                        <div class="alert alert-success" role="alert">
                                            <%=msg%>
                                        </div>
                                        <%
                                                }
                                            }
                                            session.setAttribute("modalidad", "");
                                        %>
                                    </div>
                                </div>  
                                <div class="col-md-7 text-center table">
                                    <table style="width:100%">
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Precio</th>
                                            <th>Cantidad</th>
                                            <th><strong>Total</strong></th>
                                            <th></th>
                                        </tr>
                                        <tr>
                                            <%
                                                if (session != null) {
                                                    if (session.getAttribute("productos") != null) {
                                                        Carrito carrito = (Carrito) session.getAttribute("productos");
                                                        if (carrito != null) {
                                                            for (Item item : carrito.getItems()) {
                                                                double totalParcial = item.getCantidad() * item.getPrecio();
                                            %>
                                            <td><%=item.getNombre()%></td>
                                            <td><%=item.getPrecio()%></td>
                                            <td><%=item.getCantidad()%></td>
                                            <td><%=totalParcial%></td>
                                            <td>
                                                <form method="post" action="calcularPrecio?eliminar=<%=item.getNombre()%>">
                                                    <button 
                                                        type="submit"
                                                        >
                                                        <i class="fa fa-trash-o" aria-hidden="true"></i></button>
                                                </form>
                                            </td>

                                        </tr>
                                        <%
                                                        }
                                                    }
                                                }
                                            }
                                        %> 
                                    </table>
                                </div>
                            </div>
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
