
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Card complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Card">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="billingAddress" type="{http://common.services.adyen.com}Address" minOccurs="0"/>
 *         &lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cvc" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="expiryMonth">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="2"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="expiryYear">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="4"/>
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="holderName">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="issueNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="number">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="4"/>
 *               &lt;maxLength value="19"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="startMonth" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="2"/>
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="startYear" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="4"/>
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Card", propOrder = {
    "billingAddress",
    "brand",
    "cvc",
    "expiryMonth",
    "expiryYear",
    "holderName",
    "issueNumber",
    "number",
    "startMonth",
    "startYear"
})
public class Card {

    @XmlElementRef(name = "billingAddress", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Address> billingAddress;
    @XmlElementRef(name = "brand", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> brand;
    @XmlElementRef(name = "cvc", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> cvc;
    @XmlElement(required = true)
    protected String expiryMonth;
    @XmlElement(required = true)
    protected String expiryYear;
    @XmlElement(required = true)
    protected String holderName;
    @XmlElementRef(name = "issueNumber", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> issueNumber;
    @XmlElement(required = true)
    protected String number;
    @XmlElementRef(name = "startMonth", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> startMonth;
    @XmlElementRef(name = "startYear", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> startYear;

    /**
     * Gets the value of the billingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Address }{@code >}
     *     
     */
    public JAXBElement<Address> getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets the value of the billingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Address }{@code >}
     *     
     */
    public void setBillingAddress(JAXBElement<Address> value) {
        this.billingAddress = ((JAXBElement<Address> ) value);
    }

    /**
     * Gets the value of the brand property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBrand(JAXBElement<String> value) {
        this.brand = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the cvc property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCvc() {
        return cvc;
    }

    /**
     * Sets the value of the cvc property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCvc(JAXBElement<String> value) {
        this.cvc = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the expiryMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryMonth() {
        return expiryMonth;
    }

    /**
     * Sets the value of the expiryMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryMonth(String value) {
        this.expiryMonth = value;
    }

    /**
     * Gets the value of the expiryYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryYear() {
        return expiryYear;
    }

    /**
     * Sets the value of the expiryYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryYear(String value) {
        this.expiryYear = value;
    }

    /**
     * Gets the value of the holderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHolderName() {
        return holderName;
    }

    /**
     * Sets the value of the holderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHolderName(String value) {
        this.holderName = value;
    }

    /**
     * Gets the value of the issueNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIssueNumber() {
        return issueNumber;
    }

    /**
     * Sets the value of the issueNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIssueNumber(JAXBElement<String> value) {
        this.issueNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the startMonth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStartMonth() {
        return startMonth;
    }

    /**
     * Sets the value of the startMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStartMonth(JAXBElement<String> value) {
        this.startMonth = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the startYear property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStartYear() {
        return startYear;
    }

    /**
     * Sets the value of the startYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStartYear(JAXBElement<String> value) {
        this.startYear = ((JAXBElement<String> ) value);
    }

}
