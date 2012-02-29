
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FundTransferRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FundTransferRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalData" type="{http://payment.services.adyen.com}anyType2anyTypeMap" minOccurs="0"/>
 *         &lt;element name="authorisationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modificationAmount" type="{http://common.services.adyen.com}Amount" minOccurs="0"/>
 *         &lt;element name="originalReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopperEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopperStatement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FundTransferRequest", propOrder = {
    "additionalData",
    "authorisationCode",
    "merchantAccount",
    "modificationAmount",
    "originalReference",
    "reference",
    "shopperEmail",
    "shopperStatement"
})
public class FundTransferRequest {

    @XmlElementRef(name = "additionalData", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<AnyType2AnyTypeMap> additionalData;
    @XmlElementRef(name = "authorisationCode", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> authorisationCode;
    @XmlElementRef(name = "merchantAccount", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> merchantAccount;
    @XmlElementRef(name = "modificationAmount", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Amount> modificationAmount;
    @XmlElementRef(name = "originalReference", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> originalReference;
    @XmlElementRef(name = "reference", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> reference;
    @XmlElementRef(name = "shopperEmail", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> shopperEmail;
    @XmlElementRef(name = "shopperStatement", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> shopperStatement;

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
     * Gets the value of the authorisationCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAuthorisationCode() {
        return authorisationCode;
    }

    /**
     * Sets the value of the authorisationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAuthorisationCode(JAXBElement<String> value) {
        this.authorisationCode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the merchantAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMerchantAccount() {
        return merchantAccount;
    }

    /**
     * Sets the value of the merchantAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMerchantAccount(JAXBElement<String> value) {
        this.merchantAccount = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the modificationAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public JAXBElement<Amount> getModificationAmount() {
        return modificationAmount;
    }

    /**
     * Sets the value of the modificationAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public void setModificationAmount(JAXBElement<Amount> value) {
        this.modificationAmount = ((JAXBElement<Amount> ) value);
    }

    /**
     * Gets the value of the originalReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginalReference() {
        return originalReference;
    }

    /**
     * Sets the value of the originalReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginalReference(JAXBElement<String> value) {
        this.originalReference = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReference(JAXBElement<String> value) {
        this.reference = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shopperEmail property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShopperEmail() {
        return shopperEmail;
    }

    /**
     * Sets the value of the shopperEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShopperEmail(JAXBElement<String> value) {
        this.shopperEmail = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shopperStatement property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShopperStatement() {
        return shopperStatement;
    }

    /**
     * Sets the value of the shopperStatement property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShopperStatement(JAXBElement<String> value) {
        this.shopperStatement = ((JAXBElement<String> ) value);
    }

}
