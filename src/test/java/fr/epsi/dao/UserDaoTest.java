package fr.epsi.dao;

import fr.epsi.model.User;

import net.moznion.random.string.RandomStringGenerator;
import org.junit.Test;

import javax.persistence.PersistenceException;


public class UserDaoTest {
    RandomStringGenerator generator = new RandomStringGenerator();
    @Test
    public void insertUser() {
        User user = new User();
        user.setFirstname("Benjamin");
        user.setLastname("Tourman");
        String mail = generator.generateFromPattern("cCn!");
        user.setEmail(mail + "@epsi.fr");
        System.out.println(new UserDao().save(user));
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
