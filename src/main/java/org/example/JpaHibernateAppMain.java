package org.example;

import org.example.dao.StudentDAO;
import org.example.entiny.Student;

public class JpaHibernateAppMain {

    public static void main(String[] args) {

        Student st = new Student();
        st.setRoll(40);
        st.setName("cool bro");
        st.setAddress("mmm");
        st.setMobile("1237543565");

        StudentDAO studentDAO = new StudentDAO();

        studentDAO.saveStudent(st);

        studentDAO.getStudentByRoll(st.getRoll());

    }
}