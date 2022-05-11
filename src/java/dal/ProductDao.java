/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Category;
import models.Product;
import servlets.products;

/**
 *
 * @author lephu
 */
public class ProductDao extends DBContext{
    public ArrayList<Product> getAllProducts()
    {
        ArrayList<Product> list = new ArrayList<>();
        try{
            String sql = "Select P.*, C.CategoryName, C.Description from Products P, Categories C where "
                    + "P.CategoryId = C.CategoryId";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                Category cat = new Category(
                        rs.getInt("CategoryId"), 
                        rs.getString("CategoryName"), 
                        rs.getString("Description"));
                Product p = new Product(
                        rs.getInt("ProductId"), 
                        rs.getString("ProductName"), 
                        cat, 
                        rs.getDouble("UnitPrice"), 
                        rs.getInt("UnitsInStock"));
                list.add(p);
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Product> getAllProducts(int catId)
    {
        ArrayList<Product> list = new ArrayList<>();
        try{
            String sql = "Select P.*, C.CategoryName, C.Description from Products P, Categories C where "
                    + "P.CategoryId = C.CategoryId and C.CategoryId = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, catId);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                Category cat = new Category(
                        rs.getInt("CategoryId"), 
                        rs.getString("CategoryName"), 
                        rs.getString("Description"));
                Product p = new Product(
                        rs.getInt("ProductId"), 
                        rs.getString("ProductName"), 
                        cat, 
                        rs.getDouble("UnitPrice"), 
                        rs.getInt("UnitsInStock"));
                list.add(p);
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<Product> getProducts(ArrayList<Integer> productIds)
    {
        String productsStr = productIds.toString();//[1,2,3]
        productsStr = '(' + productsStr.substring(1);
        productsStr = productsStr.substring(0, productsStr.length()-1) + ')';
        
        ArrayList<Product> list = new ArrayList<>();
        try{
            String sql = "Select P.*, C.CategoryName, C.Description from Products P, "
                    + "Categories C where "
                    + "P.CategoryId = C.CategoryId and P.ProductId in " +productsStr;
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                Category cat = new Category(
                        rs.getInt("CategoryId"), 
                        rs.getString("CategoryName"), 
                        rs.getString("Description"));
                Product p = new Product(
                        rs.getInt("ProductId"), 
                        rs.getString("ProductName"), 
                        cat, 
                        rs.getDouble("UnitPrice"), 
                        rs.getInt("UnitsInStock"));
                list.add(p);
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
}
