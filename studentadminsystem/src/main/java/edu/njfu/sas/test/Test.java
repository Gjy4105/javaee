package edu.njfu.sas.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.njfu.sas.dao.StudentDao;
import edu.njfu.sas.dao.UserDao;
import edu.njfu.sas.dao.impl.StudentDaoImpl;
import edu.njfu.sas.dao.impl.StudentDaoImpl2;
import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.Student;
import edu.njfu.sas.model.User;
import edu.njfu.sas.util.C3p0Util;
import edu.njfu.sas.util.DbcpUtil;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/10/12 3:16 下午
 * @Created by lqj(1724226325@qq.com)
 */
public class Test {

    public static void main(String[] args) throws IOException, SQLException {
        //Student ssdf = new Student("1101", "ssdf");
//       System.out.println(new StudentDaoImpl().getAllStudent());
//        Gson gson = new Gson();
//        String jsonStr = gson.toJson(new StudentDaoImpl().getStudentByPaging(2,4));
//        System.out.println(jsonStr);
//        System.out.println(new StudentDaoImpl().totalRecords());
//        Properties properties = new Properties();
//        InputStream in = new Test().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
//        properties.load(in);
//        System.out.println(properties.getProperty("password"));
//        System.out.println(properties.getProperty("url"));
//        System.out.println(DbcpUtil.getDataSource()==null);
////        /**
////         * getConnection(),会抛出异常
////         * 由调用者来处理:
////         * (1)可以处理 捕获, try .. catch
////         * (2)处理不了, 继续抛
////         */
////        try {
////            System.out.println(C3p0Util.getConnection().getConnection() == null);
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
//        System.out.println(new StudentDaoImpl2().getStudentByPaging(1,2));
//
           UserDao dao=new UserDaoImpl();
           User u=new User("lisi","123456");
            System.out.println(dao.checkLogin(u));
            List list=new ArrayList();
            list.add(1);
            list.add("hello");
            list.add(true);
            list.add('A');
            for(Object o: list){
                System.out.println(o);
            }
        /**
         * 泛型,
         */
        List<String> list1=new ArrayList<String>();
        List<Student> list2 =new ArrayList<>();
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
        System.out.println();

        /**
         * json字符串数组的,如何指定转换后的类型?
         * List<Student>
         */
        /**
         * Gson提供了一个抽象类TypeToken
         * 什么叫抽象类?
         * 在类的定义上有关键字abstract, 就是抽象类
         * 一般情况下,一个抽象类都会有一个或者多个抽象方法,特殊情况,有的抽象类就没有抽象方法,HttpServlet
         *  Wrapper, java io ,装饰者类,
         *  目的是为了继承者重写父类的方法,实现特定的功能
         *
         *  抽象类的特点:
         *  (1)不能直接使用构造函数创建新的对象
         *  (2)必须被继承
         */
        StudentDaoImpl2 sdao = new StudentDaoImpl2();
        List<Student> students = sdao.getAllStudent();
        String json = new Gson().toJson(students);
        //System.out.println(json);
        //把json数组转为List<Student>对象
        Gson gson = new Gson();
        //{}代表什么?代表抽象类的实现,大括号中代表需要实现的抽象方法,TypeToken类没有抽象方法,为空
        //创建一个匿名的类(继承TypeToken<List<Student>>抽象类)的对象,获取该对象的类型
        Type type = new TypeToken<List<Student>>(){}.getType();
        List<Student> stus =  gson.fromJson(json,type);
        for(Student s:stus){
            System.out.println(s);
        }

    }

}
