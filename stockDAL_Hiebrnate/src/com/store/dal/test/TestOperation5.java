package com.store.dal.test;

import com.store.dal.entities.Product;
import com.store.dal.managers.HibernateDBManager;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class TestOperation5 {

    public static void main(String[] args) {

        try {

            HibernateDBManager.setDbConfigFileName("com\\store\\dal\\config\\hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();

            HibernateDBManager.beginTransaction();

            String querySql = "SELECT PRODUCT_ID, PRODUCT_NAME FROM PRODUCT";
            Query qOperation = session.createNativeQuery(querySql);
            List<Object[]> list = qOperation.list();
            for (Object[] p : list) {
                System.out.println(">> " + p[0] + " " + p[1]);
            }
            System.out.println("===========================================");

            String querySql2 = "SELECT * FROM PRODUCT";
            Query qOperation2 = session.createNativeQuery(querySql2)
                    .addScalar("PRODUCT_ID") // [0]
                    .addScalar("PRODUCT_NAME") // [1]
                    .addScalar("PRODUCT_PRICE");                      // [2]
            List<Object[]> list2 = qOperation2.list();
            for (Object[] p : list2) {
                System.out.println("Product id    : " + p[0]);
                System.out.println("Product Name  : " + p[1]);
                System.out.println("Product Price : " + p[2]);
                System.out.println("====");
            }
            System.out.println("===========================================");

            String querySql3 = "SELECT * FROM PRODUCT";
            Query qOperation3 = session.createNativeQuery(querySql3)
                    .addScalar("PRODUCT_ID") // [0]
                    .addScalar("PRODUCT_NAME") // [1]
                    .addScalar("PRODUCT_PRICE") // [2]
                    .addEntity(Product.class);                        // [3]
            List<Object[]> list3 = qOperation3.list();
            for (Object[] p : list3) {
                Product pr = (Product) p[3];
                System.out.println(">> " + p[0] + " " + p[1] + " " + p[2] + " " + p[3]);
                System.out.println("Product Name : " + pr.getProductName());
            }
            System.out.println("===========================================");
            
            String querySql4 = "select p.*, pc.* from PRODUCT p, PRODUCT_COUNTRY pc where p.PRODUCT_ID = pc.PRODUCT_ID_FK";
            
            HibernateDBManager.commitTransaction();

            HibernateDBManager.closeSession();

        } catch (Exception ex) {
            ex.printStackTrace();
            HibernateDBManager.rollbackTransaction();
        }

    }

}
