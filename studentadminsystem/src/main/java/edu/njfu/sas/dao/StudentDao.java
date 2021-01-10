package edu.njfu.sas.dao;

import edu.njfu.sas.model.Student;

import java.sql.SQLException;
import java.util.List;


public interface StudentDao {
    List<Student> getAllStudent() throws SQLException;
    List<Student> getStudentsByName(String name);
    boolean saveStudent(Student s);
    public Student getStudentByNo(String stuno);
    List<Student> getStudentByPaging(int currentPage, int pageSize);
    long totalRecords();
    boolean updategender();
    boolean delStudent(String stuno);
}
