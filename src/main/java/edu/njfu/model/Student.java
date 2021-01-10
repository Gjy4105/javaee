package edu.njfu.model;

import java.util.Objects;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2020/10/20 1:02 下午
 * @Created by lqj(1724226325@qq.com)
 */
public class Student {
    private String stuNo;
    private String stuName;
    private String department;

    public Student(String stuNo, String stuName, String department) {

        this.stuNo = stuNo;
        this.stuName = stuName;
        this.department = department;
    }

    public Student(String stuNo, String stuName) {
        this.stuNo = stuNo;
        this.stuName = stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Student)) return false;
//        Student student = (Student) o;
//        return Objects.equals(stuNo, student.stuNo) &&
//                Objects.equals(stuName, student.stuName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(stuNo, stuName);
//    }
}
