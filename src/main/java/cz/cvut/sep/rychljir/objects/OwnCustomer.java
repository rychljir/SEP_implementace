
package cz.cvut.sep.rychljir.objects;

import cz.cvut.sep.rychljir.customerDatabase.AddressType;
import cz.cvut.sep.rychljir.customerDatabase.CustomerDetailType;
import cz.cvut.sep.rychljir.customerDatabase.PhoneType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.List;

@Entity
public class OwnCustomer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int db_id;

    protected String firstName;
    protected String surName;
    protected String streetName;
    protected String streetNum;
    protected String postalCode;
    protected String cityPart;
    protected String city;
    protected String county;
    protected String country;
    protected BigInteger phoneNumberType;
    protected String phoneNum;
    protected String cityCode;
    protected String countryCode;
    protected String birthNum;
    protected String countryOfOrigin;
    protected BigInteger stat = new BigInteger("0");
    protected BigInteger id = new BigInteger("0");

    public OwnCustomer(){

    }

    public OwnCustomer(CustomerDetailType ct){
        if(ct!=null){
            String res = "";
            List<String> list = ct.getFirstName();
            for (int i = 0; i < list.size(); i++) {
                res += list.get(i);
            }
            setFirstName(res);

            res = "";
            list = ct.getSurname();
            for (int i = 0; i < list.size(); i++) {
                res += list.get(i);
            }
            setSurName(res);

            List<AddressType> address = ct.getAddress();
            setStreetName(address.get(0).getStreetName());
            setStreetNum(address.get(0).getStreetNum());
            setPostalCode(address.get(0).getPostalCode());
            setCityPart(address.get(0).getCityPart());
            setCity(address.get(0).getCity());
            setCounty(address.get(0).getCounty());
            setCountry(address.get(0).getCountry());

            List<PhoneType> phone = ct.getPhoneNum();
            setPhoneNumberType(phone.get(0).getPhoneNumberType());
            setPhoneNum(phone.get(0).getPhoneNum());
            setCityCode(phone.get(0).getCityCode());
            setCountryCode(phone.get(0).getCountryCode());
            setBirthNum(ct.getBirthNum());
            setCountryOfOrigin(ct.getCountryOfOrigin());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCityPart() {
        return cityPart;
    }

    public void setCityPart(String cityPart) {
        this.cityPart = cityPart;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigInteger getPhoneNumberType() {
        return phoneNumberType;
    }

    public void setPhoneNumberType(BigInteger phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityoCde) {
        this.cityCode = cityoCde;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getBirthNum() {
        return birthNum;
    }

    public void setBirthNum(String birthNum) {
        this.birthNum = birthNum;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public BigInteger getStat() {
        return stat;
    }

    public void setStat(BigInteger stat) {
        this.stat = stat;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

}
