package org.example.dao;

import org.example.entiny.Student;

public interface StudentDAO {

    // CRUD Operations:

    public abstract void saveStudent(Student student);

    public abstract Student getStudentByRoll(int roll);

    public abstract void updateStudentName(int roll, String name);

    public abstract void removeStudentByRoll(int roll);

}
