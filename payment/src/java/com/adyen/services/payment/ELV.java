
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ELV complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ELV">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountHolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankLocationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ELV", propOrder = {
    "accountHolderName",
    "bankAccountNumber",
    "bankLocation",
    "bankLocationId",
    "bankName"
})
public class ELV {

    @XmlElementRef(name = "accountHolderName", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> accountHolderName;
    @XmlElementRef(name = "bankAccountNumber", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> bankAccountNumber;
    @XmlElementRef(name = "bankLocation", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> bankLocation;
    @XmlElementRef(name = "bankLocationId", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> bankLocationId;
    @XmlElementRef(name = "bankName", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> bankName;

    /**
     * Gets the value of the accountHolderName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * Sets the value of the accountHolderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountHolderName(JAXBElement<String> value) {
        this.accountHolderName = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * Sets the value of the bankAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankAccountNumber(JAXBElement<String> value) {
        this.bankAccountNumber = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankLocation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankLocation() {
        return bankLocation;
    }

    /**
     * Sets the value of the bankLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankLocation(JAXBElement<String> value) {
        this.bankLocation = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankLocationId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankLocationId() {
        return bankLocationId;
    }

    /**
     * Sets the value of the bankLocationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankLocationId(JAXBElement<String> value) {
        this.bankLocationId = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBankName(JAXBElement<String> value) {
        this.bankName = ((JAXBElement<String> ) value);
    }

}
