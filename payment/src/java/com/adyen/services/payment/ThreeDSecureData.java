
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ThreeDSecureData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThreeDSecureData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authenticationResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cavv" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="cavvAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="directoryResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eci" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xid" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ThreeDSecureData", propOrder = {
    "authenticationResponse",
    "cavv",
    "cavvAlgorithm",
    "directoryResponse",
    "eci",
    "xid"
})
public class ThreeDSecureData {

    @XmlElementRef(name = "authenticationResponse", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> authenticationResponse;
    @XmlElementRef(name = "cavv", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<byte[]> cavv;
    @XmlElementRef(name = "cavvAlgorithm", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> cavvAlgorithm;
    @XmlElementRef(name = "directoryResponse", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> directoryResponse;
    @XmlElementRef(name = "eci", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> eci;
    @XmlElementRef(name = "xid", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<byte[]> xid;

    /**
     * Gets the value of the authenticationResponse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAuthenticationResponse() {
        return authenticationResponse;
    }

    /**
     * Sets the value of the authenticationResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAuthenticationResponse(JAXBElement<String> value) {
        this.authenticationResponse = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the cavv property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getCavv() {
        return cavv;
    }

    /**
     * Sets the value of the cavv property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setCavv(JAXBElement<byte[]> value) {
        this.cavv = ((JAXBElement<byte[]> ) value);
    }

    /**
     * Gets the value of the cavvAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCavvAlgorithm() {
        return cavvAlgorithm;
    }

    /**
     * Sets the value of the cavvAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCavvAlgorithm(JAXBElement<String> value) {
        this.cavvAlgorithm = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the directoryResponse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDirectoryResponse() {
        return directoryResponse;
    }

    /**
     * Sets the value of the directoryResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDirectoryResponse(JAXBElement<String> value) {
        this.directoryResponse = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the eci property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEci() {
        return eci;
    }

    /**
     * Sets the value of the eci property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEci(JAXBElement<String> value) {
        this.eci = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the xid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getXid() {
        return xid;
    }

    /**
     * Sets the value of the xid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setXid(JAXBElement<byte[]> value) {
        this.xid = ((JAXBElement<byte[]> ) value);
    }

}
