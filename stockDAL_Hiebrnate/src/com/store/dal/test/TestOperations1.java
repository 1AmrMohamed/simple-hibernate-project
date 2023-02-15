package com.store.dal.test;

import com.store.dal.entities.Product;
import com.store.dal.managers.HibernateDBManager;
import java.math.BigDecimal;
import org.hibernate.Session;

public class TestOperations1 {

    public static void main(String[] args) {

        Product p = new Product();
        p.setProductId(new BigDecimal(1));
        p.setProductName("Product 1");
        p.setProductPrice(new BigDecimal(11));
        p.setProductQty(new BigDecimal(111));

        try {

            HibernateDBManager.setDbConfigFileName("com\\store\\dal\\config\\hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();

            HibernateDBManager.beginTransaction();

            session.save(p); // Insert Product To table

            HibernateDBManager.commitTransaction();

            HibernateDBManager.closeSession();

        } catch (Exception ex) {
            ex.printStackTrace();
            HibernateDBManager.rollbackTransaction();
        }

    }
}
