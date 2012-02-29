
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Recurring complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Recurring">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contract" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recurringDetailName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Recurring", propOrder = {
    "contract",
    "recurringDetailName"
})
public class Recurring {

    @XmlElementRef(name = "contract", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> contract;
    @XmlElementRef(name = "recurringDetailName", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> recurringDetailName;

    /**
     * Gets the value of the contract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContract() {
        return contract;
    }

    /**
     * Sets the value of the contract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContract(JAXBElement<String> value) {
        this.contract = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the recurringDetailName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecurringDetailName() {
        return recurringDetailName;
    }

    /**
     * Sets the value of the recurringDetailName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecurringDetailName(JAXBElement<String> value) {
        this.recurringDetailName = ((JAXBElement<String> ) value);
    }

}
