package edu.njfu.sas.dao.impl;

import edu.njfu.sas.dao.StudentDao;
import edu.njfu.sas.model.Student;
import edu.njfu.sas.util.DBHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> getAllStudent() {
        String sql="select * from tbl_student";
        DBHelper db = new DBHelper();
        List<Object> result = db.query(sql, null);
        List<Student> students=new ArrayList<>();
        for(Object o:result){
            Map map=(Map)o;
            students.add(
                    new Student(
                            (String)map.get("stuno"),
                            (String)map.get("stuname"),
                            (String)map.get("classes"),
                            (String)map.get("gender"),
                            (String)map.get("department"),
                            (String)map.get("tel"),
                            (String)map.get("dormno"),
                            (String)map.get("photopath")
                    )
            );
        }
        return students;
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        String sql="select * from tbl_student where stuname like ?";
        DBHelper db = new DBHelper();
        List<Object> params=new ArrayList<>();
        params.add('%'+name+'%');
        List<Object> result = db.query(sql,params );
        List<Student> students=new ArrayList<>();
        for(Object o:result){
            Map map=(Map)o;
            students.add(
                    new Student(
                            (String)map.get("stuno"),
                            (String)map.get("stuname"),
                            (String)map.get("classes"),
                            (String)map.get("gender"),
                            (String)map.get("department"),
                            (String)map.get("tel"),
                            (String)map.get("dormno"),
                            (String)map.get("photopath")
                    )
            );
        }
        return students;
    }

    @Override
    public boolean saveStudent(Student s) {
        String sql = "insert into tbl_student value(?,?,?,?,?,?,?,'')";
        DBHelper dbHelper = new DBHelper();
        List<String> params = new ArrayList<String>();
        params.add(s.getStuNo());
        params.add(s.getStuName());
        params.add(s.getClasses());
        params.add(s.getGender());
        params.add(s.getDepartment());
        params.add(s.getTel());
        params.add(s.getDormNo());

        int result = dbHelper.update(sql, params);
//        dbHelper.query(sql,params);
        return result > 0;
    }

    public Student getStudentByNo(String stuno) {
        String sql="select * from tbl_student where stuno='"+stuno+"'";
        List<Object> query = new DBHelper().query(sql, null);
        Map map=(Map)query.get(0);
        return new Student(
                (String)map.get("stuno"),
                (String)map.get("stuname"),
                (String)map.get("classes"),
                (String)map.get("gender"),
                (String)map.get("department"),
                (String)map.get("tel"),
                (String)map.get("dormno"),
                (String)map.get("photopath")
        );
    }

    @Override
    public List<Student> getStudentByPaging(int currentPage, int pageSize) {
        String sql="select * from tbl_student where stuno limit ?,?";
        int start=(currentPage-1)*pageSize;
        DBHelper dbHelper=new DBHelper();
        List<Object> params=new ArrayList<>();
        params.add(start);
        params.add(pageSize);
        List<Object> result = dbHelper.query(sql, params);
        List<Student> students=new ArrayList<>();
        for(Object o:result){
            Map map=(Map)o;
            students.add(
                    new Student(
                            (String)map.get("stuno"),
                            (String)map.get("stuname"),
                            (String)map.get("classes"),
                            (String)map.get("gender"),
                            (String)map.get("department"),
                            (String)map.get("tel"),
                            (String)map.get("dormno"),
                            (String)map.get("photopath")
                    )
            );
        }
        return students;
    }
    

    @Override
    public long totalRecords() {
        String sql="select count(*) as nums from tbl_student";
        DBHelper dbHelper=new DBHelper();
        List<Object> query = dbHelper.query(sql, null);
        return (Long)((Map)query.get(0)).get("nums");

    }

    @Override
    public boolean updategender() {
        String sql1 = "update tbl_student set photopath='./images/boy.jpg' where gender='男'";
        String sql2 = "update tbl_student set photopath='./images/gril.jpg' where gender='女'";
        DBHelper dbHelper = new DBHelper();
        List<String> params = new ArrayList<String>();
        dbHelper.update(sql1, params);
        int result = dbHelper.update(sql2, params);
        return result > 0;
    }

    @Override
    public boolean delStudent(String stuno) {
        String sql = "delete from tbl_student where stuno='" + stuno + "'";
        DBHelper dbHelper = new DBHelper();
        List<String> params = new ArrayList<String>();
        int result = dbHelper.update(sql, params);
        return result > 0;
    }
}
