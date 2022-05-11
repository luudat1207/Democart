/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dal.CategoryDao;
import dal.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Category;
import models.Product;

/**
 *
 * @author lephu
 */
@WebServlet(name = "viewcart", urlPatterns = {"/viewcart"})
public class viewcart extends HttpServlet {

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
        ArrayList<Integer> productIds = getProductsInCart(request, response);
        String mess;
        ArrayList<Product> products = new ArrayList<>();
        System.out.println("ProductIds: " + productIds.toString());
        if (productIds == null || productIds.size()==0)
            mess = "Hien khong co san pham nao trong gio hang";
        else 
        {
            mess = "Danh sach san pham trong gio hang: ";
            ProductDao dao = new ProductDao();
            products = dao.getProducts(productIds);
        }
        
        request.setAttribute("products", products);
        request.setAttribute("mess", mess);
        loadCategories(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewcart.jsp");
        dispatcher.forward(request, response);
    }
        
    private void loadCategories(HttpServletRequest request, HttpServletResponse response)
    {
        CategoryDao catDao = new CategoryDao();
        ArrayList<Category> cats = catDao.getAllCategories();
        request.setAttribute("cats", cats);
    }
    
    private ArrayList<Integer> getProductsInCart(HttpServletRequest request, HttpServletResponse response)
    {
        ArrayList<Integer> products = new ArrayList<>();
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null)
            products = (ArrayList<Integer>) session.getAttribute("cart");        
        return products;
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
