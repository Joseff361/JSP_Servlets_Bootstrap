/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "calcularPrecio", urlPatterns = {"/calcularPrecio"})
public class calcularPrecio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);
        if (session.getAttribute("productos") != null) {
            Carrito carrito = (Carrito) session.getAttribute("productos");

            if (carrito != null) {
                //Actualizando items
                if (request.getParameter("eliminar") != null) {
                    for (Iterator<Item> iterator = carrito.getItems().iterator(); iterator.hasNext();) {
                        Item item = iterator.next();
                        if (item.getNombre().equals(request.getParameter("eliminar"))) {
                            iterator.remove();
                        }
                    }
                }

                //Precio final como atributo de sesion
                double precioFinal = 0.0;
                for (Item item : carrito.getItems()) {
                    precioFinal += (item.getCantidad() * item.getPrecio());
                }

                session.setAttribute("precioFinal", new Double(precioFinal));
                session.setAttribute("productos", carrito);

                //Metodo de Pago
                if (request.getParameter("modalidad") != null) {
                    String msg = "";
                    VaciarCarrito vaciarCarrito = new VaciarCarrito();
                    String modalidad = request.getParameter("modalidad");
                    if (modalidad.equals("tarjeta")) {
                        msg = vaciarCarrito.pagar(new TarjetaDeCreditoStrategy(), session.getAttribute("precioFinal").toString());
                    } else {
                        msg = vaciarCarrito.pagar(new PaypalStrategy(), session.getAttribute("precioFinal").toString());
                    }
                    //Vaciar carrito
                     for (Iterator<Item> iterator = carrito.getItems().iterator(); iterator.hasNext();) {
                        Item item = iterator.next();
                        iterator.remove();
                    }
                    session.setAttribute("modalidad", msg);
                }

            }
        }

        response.sendRedirect("/MiniProyecto/carrito.jsp");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calcularPreci</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet calcularPreci at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
