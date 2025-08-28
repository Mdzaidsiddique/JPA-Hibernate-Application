package org.example;

import org.example.dao.StudentDAO;
import org.example.dao.StudentDaoImpl;
import org.example.entiny.Student;

public class JpaHibernateAppMain {

    public static void main(String[] args) {

        Student st = new Student();
        st.setRoll(401);
        st.setName("cool boy");
        st.setAddress("north");
        st.setMobile("1237543565");

        StudentDAO studentDAO = new StudentDaoImpl();

        // CREATE
//        studentDAO.saveStudent(st);

//        // READ
//        Student returnedStudent = studentDAO.getStudentByRoll(st.getRoll());
//        System.out.println(returnedStudent.toString());
//
//        // UPDATE
//        studentDAO.updateStudentName(401, "munna");
//
//        // DELETE
        studentDAO.removeStudentByRoll(401);

    }
}