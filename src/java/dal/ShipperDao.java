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
import models.Shipper;

/**
 *
 * @author lephu
 */
public class ShipperDao extends DBContext{
    public ArrayList<Shipper> getAllShippers()
    {
        ArrayList<Shipper> list = new ArrayList<>();
        try{
            String sql = "Select ShipperId, CompanyName from Shippers";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
            {
                Shipper d = new Shipper(
                        rs.getInt("ShipperId"), 
                        rs.getString("CompanyName"));
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
