
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ModificationResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModificationResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalData" type="{http://payment.services.adyen.com}anyType2anyTypeMap" minOccurs="0"/>
 *         &lt;element name="pspReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="response" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModificationResult", propOrder = {
    "additionalData",
    "pspReference",
    "response"
})
public class ModificationResult {

    @XmlElementRef(name = "additionalData", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<AnyType2AnyTypeMap> additionalData;
    @XmlElementRef(name = "pspReference", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> pspReference;
    @XmlElementRef(name = "response", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> response;

    /**
     * Gets the value of the additionalData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}
     *     
     */
    public JAXBElement<AnyType2AnyTypeMap> getAdditionalData() {
        return additionalData;
    }

    /**
     * Sets the value of the additionalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}
     *     
     */
    public void setAdditionalData(JAXBElement<AnyType2AnyTypeMap> value) {
        this.additionalData = ((JAXBElement<AnyType2AnyTypeMap> ) value);
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
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResponse(JAXBElement<String> value) {
        this.response = ((JAXBElement<String> ) value);
    }

}
