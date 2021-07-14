package service;

import dao.UserDao;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void Show(){
        System.out.println("service add..........");
        userDao.update();
    }
}
