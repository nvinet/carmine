
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BalanceCheckResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalanceCheckResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currentBalance" type="{http://common.services.adyen.com}Amount" minOccurs="0"/>
 *         &lt;element name="pspReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://payment.services.adyen.com}BalanceCheckResponseCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceCheckResult", propOrder = {
    "currentBalance",
    "pspReference",
    "responseCode"
})
public class BalanceCheckResult {

    @XmlElementRef(name = "currentBalance", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Amount> currentBalance;
    @XmlElementRef(name = "pspReference", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> pspReference;
    @XmlElementRef(name = "responseCode", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<BalanceCheckResponseCode> responseCode;

    /**
     * Gets the value of the currentBalance property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public JAXBElement<Amount> getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Sets the value of the currentBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public void setCurrentBalance(JAXBElement<Amount> value) {
        this.currentBalance = ((JAXBElement<Amount> ) value);
    }

    /**
     * Gets the value of the pspReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPspReference() {
        return pspReference;
    }

    /**
     * Sets the value of the pspReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPspReference(JAXBElement<String> value) {
        this.pspReference = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BalanceCheckResponseCode }{@code >}
     *     
     */
    public JAXBElement<BalanceCheckResponseCode> getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BalanceCheckResponseCode }{@code >}
     *     
     */
    public void setResponseCode(JAXBElement<BalanceCheckResponseCode> value) {
        this.responseCode = ((JAXBElement<BalanceCheckResponseCode> ) value);
    }

}
