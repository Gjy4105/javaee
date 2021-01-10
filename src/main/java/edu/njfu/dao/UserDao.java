package edu.njfu.dao;

import edu.njfu.model.User;
import edu.njfu.util.DBHelper;
import edu.njfu.util.Md5Util;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2020/9/28 2:43 下午
 * @Created by lqj(1724226325@qq.com)
 */
public class UserDao {
    /**
     * user对象的增删改查,都在此处进行
     */

    public boolean checkLogin(User user){
        //sql statement
        String sql="select * from tbl_user where username=? and password=?";
        //把占位符的值放到一个list中
        List<Object> params=new ArrayList<Object>();
        params.add(user.getUserName()) ;
        //把明文转换为密文
        String encryptPassword= Md5Util.stringToMD5(user.getPassword());
        params.add(encryptPassword);
        //创建DBHelper对象
        DBHelper dbHelper = new DBHelper();
        List<Object> query = dbHelper.query(sql, params);
        /**
         * Object 是一个map对象
         */
        //System.out.println(query);
        return  query.size()>0;
    }
    /**
     * saveUser(User ser);
     */
    public boolean saveUser(User u){
        String sql="insert into tbl_user (username,password) values(?,?)";
        //对占位符进行赋值,保存到List
        List<Object> params=new ArrayList<>();
        params.add(u.getUserName());
        params.add(Md5Util.stringToMD5(u.getPassword()));
        //创建DBHelper
        DBHelper db = new DBHelper();
        int result = db.update(sql, params);
        return result>0;
    }

}
