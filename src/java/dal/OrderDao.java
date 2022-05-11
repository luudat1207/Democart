/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Order;
import models.OrderDetail;

/**
 *
 * @author lephu
 */
public class OrderDao extends DBContext{
    public int InsertOrderInfo(Order order)
    {
        try{
            String sql = "insert into Orders(OrderDate, RequiredDate, Shipvia, ShipName, ShipAddress)"
                    + "values (getdate(),?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setDate(1, Date.valueOf(order.getRequiredDate()));
            stm.setInt(2, order.getShipper().getShipId());
            stm.setString(3, order.getShipName());
            stm.setString(4, order.getShipAddress());
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next())
            {
                int orderId = Integer.parseInt(rs.getString(1));
                return orderId;
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
