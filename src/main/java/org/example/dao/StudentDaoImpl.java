package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entiny.Student;
import org.example.util.JpaHibernateUtil;

public class StudentDaoImpl implements StudentDAO {

    // CREATE: save student
    @Override
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

    // READ: fetch student
    @Override
    public Student getStudentByRoll(int roll){

        EntityManager em = JpaHibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Student st = null;

        try{
            tx.begin();
            st = em.find(Student.class, roll);
            System.out.println("student information fetched successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
        }

        return st;
    }

    // UPDATE:
    @Override
    public void updateStudentName(int roll, String name){
        EntityManager em = JpaHibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            Student st = em.find(Student.class, roll);
            st.setName(name);

            tx.commit();

            System.out.println(st.toString()+", name updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // DELETE: remove student by roll
    @Override
    public void removeStudentByRoll(int roll){
        EntityManager em = JpaHibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            Student st = em.find(Student.class, roll);
            em.remove(st);

            tx.commit();
            System.out.println(st.toString()+": deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

}
