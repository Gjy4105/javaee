package edu.njfu.sas.dao.impl;

import edu.njfu.sas.dao.UserDao;
import edu.njfu.sas.model.Student;
import edu.njfu.sas.model.User;
import edu.njfu.sas.util.C3p0Util;
import edu.njfu.sas.util.Md5Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
//import edu.njfu.util.DBHelper;
//import edu.njfu.util.Md5Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {
    /**
     * user对象的增删改查,都在此处进行
     */
    @Override
    public boolean checkLogin(edu.njfu.sas.model.User user) {
        //sql statement
        String sql="select count(*) as count from tbl_user where username=? and password=?";
        long count=0;
        QueryRunner query = new QueryRunner(C3p0Util.getConnection());
        try {
            Map<String, Object> map = query.query(sql, new MapHandler(), new Object[]{user.getUserName(), Md5Util.stringToMD5(user.getPassword())});
            count=(Long)map.get("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  count>0;
    }

    @Override
    public boolean saveUser(User user) {
        String sql="insert into tbl_user(username,password) values(?,?)";
        int result=0;
        QueryRunner query = new QueryRunner(C3p0Util.getConnection());
        try {
            result = query.execute(sql, new Object[]{user.getUserName(), user.getPassword()});
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result>0;
    }

    @Override
    public boolean updateStuno(String no) {
        return false;
    }
}
