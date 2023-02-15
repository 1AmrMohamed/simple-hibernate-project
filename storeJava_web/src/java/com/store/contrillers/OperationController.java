package com.store.contrillers;

import com.stock.entities.Product;
import com.stock.entities.User;
import com.stock.repos.ProductRepo;
import com.stock.repos.UserRepo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OperationController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String page = request.getParameter("page");
        String operation = request.getParameter("operation");

        if (page == null || page.equals("") || operation == null || operation.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            if (operation.equals("login")) {
                String usrName = request.getParameter("usrName");
                String password = request.getParameter("password");
                // Conn & Check USer
                UserRepo repo = new UserRepo();
                User user = repo.checkUser(usrName, password);
                if(user == null){
                    response.sendRedirect("index.jsp");
                }else{
                    HttpSession session = request.getSession();
                    session.setAttribute("usr", user);
                    request.getRequestDispatcher("menuAppController?page=" + page).forward(request, response);
                }
            } else if(operation.equals("createProduct")){
                String productId = request.getParameter("productId");
                String productName = request.getParameter("productName");
                String productQty = request.getParameter("productQty");
                String productPrice = request.getParameter("productPrice");
                
                Product product = new Product(); // Entity
                product.setProductId(Integer.parseInt(productId));
                product.setProductName(productName);
                product.setProductPrice(Integer.parseInt(productPrice));
                product.setProductQty(Integer.parseInt(productQty));
                ProductRepo repo = new ProductRepo();
                int res = repo.insert(product);
                request.getRequestDispatcher("menuAppController?page=" + page).forward(request, response);
            }
            
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
