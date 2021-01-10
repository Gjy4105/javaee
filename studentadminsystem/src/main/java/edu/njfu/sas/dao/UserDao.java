package edu.njfu.sas.dao;

import edu.njfu.sas.model.User;

public interface UserDao {
    public boolean checkLogin(User user);
    boolean saveUser(User user);
    boolean updateStuno(String no);
}
