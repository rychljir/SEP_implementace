package cz.cvut.sep.rychljir.objects;

import cz.cvut.sep.rychljir.DatabaseHandler;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class InsertTest {
    public static void insertUser() {
        User e=new User();
        e.setId(1);
        e.setName("admin");
        e.setPassword("admin");

        DatabaseHandler.insert(e);

    }
}