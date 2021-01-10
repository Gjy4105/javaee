package edu.njfu.test;

import edu.njfu.dao.UserDao;
import edu.njfu.model.User;
import edu.njfu.model.Student;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/9/28 3:09 下午
 * @Created by lqj(1724226325@qq.com)
 */
public class Test {
    public static void main(String[] args) {
       // new UserDao().saveUser(new User("万古","123456"));
        Student student = new Student("101", "zhangsan","计算机应用");
        Student student1 = new Student("101", "zhangsan", "软件工程");
        if(student.equals(student1)){
            System.out.println("equal");
        }else {
            System.out.println("no equals");
        }
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
    }
}
