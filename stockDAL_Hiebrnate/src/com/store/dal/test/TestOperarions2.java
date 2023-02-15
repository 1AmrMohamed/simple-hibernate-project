package com.store.dal.test;

import com.store.dal.entities.Product;
import com.store.dal.entities.ProductCountry;
import com.store.dal.managers.HibernateDBManager;
import java.math.BigDecimal;
import java.util.Set;
import org.hibernate.Session;

public class TestOperarions2 {

    public static void main(String[] args) {

        try {

            HibernateDBManager.setDbConfigFileName("com\\store\\dal\\config\\hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();

            HibernateDBManager.beginTransaction();

            
            Product productGet = session.get(Product.class, new BigDecimal(1));
            System.out.println("productGet : " + productGet);
            System.out.println("productGet : " + productGet.getProductName());
            Set<ProductCountry> productCountries = productGet.getProductCountries();
            for (ProductCountry productCountry : productCountries) {
                System.out.println("productCountry Name " + productCountry.getCountryName());
            }
            // Product productLoad = session.load(Product.class, new BigDecimal(12));
            // System.out.println("productLoad : " + productLoad);
            // System.out.println("productLoad : " + productLoad.getProductName());
            
            

            HibernateDBManager.commitTransaction();

            HibernateDBManager.closeSession();

        } catch (Exception ex) {
            ex.printStackTrace();
            HibernateDBManager.rollbackTransaction();
        }

    }

}
