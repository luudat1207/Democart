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
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Order;
import models.OrderDetail;

/**
 *
 * @author lephu
 */
public class OrderDetailDao extends DBContext{
    public int InsertOrderDetail(OrderDetail detail)
    {
        try{
            String sql = "insert into [Order Details](OrderId, ProductId, quantity, UnitPrice)"
                    + "values (?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, detail.getOrderId());
            stm.setInt(2, detail.getProductId());
            stm.setInt(3, detail.getQuantiy());
            stm.setDouble(4, detail.getUnitPrice());
            stm.executeUpdate();
        }
        catch(Exception ex)
        {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
