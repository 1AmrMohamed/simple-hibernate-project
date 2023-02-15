package com.stock.screens;

import com.stock.entities.Product;
import com.stock.managers.DBManager;
import com.stock.repos.ProductRepo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TestSelectOperation {

    public static void main(String[] args) {
        
        ProductRepo productRepo = new ProductRepo();
        Product p = productRepo.findProductByPK(2);
        if(p != null){
            System.out.println(p.getProductName());
        }
        
        

    }

}
