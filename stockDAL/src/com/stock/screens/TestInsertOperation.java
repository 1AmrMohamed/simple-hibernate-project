package com.stock.screens;

import com.stock.entities.Product;
import com.stock.managers.DBManager;
import com.stock.repos.ProductRepo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TestInsertOperation {

    public static void main(String[] args) {
       

        String productId = JOptionPane.showInputDialog("Product Id");
        String productName = JOptionPane.showInputDialog("Product Name");
        String productPrice = JOptionPane.showInputDialog("Product Price");
        String productQty = JOptionPane.showInputDialog("Product QTY");
        
        Product product = new Product();
        product.setProductId(Integer.parseInt(productId));
        product.setProductName(productName);
        product.setProductPrice(Integer.parseInt(productPrice));
        product.setProductQty(Integer.parseInt(productQty));
        
        ProductRepo productRepo = new ProductRepo();
        int rows = productRepo.insert(product);
        System.out.println(rows);
                
    }

}
