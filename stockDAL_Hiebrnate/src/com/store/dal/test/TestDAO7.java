package com.store.dal.test;

import com.store.dal.dao.ProductDAO;
import com.store.dal.entities.Product;
import com.store.dal.managers.HibernateDBManager;
import java.util.List;

public class TestDAO7 {

    public static void main(String[] args) {
        try {
            HibernateDBManager.setDbConfigFileName("com\\store\\dal\\config\\hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();
            HibernateDBManager.beginTransaction();

            // findList()
            ProductDAO productDAO = new ProductDAO();
            List<Product> productlist = productDAO.findList();
            for (Product product : productlist) {
                System.out.println("Product Id : " + product.getProductId() + " Product name : " + product.getProductName());
            }

            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
            HibernateDBManager.rollbackTransaction();
        }
    }
}
