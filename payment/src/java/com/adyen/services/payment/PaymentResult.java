
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalData" type="{http://payment.services.adyen.com}anyType2anyTypeMap" minOccurs="0"/>
 *         &lt;element name="authCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dccAmount" type="{http://common.services.adyen.com}Amount" minOccurs="0"/>
 *         &lt;element name="dccSignature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fraudResult" type="{http://payment.services.adyen.com}FraudResult" minOccurs="0"/>
 *         &lt;element name="issuerUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="md" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paRequest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pspReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refusalReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentResult", propOrder = {
    "additionalData",
    "authCode",
    "dccAmount",
    "dccSignature",
    "fraudResult",
    "issuerUrl",
    "md",
    "paRequest",
    "pspReference",
    "refusalReason",
    "resultCode"
})
public class PaymentResult {

    @XmlElementRef(name = "additionalData", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<AnyType2AnyTypeMap> additionalData;
    @XmlElementRef(name = "authCode", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> authCode;
    @XmlElementRef(name = "dccAmount", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Amount> dccAmount;
    @XmlElementRef(name = "dccSignature", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> dccSignature;
    @XmlElementRef(name = "fraudResult", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<FraudResult> fraudResult;
    @XmlElementRef(name = "issuerUrl", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> issuerUrl;
    @XmlElementRef(name = "md", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> md;
    @XmlElementRef(name = "paRequest", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> paRequest;
    @XmlElementRef(name = "pspReference", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> pspReference;
    @XmlElementRef(name = "refusalReason", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> refusalReason;
    @XmlElementRef(name = "resultCode", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> resultCode;

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
     * Gets the value of the authCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAuthCode() {
        return authCode;
    }

    /**
     * Sets the value of the authCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAuthCode(JAXBElement<String> value) {
        this.authCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the dccAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public JAXBElement<Amount> getDccAmount() {
        return dccAmount;
    }

    /**
     * Sets the value of the dccAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public void setDccAmount(JAXBElement<Amount> value) {
        this.dccAmount = ((JAXBElement<Amount> ) value);
    }

    /**
     * Gets the value of the dccSignature property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDccSignature() {
        return dccSignature;
    }

    /**
     * Sets the value of the dccSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDccSignature(JAXBElement<String> value) {
        this.dccSignature = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the fraudResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FraudResult }{@code >}
     *     
     */
    public JAXBElement<FraudResult> getFraudResult() {
        return fraudResult;
    }

    /**
     * Sets the value of the fraudResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FraudResult }{@code >}
     *     
     */
    public void setFraudResult(JAXBElement<FraudResult> value) {
        this.fraudResult = ((JAXBElement<FraudResult> ) value);
    }

    /**
     * Gets the value of the issuerUrl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIssuerUrl() {
        return issuerUrl;
    }

    /**
     * Sets the value of the issuerUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIssuerUrl(JAXBElement<String> value) {
        this.issuerUrl = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the md property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMd() {
        return md;
    }

    /**
     * Sets the value of the md property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMd(JAXBElement<String> value) {
        this.md = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the paRequest property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPaRequest() {
        return paRequest;
    }

    /**
     * Sets the value of the paRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPaRequest(JAXBElement<String> value) {
        this.paRequest = ((JAXBElement<String> ) value);
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
     * Gets the value of the refusalReason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRefusalReason() {
        return refusalReason;
    }

    /**
     * Sets the value of the refusalReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRefusalReason(JAXBElement<String> value) {
        this.refusalReason = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the resultCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResultCode() {
        return resultCode;
    }

    /**
     * Sets the value of the resultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResultCode(JAXBElement<String> value) {
        this.resultCode = ((JAXBElement<String> ) value);
    }

}
