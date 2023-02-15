package com.stock.screens;

import com.stock.managers.DBManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TestUpdateOperation {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String productId = JOptionPane.showInputDialog("Product Id");
        // String productName = JOptionPane.showInputDialog("Product Name");
        String productPrice = JOptionPane.showInputDialog("Product Price");
        // String productQty = JOptionPane.showInputDialog("Product QTY");

        try {
            conn = DBManager.getConnection();

            // stmt
            stmt = conn.prepareStatement("UPDATE PRODUCT  SET PRODUCT_PRICE = ? WHERE PRODUCT_ID = ?");
            stmt.setInt(1, Integer.parseInt(productPrice));
            stmt.setInt(2, Integer.parseInt(productId));

            // execute
            int rowCount = stmt.executeUpdate();
            System.out.println("Row Count : " + rowCount);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }

    }

}
