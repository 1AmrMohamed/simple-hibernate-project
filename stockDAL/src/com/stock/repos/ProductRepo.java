package com.stock.repos;

import com.stock.entities.Product;
import com.stock.managers.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRepo {

    public int insert(Product product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rowCount = 0;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("INSERT INTO STOCK.PRODUCT (PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QTY) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductName());
            stmt.setInt(3, product.getProductPrice());
            stmt.setInt(4, product.getProductQty());

            rowCount = stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
        return rowCount;
    }

    public int update(Product product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rowCount = 0;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("UPDATE PRODUCT  SET PRODUCT_PRICE = ?, PRODUCT_QTY = ? WHERE PRODUCT_ID = ?");
            stmt.setInt(1, product.getProductPrice());
            stmt.setInt(2, product.getProductQty());
            stmt.setInt(3, product.getProductId());
            // stmt.setString(2, product.getProductName());

            rowCount = stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
        return rowCount;
    }

    // delete
    public Product findProductByPK(int productId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rowCount = 0;
        Product product = null;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QTY FROM PRODUCT WHERE PRODUCT_ID = ?");
            stmt.setInt(1, productId);

            rs = stmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("PRODUCT_ID"));
                product.setProductName(rs.getString("PRODUCT_NAME"));
                product.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                product.setProductQty(rs.getInt("PRODUCT_QTY"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
        return product;
    }

    public ArrayList<Product> findAllProducts() {
        ArrayList<Product> products = new ArrayList();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Product product = null;
        try {
            conn = DBManager.getConnection();

            stmt = conn.prepareStatement("SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_QTY FROM PRODUCT");

            rs = stmt.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("PRODUCT_ID"));
                product.setProductName(rs.getString("PRODUCT_NAME"));
                product.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                product.setProductQty(rs.getInt("PRODUCT_QTY"));
                products.add(product);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closeStatement(stmt);
            DBManager.closeConnection(conn);
        }
        return products;
    }
}
