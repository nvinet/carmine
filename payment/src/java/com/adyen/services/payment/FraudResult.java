
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FraudResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FraudResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountScore" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="results" type="{http://payment.services.adyen.com}ArrayOfFraudCheckResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FraudResult", propOrder = {
    "accountScore",
    "results"
})
public class FraudResult {

    protected int accountScore;
    @XmlElementRef(name = "results", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<ArrayOfFraudCheckResult> results;

    /**
     * Gets the value of the accountScore property.
     * 
     */
    public int getAccountScore() {
        return accountScore;
    }

    /**
     * Sets the value of the accountScore property.
     * 
     */
    public void setAccountScore(int value) {
        this.accountScore = value;
    }

    /**
     * Gets the value of the results property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFraudCheckResult }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFraudCheckResult> getResults() {
        return results;
    }

    /**
     * Sets the value of the results property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFraudCheckResult }{@code >}
     *     
     */
    public void setResults(JAXBElement<ArrayOfFraudCheckResult> value) {
        this.results = ((JAXBElement<ArrayOfFraudCheckResult> ) value);
    }

}
