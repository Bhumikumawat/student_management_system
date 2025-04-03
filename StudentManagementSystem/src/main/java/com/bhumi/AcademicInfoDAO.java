package com.bhumi;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AcademicInfoDAO {
    public void saveAcademicInfo(AcademicInfo academicInfo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(academicInfo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}