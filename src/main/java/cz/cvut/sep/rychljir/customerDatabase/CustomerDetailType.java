
package cz.cvut.sep.rychljir.customerDatabase;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerDetailType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerDetailType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="5"/>
 *         &lt;element name="surName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="5"/>
 *         &lt;element name="address" type="{http://www.cvut.cz/FEL/}AddressType" maxOccurs="3"/>
 *         &lt;element name="phoneNum" type="{http://www.cvut.cz/FEL/}PhoneType" maxOccurs="3"/>
 *         &lt;element name="birthNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="countryOfOrigin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerDetailType", propOrder = {
    "firstName",
    "surname",
    "address",
    "phoneNum",
    "birthNum",
    "countryOfOrigin"
})
public class CustomerDetailType {

    @XmlElement(required = true)
    protected List<String> firstName;
    @XmlElement(required = true)
    protected List<String> surname;
    @XmlElement(required = true)
    protected List<AddressType> address;
    @XmlElement(required = true)
    protected List<PhoneType> phoneNum;
    @XmlElement(required = true)
    protected String birthNum;
    @XmlElement(required = true)
    protected String countryOfOrigin;

    /**
     * Gets the value of the firstName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the firstName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFirstName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFirstName() {
        if (firstName == null) {
            firstName = new ArrayList<String>();
        }
        return this.firstName;
    }

    /**
     * Gets the value of the surName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSurname() {
        if (surname == null) {
            surname = new ArrayList<String>();
        }
        return this.surname;
    }

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressType }
     * 
     * 
     */
    public List<AddressType> getAddress() {
        if (address == null) {
            address = new ArrayList<AddressType>();
        }
        return this.address;
    }

    /**
     * Gets the value of the phoneNum property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phoneNum property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhoneNum().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhoneType }
     * 
     * 
     */
    public List<PhoneType> getPhoneNum() {
        if (phoneNum == null) {
            phoneNum = new ArrayList<PhoneType>();
        }
        return this.phoneNum;
    }

    /**
     * Gets the value of the birthNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthNum() {
        return birthNum;
    }

    /**
     * Sets the value of the birthNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthNum(String value) {
        this.birthNum = value;
    }

    /**
     * Gets the value of the countryOfOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    /**
     * Sets the value of the countryOfOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryOfOrigin(String value) {
        this.countryOfOrigin = value;
    }

    public void setFirstName(List<String> firstName) {
        this.firstName = firstName;
    }

    public void setSurname(List<String> surname) {
        this.surname = surname;
    }

    public void setAddress(List<AddressType> address) {
        this.address = address;
    }

    public void setPhoneNum(List<PhoneType> phoneNum) {
        this.phoneNum = phoneNum;
    }
}
