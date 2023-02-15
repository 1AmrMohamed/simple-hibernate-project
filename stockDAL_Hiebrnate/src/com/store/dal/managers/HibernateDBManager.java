package com.store.dal.managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateDBManager {

    private static SessionFactory dbSessionFactory = null;
    private static String dbConfigFileName = null;

    public static void buildSessionFactory() throws Exception {

        try {

            if (dbSessionFactory != null) {
                return;
            }

            if (dbConfigFileName == null) {
                throw new Exception("you must call set name first");
            }

            // hayet estekhrag tasareh --> هيئة إستخراج التصاريح 
            // ممكن تعكي له ملف أخر ببيانات أتصال أخرى على داتا بيز أخرى
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(dbConfigFileName).build();

            // El tasreeh 
            MetadataSources sources = new MetadataSources(registry);
            Metadata metadata = sources.getMetadataBuilder().build();

            // Build dbSessionFactory with tasreeeh
            dbSessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            dbConfigFileName = null;
            dbSessionFactory = null;
            throw e;
        }
    }

    public static void setDbConfigFileName(String dbConfigFileName) {
        HibernateDBManager.dbConfigFileName = dbConfigFileName;
    }

    public static SessionFactory getDbSessionFactory() {
        return dbSessionFactory;
    }

    public static Session getSession() {
        // Create nes session if note exists or use same session 
        return dbSessionFactory.getCurrentSession();
    }

    public static void beginTransaction() {
        getSession().beginTransaction();
    }

    public static void commitTransaction() {
        getSession().getTransaction().commit();
    }

    public static void rollbackTransaction() {
        if (getSession().getTransaction().isActive()) {
            getSession().getTransaction().rollback();
        }
    }

    public static void closeSession() {
        getSession().close();
    }
}
