package cz.cvut.sep.rychljir.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Speedy on 8. 12. 2016.
 */
@Entity
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;
    private String password;

    protected User() {};

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, nick='%s', psw='%s']",
                id, name, password);
    }
}
