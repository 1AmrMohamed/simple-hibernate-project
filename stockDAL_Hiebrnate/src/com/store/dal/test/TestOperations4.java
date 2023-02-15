package com.store.dal.test;

import com.store.dal.entities.Product;
import com.store.dal.entities.ProductCountry;
import com.store.dal.managers.HibernateDBManager;
import java.math.BigDecimal;
import java.util.Set;
import org.hibernate.Session;

public class TestOperations4 {

    public static void main(String[] args) {

        // JOP / WEB App / WEB SERVICE
        Product p = new Product(); // trainsient State [PK Not In table]
        p.setProductId(new BigDecimal(5));
        p.setProductName("Product 4");
        p.setProductPrice(new BigDecimal(44));
        p.setProductQty(new BigDecimal(444));

        try {

            HibernateDBManager.setDbConfigFileName("com\\store\\dal\\config\\hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();

            HibernateDBManager.beginTransaction();

            Product productGet = session.get(Product.class, new BigDecimal(1)); // persistance State [PK In DB]
            productGet.setProductName("Product Update 1"); // deattaced [pk in db - data diff ]
            
            //session.save(p); // Tratnc Insert Product To table
            // session.save(productGet); // Update Product To table
            // Per
            
            //p.setProductName("ppppp");
            
            // session.save(p); // Update 
            
            // session.remove(productGet); // Delete
            // session.remove(p); // Delete Removed 
            // session.persist(productGet);
            // session.persist(p);
            
            // session.update(productGet);
            // session.update(p);
            
            session.saveOrUpdate(p);
            
            HibernateDBManager.commitTransaction();

            HibernateDBManager.closeSession();

        } catch (Exception ex) {
            ex.printStackTrace();
            HibernateDBManager.rollbackTransaction();
        }

    }

}
