package fr.epsi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "user",indexes = {@Index(name = "emailIndex",columnList = "email")})
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column
    private Date birthday;
    //@Formula("SELECT DATEDIFF(CURRENT_DATE() birthday)")
    //private int age;



    @OneToMany(mappedBy = "user")
    private Set<Tweet> tweets;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

   /* public int getAge() {
        return age;
    }*/
   public Set<Tweet> getTweets() {
       return tweets;
   }

    public void setTweets(Set<Tweet> tweets) {
        this.tweets = tweets;
    }

}
