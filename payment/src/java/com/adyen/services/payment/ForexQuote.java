
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ForexQuote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ForexQuote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baseAmount" type="{http://common.services.adyen.com}Amount" minOccurs="0"/>
 *         &lt;element name="basePoints" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="buy" type="{http://common.services.adyen.com}Amount" minOccurs="0"/>
 *         &lt;element name="interbank" type="{http://common.services.adyen.com}Amount" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sell" type="{http://common.services.adyen.com}Amount" minOccurs="0"/>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validTill" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForexQuote", propOrder = {
    "account",
    "accountType",
    "baseAmount",
    "basePoints",
    "buy",
    "interbank",
    "reference",
    "sell",
    "signature",
    "source",
    "type",
    "validTill"
})
public class ForexQuote {

    @XmlElementRef(name = "account", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> account;
    @XmlElementRef(name = "accountType", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> accountType;
    @XmlElementRef(name = "baseAmount", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Amount> baseAmount;
    protected int basePoints;
    @XmlElementRef(name = "buy", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Amount> buy;
    @XmlElementRef(name = "interbank", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Amount> interbank;
    @XmlElementRef(name = "reference", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> reference;
    @XmlElementRef(name = "sell", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Amount> sell;
    @XmlElementRef(name = "signature", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> signature;
    @XmlElementRef(name = "source", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> source;
    @XmlElementRef(name = "type", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> type;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validTill;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccount(JAXBElement<String> value) {
        this.account = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountType(JAXBElement<String> value) {
        this.accountType = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the baseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public JAXBElement<Amount> getBaseAmount() {
        return baseAmount;
    }

    /**
     * Sets the value of the baseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public void setBaseAmount(JAXBElement<Amount> value) {
        this.baseAmount = ((JAXBElement<Amount> ) value);
    }

    /**
     * Gets the value of the basePoints property.
     * 
     */
    public int getBasePoints() {
        return basePoints;
    }

    /**
     * Sets the value of the basePoints property.
     * 
     */
    public void setBasePoints(int value) {
        this.basePoints = value;
    }

    /**
     * Gets the value of the buy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public JAXBElement<Amount> getBuy() {
        return buy;
    }

    /**
     * Sets the value of the buy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public void setBuy(JAXBElement<Amount> value) {
        this.buy = ((JAXBElement<Amount> ) value);
    }

    /**
     * Gets the value of the interbank property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public JAXBElement<Amount> getInterbank() {
        return interbank;
    }

    /**
     * Sets the value of the interbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public void setInterbank(JAXBElement<Amount> value) {
        this.interbank = ((JAXBElement<Amount> ) value);
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
     * Gets the value of the sell property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public JAXBElement<Amount> getSell() {
        return sell;
    }

    /**
     * Sets the value of the sell property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public void setSell(JAXBElement<Amount> value) {
        this.sell = ((JAXBElement<Amount> ) value);
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSignature(JAXBElement<String> value) {
        this.signature = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSource(JAXBElement<String> value) {
        this.source = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setType(JAXBElement<String> value) {
        this.type = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the validTill property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidTill() {
        return validTill;
    }

    /**
     * Sets the value of the validTill property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidTill(XMLGregorianCalendar value) {
        this.validTill = value;
    }

}
