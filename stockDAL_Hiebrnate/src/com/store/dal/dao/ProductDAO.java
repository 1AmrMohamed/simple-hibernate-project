package com.store.dal.dao;

import com.store.dal.entities.Product;
import com.store.dal.managers.HibernateDBManager;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ProductDAO {

    public Product add(Product product) {
        HibernateDBManager.getSession().persist(product);
        return product;
    }

    public Product update(Product product) {
        HibernateDBManager.getSession().update(product);
        return product;
    }

    public void remove(BigDecimal productID) {
        HibernateDBManager.getSession().delete(productID);
    }

    public Product findByID(BigDecimal productID) {
        return HibernateDBManager.getSession().get(Product.class, productID);
    }

    public List<Product> findList() {

        Session session = HibernateDBManager.getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Product> productCriteriaQuery = builder.createQuery(Product.class);

        Root<Product> from0 = productCriteriaQuery.from(Product.class); // Table
        productCriteriaQuery.select(from0); // Coulmns

        Query<Product> productQuery = session.createQuery(productCriteriaQuery);

        return productQuery.getResultList();
    }
    
    public void patchRemove(List<Product> products) {
        if (products == null) {
            return;
        }
        
        for (Product product : products) {
            remove(product.getProductId());
        }
    }
    
    // Task : patchUpdate
    

}
