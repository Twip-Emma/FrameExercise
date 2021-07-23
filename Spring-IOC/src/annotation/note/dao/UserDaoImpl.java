package annotation.note.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("dao add..........");
    }
}
