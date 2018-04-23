package fr.epsi.dao;

import fr.epsi.model.User;

import net.moznion.random.string.RandomStringGenerator;
import org.junit.Test;

import javax.persistence.PersistenceException;
import java.sql.Date;


public class UserDaoTest {
    RandomStringGenerator generator = new RandomStringGenerator();
    @Test
    public void insertUser() {
        User user = new User();
        user.setFirstname("Benjamin");
        user.setLastname("Tourman");
        String mail = generator.generateFromPattern("cCn!");
        user.setEmail(mail + "@epsi.fr");
        user.setBirthday(new Date(1997,04,18));
        System.out.println(new UserDao().save(user));
        System.out.println(user.getAge());
    }

    @Test
    public void getUser() {
        User u = new UserDao().get(1l);
        System.out.println(u.getFirstname());
    }

    @Test(expected = PersistenceException.class)
    public void insertWithSameEmail(){
        User user = new User();
        user.setFirstname("Benjamin");
        user.setLastname("Tourman");
        user.setEmail("Benjamin.Tourman@epsi.fr");
        new UserDao().save(user);


    }
}
