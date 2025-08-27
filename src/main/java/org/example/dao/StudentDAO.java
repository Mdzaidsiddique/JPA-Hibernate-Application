package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entiny.Student;
import org.example.util.JpaHibernateUtil;

public class StudentDAO {

    // crud methods

    // save student
    public void saveStudent(Student student){

        EntityManager em = JpaHibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            em.persist(student);

            System.out.println(student.toString()+" : inserted successfully");

            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }


    }

    // fetch student
    public Student getStudentByRoll(int roll){

        Student st = null;

        EntityManager em = JpaHibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            st = em.find(Student.class, roll);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
        }

        return st;
    }

}
