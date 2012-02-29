
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalAmount" type="{http://common.services.adyen.com}Amount" minOccurs="0"/>
 *         &lt;element name="additionalData" type="{http://payment.services.adyen.com}anyType2anyTypeMap" minOccurs="0"/>
 *         &lt;element name="amount" type="{http://common.services.adyen.com}Amount" minOccurs="0"/>
 *         &lt;element name="bankAccount" type="{http://payment.services.adyen.com}BankAccount" minOccurs="0"/>
 *         &lt;element name="browserInfo" type="{http://common.services.adyen.com}BrowserInfo" minOccurs="0"/>
 *         &lt;element name="card" type="{http://payment.services.adyen.com}Card" minOccurs="0"/>
 *         &lt;element name="dccQuote" type="{http://payment.services.adyen.com}ForexQuote" minOccurs="0"/>
 *         &lt;element name="deliveryAddress" type="{http://common.services.adyen.com}Address" minOccurs="0"/>
 *         &lt;element name="elv" type="{http://payment.services.adyen.com}ELV" minOccurs="0"/>
 *         &lt;element name="fraudOffset" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="merchantAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mpiData" type="{http://payment.services.adyen.com}ThreeDSecureData" minOccurs="0"/>
 *         &lt;element name="orderReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recurring" type="{http://payment.services.adyen.com}Recurring" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="selectedBrand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="selectedRecurringDetailReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopperEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopperIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopperInteraction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shopperReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "PaymentRequest", propOrder = {
    "additionalAmount",
    "additionalData",
    "amount",
    "bankAccount",
    "browserInfo",
    "card",
    "dccQuote",
    "deliveryAddress",
    "elv",
    "fraudOffset",
    "merchantAccount",
    "mpiData",
    "orderReference",
    "recurring",
    "reference",
    "selectedBrand",
    "selectedRecurringDetailReference",
    "sessionId",
    "shopperEmail",
    "shopperIP",
    "shopperInteraction",
    "shopperReference",
    "shopperStatement"
})
public class PaymentRequest {

    @XmlElementRef(name = "additionalAmount", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Amount> additionalAmount;
    @XmlElementRef(name = "additionalData", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<AnyType2AnyTypeMap> additionalData;
    @XmlElementRef(name = "amount", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Amount> amount;
    @XmlElementRef(name = "bankAccount", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<BankAccount> bankAccount;
    @XmlElementRef(name = "browserInfo", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<BrowserInfo> browserInfo;
    @XmlElementRef(name = "card", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Card> card;
    @XmlElementRef(name = "dccQuote", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<ForexQuote> dccQuote;
    @XmlElementRef(name = "deliveryAddress", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Address> deliveryAddress;
    @XmlElementRef(name = "elv", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<ELV> elv;
    @XmlElementRef(name = "fraudOffset", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Integer> fraudOffset;
    @XmlElementRef(name = "merchantAccount", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> merchantAccount;
    @XmlElementRef(name = "mpiData", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<ThreeDSecureData> mpiData;
    @XmlElementRef(name = "orderReference", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> orderReference;
    @XmlElementRef(name = "recurring", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<Recurring> recurring;
    @XmlElementRef(name = "reference", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> reference;
    @XmlElementRef(name = "selectedBrand", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> selectedBrand;
    @XmlElementRef(name = "selectedRecurringDetailReference", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> selectedRecurringDetailReference;
    @XmlElementRef(name = "sessionId", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> sessionId;
    @XmlElementRef(name = "shopperEmail", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> shopperEmail;
    @XmlElementRef(name = "shopperIP", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> shopperIP;
    @XmlElementRef(name = "shopperInteraction", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> shopperInteraction;
    @XmlElementRef(name = "shopperReference", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> shopperReference;
    @XmlElementRef(name = "shopperStatement", namespace = "http://payment.services.adyen.com", type = JAXBElement.class)
    protected JAXBElement<String> shopperStatement;

    /**
     * Gets the value of the additionalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public JAXBElement<Amount> getAdditionalAmount() {
        return additionalAmount;
    }

    /**
     * Sets the value of the additionalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public void setAdditionalAmount(JAXBElement<Amount> value) {
        this.additionalAmount = ((JAXBElement<Amount> ) value);
    }

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
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public JAXBElement<Amount> getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Amount }{@code >}
     *     
     */
    public void setAmount(JAXBElement<Amount> value) {
        this.amount = ((JAXBElement<Amount> ) value);
    }

    /**
     * Gets the value of the bankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BankAccount }{@code >}
     *     
     */
    public JAXBElement<BankAccount> getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the value of the bankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BankAccount }{@code >}
     *     
     */
    public void setBankAccount(JAXBElement<BankAccount> value) {
        this.bankAccount = ((JAXBElement<BankAccount> ) value);
    }

    /**
     * Gets the value of the browserInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BrowserInfo }{@code >}
     *     
     */
    public JAXBElement<BrowserInfo> getBrowserInfo() {
        return browserInfo;
    }

    /**
     * Sets the value of the browserInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BrowserInfo }{@code >}
     *     
     */
    public void setBrowserInfo(JAXBElement<BrowserInfo> value) {
        this.browserInfo = ((JAXBElement<BrowserInfo> ) value);
    }

    /**
     * Gets the value of the card property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Card }{@code >}
     *     
     */
    public JAXBElement<Card> getCard() {
        return card;
    }

    /**
     * Sets the value of the card property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Card }{@code >}
     *     
     */
    public void setCard(JAXBElement<Card> value) {
        this.card = ((JAXBElement<Card> ) value);
    }

    /**
     * Gets the value of the dccQuote property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ForexQuote }{@code >}
     *     
     */
    public JAXBElement<ForexQuote> getDccQuote() {
        return dccQuote;
    }

    /**
     * Sets the value of the dccQuote property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ForexQuote }{@code >}
     *     
     */
    public void setDccQuote(JAXBElement<ForexQuote> value) {
        this.dccQuote = ((JAXBElement<ForexQuote> ) value);
    }

    /**
     * Gets the value of the deliveryAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Address }{@code >}
     *     
     */
    public JAXBElement<Address> getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Sets the value of the deliveryAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Address }{@code >}
     *     
     */
    public void setDeliveryAddress(JAXBElement<Address> value) {
        this.deliveryAddress = ((JAXBElement<Address> ) value);
    }

    /**
     * Gets the value of the elv property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ELV }{@code >}
     *     
     */
    public JAXBElement<ELV> getElv() {
        return elv;
    }

    /**
     * Sets the value of the elv property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ELV }{@code >}
     *     
     */
    public void setElv(JAXBElement<ELV> value) {
        this.elv = ((JAXBElement<ELV> ) value);
    }

    /**
     * Gets the value of the fraudOffset property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getFraudOffset() {
        return fraudOffset;
    }

    /**
     * Sets the value of the fraudOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setFraudOffset(JAXBElement<Integer> value) {
        this.fraudOffset = ((JAXBElement<Integer> ) value);
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
     * Gets the value of the mpiData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ThreeDSecureData }{@code >}
     *     
     */
    public JAXBElement<ThreeDSecureData> getMpiData() {
        return mpiData;
    }

    /**
     * Sets the value of the mpiData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ThreeDSecureData }{@code >}
     *     
     */
    public void setMpiData(JAXBElement<ThreeDSecureData> value) {
        this.mpiData = ((JAXBElement<ThreeDSecureData> ) value);
    }

    /**
     * Gets the value of the orderReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrderReference() {
        return orderReference;
    }

    /**
     * Sets the value of the orderReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrderReference(JAXBElement<String> value) {
        this.orderReference = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the recurring property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Recurring }{@code >}
     *     
     */
    public JAXBElement<Recurring> getRecurring() {
        return recurring;
    }

    /**
     * Sets the value of the recurring property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Recurring }{@code >}
     *     
     */
    public void setRecurring(JAXBElement<Recurring> value) {
        this.recurring = ((JAXBElement<Recurring> ) value);
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
     * Gets the value of the selectedBrand property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSelectedBrand() {
        return selectedBrand;
    }

    /**
     * Sets the value of the selectedBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSelectedBrand(JAXBElement<String> value) {
        this.selectedBrand = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the selectedRecurringDetailReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSelectedRecurringDetailReference() {
        return selectedRecurringDetailReference;
    }

    /**
     * Sets the value of the selectedRecurringDetailReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSelectedRecurringDetailReference(JAXBElement<String> value) {
        this.selectedRecurringDetailReference = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSessionId(JAXBElement<String> value) {
        this.sessionId = ((JAXBElement<String> ) value);
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
     * Gets the value of the shopperIP property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShopperIP() {
        return shopperIP;
    }

    /**
     * Sets the value of the shopperIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShopperIP(JAXBElement<String> value) {
        this.shopperIP = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shopperInteraction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShopperInteraction() {
        return shopperInteraction;
    }

    /**
     * Sets the value of the shopperInteraction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShopperInteraction(JAXBElement<String> value) {
        this.shopperInteraction = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the shopperReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShopperReference() {
        return shopperReference;
    }

    /**
     * Sets the value of the shopperReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShopperReference(JAXBElement<String> value) {
        this.shopperReference = ((JAXBElement<String> ) value);
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
