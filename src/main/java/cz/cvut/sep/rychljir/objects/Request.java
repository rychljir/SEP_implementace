package cz.cvut.sep.rychljir.objects;

import javax.persistence.*;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Speedy on 11. 12. 2016.
 */
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne(targetEntity = OwnCustomer.class, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    OwnCustomer customer;
    String status;
    String timeStamp;
    BigInteger user_id;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    String requestType;

    public Request(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        timeStamp = dateFormat.format(date);
    }

    public Request(OwnCustomer customer, String status, BigInteger user_id){
        this.customer = customer;
        this.status = status;
        this.user_id = user_id;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        timeStamp = dateFormat.format(date);
    }

    @OneToOne(targetEntity = OwnCustomer.class, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public OwnCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(OwnCustomer customer) {
        this.customer = customer;
    }

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, jmeno='%s', prijmeni='%s', čas='%s', akce='%s']",
                id, customer.getFirstName(), customer.getSurName(),timeStamp,status);
    }
}
