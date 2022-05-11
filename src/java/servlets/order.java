/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.oracle.jrockit.jfr.RequestDelegate;
import dal.ProductDao;
import dal.ShipperDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.OrderLogic;
import models.Order;
import models.OrderDetail;
import models.Product;
import models.Shipper;

/**
 *
 * @author lephu
 */
@WebServlet(name = "order", urlPatterns = {"/order"})
public class order extends HttpServlet {

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
        
        ShipperDao shipperdao = new ShipperDao();
        ArrayList<Shipper> shippers = shipperdao.getAllShippers();
        
        request.setAttribute("products", products);
        request.setAttribute("shippers", shippers);
        request.setAttribute("mess", mess);
        RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
        dispatcher.forward(request, response);
        
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
        request.setAttribute("sucmess", ""); 
        processRequest(request, response);
    }

    private ArrayList<Integer> getProductsInCart(HttpServletRequest request, HttpServletResponse response)
    {
        ArrayList<Integer> products = new ArrayList<>();
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null)
            products = (ArrayList<Integer>) session.getAttribute("cart");        
        return products;
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
        //lay thong tin order
        Shipper shipper = new Shipper(Integer.parseInt(request.getParameter("Shipper")));
        Order order = new Order(
                LocalDate.parse(request.getParameter("RequiredDate")), 
                shipper, 
                request.getParameter("ShipName"), 
                request.getParameter("ShipAddress"));
        //lay ds order detail
        ArrayList<Integer> productIds = getProductsInCart(request, response);
        ArrayList<OrderDetail> orderdetails = new ArrayList<>();
        for(Integer productId: productIds)
        {
            OrderDetail detail = new OrderDetail(productId, 1);
            orderdetails.add(detail);
        }
        OrderLogic orderlogic = new OrderLogic(order, orderdetails);
        orderlogic.insertOrder();
        clearCart(request);
        String mess = "them order thanh cong";
        request.setAttribute("sucmess", mess);
        processRequest(request, response);
        
    }
    
    private void clearCart(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") != null)
            session.setAttribute("cart", new ArrayList<>());
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
