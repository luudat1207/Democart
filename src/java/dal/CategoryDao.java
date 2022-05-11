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
import models.Shipper;

/**
 *
 * @author lephu
 */
public class CategoryDao extends DBContext{
    public ArrayList<Category> getAllCategories()
    {
        ArrayList<Category> list = new ArrayList<>();
        try{
            String sql = "Select * from Categories";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                Category d = new Category(
                        rs.getInt("CategoryId"), 
                        rs.getString("CategoryName"), 
                        rs.getString("Description"));
                list.add(d);
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
