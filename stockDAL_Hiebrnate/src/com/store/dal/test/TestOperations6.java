package com.store.dal.test;

import com.store.dal.entities.Product;
import com.store.dal.managers.HibernateDBManager;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class TestOperations6 {

    public static void main(String[] args) {

        try {

            HibernateDBManager.setDbConfigFileName("com\\store\\dal\\config\\hibernate.cfg.xml");
            HibernateDBManager.buildSessionFactory();

            Session session = HibernateDBManager.getSession();

            HibernateDBManager.beginTransaction();

            // 1- Bulider that will build the Criteria Query (build Empty Box)
            CriteriaBuilder builder = session.getCriteriaBuilder();

            // 2- create CriteriaQuery is an empty box [ .......M3ayer el query....... ]
            CriteriaQuery<Product> productCriteriaQueryAllRows = builder.createQuery(Product.class);

            // 3- Append (Add) select clauses (select - from - where - order by - group by) to Empty box
            Root<Product> from0 = productCriteriaQueryAllRows.from(Product.class); // Table
            productCriteriaQueryAllRows.select(from0); // Coulmns

            // 4- Generate final select statement by session Based on Database type 
            // select * from Product;
            Query<Product> productQuery = session.createQuery(productCriteriaQueryAllRows);

            // 5- Execute
            List<Product> productList = productQuery.getResultList();
            for (Product product : productList) {
                System.out.println("Product Id : " + product.getProductId() + " Product name : " + product.getProductName());
            }
            System.out.println("=========================================");

            CriteriaQuery<Product> productCriteriaQueryWithWhere = builder.createQuery(Product.class);

            Root<Product> from1 = productCriteriaQueryWithWhere.from(Product.class);
            productCriteriaQueryWithWhere.select(from1).where(builder.equal(from1.get("productId"), 1));

            Query<Product> productQueryWithWhere = session.createQuery(productCriteriaQueryWithWhere);

            Product productSingleResult = productQueryWithWhere.getSingleResult();
            System.out.println("Product Id : " + productSingleResult.getProductId());

            System.out.println("=========================================");

            CriteriaQuery<Product> productCriteriaQueryWithSpecificColumns = builder.createQuery(Product.class);

            Root<Product> from2 = productCriteriaQueryWithSpecificColumns.from(Product.class);
            productCriteriaQueryWithSpecificColumns.multiselect(from2.get("productId"), from2.get("productName"));

            Query<Product> productQueryWithSpecificColumns = session.createQuery(productCriteriaQueryWithSpecificColumns);

            List<Product> productListSpecificCoulmns = productQueryWithSpecificColumns.getResultList();
            for (Product product : productListSpecificCoulmns) {
                System.out.println("Product Id : " + product.getProductId() + " Product name : " + product.getProductName());
            }

            // Task With Join
            HibernateDBManager.commitTransaction();

            HibernateDBManager.closeSession();

        } catch (Exception ex) {
            ex.printStackTrace();
            HibernateDBManager.rollbackTransaction();
        }

    }

}
