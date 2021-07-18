package annotation.note.service;

import annotation.note.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "noteUser")
public class NoteUser {
    @Autowired
    private UserDao userDao;
    public void add(){
        System.out.println("note add.......");
        userDao.add();
    }
}
