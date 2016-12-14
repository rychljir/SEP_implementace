package cz.cvut.sep.rychljir;

import cz.cvut.sep.rychljir.objects.*;
import org.apache.commons.logging.Log;
import org.apache.cxf.aegis.type.xml.SourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigInteger;
import java.util.Timer;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private static Schelduler st;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRep, RequestRepository reqRep) {
        return (args) -> {
            //init users
            if(userRep.count()==0){
                userRep.save(new User("admin", "admin"));
            }

            // fetch all customers
            log.info("Possible login:");
            log.info("-------------------------------");
            for (User user : userRep.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            if(reqRep.count()<3){
                reqRep.deleteAll();
                OwnCustomer oc = new OwnCustomer();
                oc.setFirstName("Jenda");
                oc.setSurName("Benda");
                reqRep.save(new Request(oc, "Active", new BigInteger("1")));
                oc = new OwnCustomer();
                oc.setFirstName("Pepa");
                oc.setSurName("Zdepa");
                reqRep.save(new Request(oc, "Suspended", new BigInteger("2")));
                oc = new OwnCustomer();
                oc.setFirstName("Roman");
                oc.setSurName("Skocdopole");
                reqRep.save(new Request(oc, "Refunded", new BigInteger("3")));
            }

            // fetch all customers
            log.info("Init requests:");
            log.info("-------------------------------");
            for (Request rep : reqRep.findAll()) {
                log.info(rep.toString());
            }
            log.info("");

            if(st==null){
                Timer time = new Timer();
                st = Schelduler.getInstance(reqRep);
                if(!st.isRunning){
                    st.isRunning = true;
                    long timer = 1000*60*60*24;
                    //long timer = 1000*30;
                    time.schedule(st, 0, timer);
                }
            }
        };
    }
}
