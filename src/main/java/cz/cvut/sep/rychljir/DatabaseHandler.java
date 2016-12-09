package cz.cvut.sep.rychljir;

import cz.cvut.sep.rychljir.objects.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Properties;

/**
 * Created by Josef Vesely on 10. 11. 2016.
 */
public class DatabaseHandler {
    static SessionFactory sessionFactory;

    private DatabaseHandler() {}

    /* ------------------------------- INSERT --------------------------------------- */

    public static final <T> void insert(T object) {
        configureHibernate();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.save(object);
            session.getTransaction().commit();
            session.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        session.close();
    }

    /* ------------------------------- GET --------------------------------------- */

    public static final List getQuery(String stringQuery, String[] params, int base, int offset) {
        configureHibernate();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List result = null;

        try{
            Query query = session.createQuery(stringQuery);
            if(offset!=0){
                query.setFirstResult(offset);
            }
            if(base!=0){
                query.setMaxResults(base);
            }

            if(params != null && params.length>0) {
                for(int i=0; i<params.length-1; i+=2) {
                    query.setParameter(params[i], params[i+1]);
                }
            }
            result = query.list();

            session.getTransaction().commit();
            session.flush();
        } catch(Exception ex){
            ex.printStackTrace();
        } finally{
            session.close();
        }

        return result;
    }

    public static final List getQuery(String stringQuery) {
        return getQuery(stringQuery, null, 0, 0);
    }

    public static final List getQuery(String stringQuery, int base, int offset){
        return getQuery(stringQuery,null,base,offset);
    }

    /* ------------------------------- DELETE --------------------------------------- */

    public static final <T> void delete(T object) {
        configureHibernate();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    /* ------------------------------- UPDATE --------------------------------------- */

    public static final <T> void update(T object) {
        configureHibernate();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.flush();
        session.close();
    }

    /* ------------------------------- CONF -------------------------------  */

    public static final void configureHibernate() {
        if (sessionFactory != null) {
            return;
        }
//
//        Configuration conf = new Configuration();
//        conf.addAnnotatedClass(CreateCustomerChangeOrderBean.class);
//
//        conf.configure();
//
//        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
//        sessionFactory = conf.buildSessionFactory(sr);

        Configuration conf = new Configuration();
        conf.addAnnotatedClass(User.class);
       /* conf.addAnnotatedClass(PhoneType.class);
        conf.addAnnotatedClass(CustomerDetailType.class);
        conf.addAnnotatedClass(CreateCustomerChangeOrder.class);*/
        conf.configure();

        Properties properties = conf.getProperties();
        ServiceRegistry serviceRegistry = (new StandardServiceRegistryBuilder()).applySettings(properties).build();

        sessionFactory = conf.buildSessionFactory(serviceRegistry);
    }
}
