package com.store.dal.test;

import com.store.dal.entities.Product;
import com.store.dal.entities.ProductCountry;
import com.store.dal.managers.HibernateDBManager;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.Session;

public class TestOperations3 {

    public static void main(String[] args) {

        try {

            HibernateDBManager.setDbConfigFileName("com\\store\\dal\\config\\hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();

            HibernateDBManager.beginTransaction();

            // Product productGet = session.get(Product.class, new BigDecimal(1));
            
            String dmlSql = "INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_NAME) VALUES (?, ?)";
            // Task : Update Pr 2 >>>  Name : Marwaha
            // Task : Deltee Pr 1 
            
            Query dmlOperation = session.createNativeQuery(dmlSql);
            dmlOperation.setParameter(1, 2);
            dmlOperation.setParameter(2, "Product 2");
            dmlOperation.executeUpdate();

            HibernateDBManager.commitTransaction();

            HibernateDBManager.closeSession();

        } catch (Exception ex) {
            ex.printStackTrace();
            HibernateDBManager.rollbackTransaction();
        }

    }

}
