
package com.adyen.services.payment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.adyen.services.payment package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ServiceException_QNAME = new QName("http://payment.services.adyen.com", "ServiceException");
    private final static QName _FraudResultResults_QNAME = new QName("http://payment.services.adyen.com", "results");
    private final static QName _PaymentRequest3DShopperInteraction_QNAME = new QName("http://payment.services.adyen.com", "shopperInteraction");
    private final static QName _PaymentRequest3DSessionId_QNAME = new QName("http://payment.services.adyen.com", "sessionId");
    private final static QName _PaymentRequest3DSelectedBrand_QNAME = new QName("http://payment.services.adyen.com", "selectedBrand");
    private final static QName _PaymentRequest3DMd_QNAME = new QName("http://payment.services.adyen.com", "md");
    private final static QName _PaymentRequest3DAdditionalAmount_QNAME = new QName("http://payment.services.adyen.com", "additionalAmount");
    private final static QName _PaymentRequest3DBrowserInfo_QNAME = new QName("http://payment.services.adyen.com", "browserInfo");
    private final static QName _PaymentRequest3DAmount_QNAME = new QName("http://payment.services.adyen.com", "amount");
    private final static QName _PaymentRequest3DPaResponse_QNAME = new QName("http://payment.services.adyen.com", "paResponse");
    private final static QName _PaymentRequest3DDeliveryAddress_QNAME = new QName("http://payment.services.adyen.com", "deliveryAddress");
    private final static QName _PaymentRequest3DRecurring_QNAME = new QName("http://payment.services.adyen.com", "recurring");
    private final static QName _PaymentRequest3DSelectedRecurringDetailReference_QNAME = new QName("http://payment.services.adyen.com", "selectedRecurringDetailReference");
    private final static QName _PaymentRequest3DShopperReference_QNAME = new QName("http://payment.services.adyen.com", "shopperReference");
    private final static QName _PaymentRequest3DShopperIP_QNAME = new QName("http://payment.services.adyen.com", "shopperIP");
    private final static QName _PaymentRequest3DReference_QNAME = new QName("http://payment.services.adyen.com", "reference");
    private final static QName _PaymentRequest3DShopperStatement_QNAME = new QName("http://payment.services.adyen.com", "shopperStatement");
    private final static QName _PaymentRequest3DMerchantAccount_QNAME = new QName("http://payment.services.adyen.com", "merchantAccount");
    private final static QName _PaymentRequest3DShopperEmail_QNAME = new QName("http://payment.services.adyen.com", "shopperEmail");
    private final static QName _PaymentRequest3DAdditionalData_QNAME = new QName("http://payment.services.adyen.com", "additionalData");
    private final static QName _PaymentRequest3DFraudOffset_QNAME = new QName("http://payment.services.adyen.com", "fraudOffset");
    private final static QName _PaymentRequest3DDccQuote_QNAME = new QName("http://payment.services.adyen.com", "dccQuote");
    private final static QName _PaymentRequest3DOrderReference_QNAME = new QName("http://payment.services.adyen.com", "orderReference");
    private final static QName _ELVBankLocationId_QNAME = new QName("http://payment.services.adyen.com", "bankLocationId");
    private final static QName _ELVAccountHolderName_QNAME = new QName("http://payment.services.adyen.com", "accountHolderName");
    private final static QName _ELVBankName_QNAME = new QName("http://payment.services.adyen.com", "bankName");
    private final static QName _ELVBankAccountNumber_QNAME = new QName("http://payment.services.adyen.com", "bankAccountNumber");
    private final static QName _ELVBankLocation_QNAME = new QName("http://payment.services.adyen.com", "bankLocation");
    private final static QName _BalanceCheckRequestBankAccount_QNAME = new QName("http://payment.services.adyen.com", "bankAccount");
    private final static QName _BalanceCheckRequestMpiData_QNAME = new QName("http://payment.services.adyen.com", "mpiData");
    private final static QName _BalanceCheckRequestCard_QNAME = new QName("http://payment.services.adyen.com", "card");
    private final static QName _BalanceCheckRequestElv_QNAME = new QName("http://payment.services.adyen.com", "elv");
    private final static QName _BankAccountOwnerName_QNAME = new QName("http://payment.services.adyen.com", "ownerName");
    private final static QName _BankAccountIban_QNAME = new QName("http://payment.services.adyen.com", "iban");
    private final static QName _BankAccountBic_QNAME = new QName("http://payment.services.adyen.com", "bic");
    private final static QName _BankAccountCountryCode_QNAME = new QName("http://payment.services.adyen.com", "countryCode");
    private final static QName _ServiceExceptionType_QNAME = new QName("http://common.services.adyen.com", "type");
    private final static QName _ServiceExceptionError_QNAME = new QName("http://common.services.adyen.com", "error");
    private final static QName _ModificationResultResponse_QNAME = new QName("http://payment.services.adyen.com", "response");
    private final static QName _ModificationResultPspReference_QNAME = new QName("http://payment.services.adyen.com", "pspReference");
    private final static QName _CardStartYear_QNAME = new QName("http://payment.services.adyen.com", "startYear");
    private final static QName _CardIssueNumber_QNAME = new QName("http://payment.services.adyen.com", "issueNumber");
    private final static QName _CardStartMonth_QNAME = new QName("http://payment.services.adyen.com", "startMonth");
    private final static QName _CardBillingAddress_QNAME = new QName("http://payment.services.adyen.com", "billingAddress");
    private final static QName _CardCvc_QNAME = new QName("http://payment.services.adyen.com", "cvc");
    private final static QName _CardBrand_QNAME = new QName("http://payment.services.adyen.com", "brand");
    private final static QName _FundTransferRequestOriginalReference_QNAME = new QName("http://payment.services.adyen.com", "originalReference");
    private final static QName _FundTransferRequestAuthorisationCode_QNAME = new QName("http://payment.services.adyen.com", "authorisationCode");
    private final static QName _FundTransferRequestModificationAmount_QNAME = new QName("http://payment.services.adyen.com", "modificationAmount");
    private final static QName _DirectDebitResponseRefusalReason_QNAME = new QName("http://payment.services.adyen.com", "refusalReason");
    private final static QName _DirectDebitResponseFraudResult_QNAME = new QName("http://payment.services.adyen.com", "fraudResult");
    private final static QName _DirectDebitResponseResultCode_QNAME = new QName("http://payment.services.adyen.com", "resultCode");
    private final static QName _BalanceCheckResultResponseCode_QNAME = new QName("http://payment.services.adyen.com", "responseCode");
    private final static QName _BalanceCheckResultCurrentBalance_QNAME = new QName("http://payment.services.adyen.com", "currentBalance");
    private final static QName _PaymentResultPaRequest_QNAME = new QName("http://payment.services.adyen.com", "paRequest");
    private final static QName _PaymentResultAuthCode_QNAME = new QName("http://payment.services.adyen.com", "authCode");
    private final static QName _PaymentResultDccSignature_QNAME = new QName("http://payment.services.adyen.com", "dccSignature");
    private final static QName _PaymentResultDccAmount_QNAME = new QName("http://payment.services.adyen.com", "dccAmount");
    private final static QName _PaymentResultIssuerUrl_QNAME = new QName("http://payment.services.adyen.com", "issuerUrl");
    private final static QName _ForexQuoteInterbank_QNAME = new QName("http://payment.services.adyen.com", "interbank");
    private final static QName _ForexQuoteSource_QNAME = new QName("http://payment.services.adyen.com", "source");
    private final static QName _ForexQuoteSell_QNAME = new QName("http://payment.services.adyen.com", "sell");
    private final static QName _ForexQuoteBuy_QNAME = new QName("http://payment.services.adyen.com", "buy");
    private final static QName _ForexQuoteBaseAmount_QNAME = new QName("http://payment.services.adyen.com", "baseAmount");
    private final static QName _ForexQuoteSignature_QNAME = new QName("http://payment.services.adyen.com", "signature");
    private final static QName _ForexQuoteType_QNAME = new QName("http://payment.services.adyen.com", "type");
    private final static QName _ForexQuoteAccountType_QNAME = new QName("http://payment.services.adyen.com", "accountType");
    private final static QName _ForexQuoteAccount_QNAME = new QName("http://payment.services.adyen.com", "account");
    private final static QName _AddressStateOrProvince_QNAME = new QName("http://common.services.adyen.com", "stateOrProvince");
    private final static QName _AddressCountry_QNAME = new QName("http://common.services.adyen.com", "country");
    private final static QName _AddressCity_QNAME = new QName("http://common.services.adyen.com", "city");
    private final static QName _AddressHouseNumberOrName_QNAME = new QName("http://common.services.adyen.com", "houseNumberOrName");
    private final static QName _AddressPostalCode_QNAME = new QName("http://common.services.adyen.com", "postalCode");
    private final static QName _AddressStreet_QNAME = new QName("http://common.services.adyen.com", "street");
    private final static QName _RecurringContract_QNAME = new QName("http://payment.services.adyen.com", "contract");
    private final static QName _RecurringRecurringDetailName_QNAME = new QName("http://payment.services.adyen.com", "recurringDetailName");
    private final static QName _ThreeDSecureDataAuthenticationResponse_QNAME = new QName("http://payment.services.adyen.com", "authenticationResponse");
    private final static QName _ThreeDSecureDataEci_QNAME = new QName("http://payment.services.adyen.com", "eci");
    private final static QName _ThreeDSecureDataCavvAlgorithm_QNAME = new QName("http://payment.services.adyen.com", "cavvAlgorithm");
    private final static QName _ThreeDSecureDataDirectoryResponse_QNAME = new QName("http://payment.services.adyen.com", "directoryResponse");
    private final static QName _ThreeDSecureDataCavv_QNAME = new QName("http://payment.services.adyen.com", "cavv");
    private final static QName _ThreeDSecureDataXid_QNAME = new QName("http://payment.services.adyen.com", "xid");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.adyen.services.payment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FundTransferResponse }
     * 
     */
    public FundTransferResponse createFundTransferResponse() {
        return new FundTransferResponse();
    }

    /**
     * Create an instance of {@link ELV }
     * 
     */
    public ELV createELV() {
        return new ELV();
    }

    /**
     * Create an instance of {@link Authorise3DResponse }
     * 
     */
    public Authorise3DResponse createAuthorise3DResponse() {
        return new Authorise3DResponse();
    }

    /**
     * Create an instance of {@link AuthoriseReferralResponse }
     * 
     */
    public AuthoriseReferralResponse createAuthoriseReferralResponse() {
        return new AuthoriseReferralResponse();
    }

    /**
     * Create an instance of {@link CheckFraud }
     * 
     */
    public CheckFraud createCheckFraud() {
        return new CheckFraud();
    }

    /**
     * Create an instance of {@link Card }
     * 
     */
    public Card createCard() {
        return new Card();
    }

    /**
     * Create an instance of {@link FundTransferRequest }
     * 
     */
    public FundTransferRequest createFundTransferRequest() {
        return new FundTransferRequest();
    }

    /**
     * Create an instance of {@link PaymentRequest }
     * 
     */
    public PaymentRequest createPaymentRequest() {
        return new PaymentRequest();
    }

    /**
     * Create an instance of {@link PaymentResult }
     * 
     */
    public PaymentResult createPaymentResult() {
        return new PaymentResult();
    }

    /**
     * Create an instance of {@link ThreeDSecureData }
     * 
     */
    public ThreeDSecureData createThreeDSecureData() {
        return new ThreeDSecureData();
    }

    /**
     * Create an instance of {@link PaymentRequest3D }
     * 
     */
    public PaymentRequest3D createPaymentRequest3D() {
        return new PaymentRequest3D();
    }

    /**
     * Create an instance of {@link Amount }
     * 
     */
    public Amount createAmount() {
        return new Amount();
    }

    /**
     * Create an instance of {@link CancelOrRefund }
     * 
     */
    public CancelOrRefund createCancelOrRefund() {
        return new CancelOrRefund();
    }

    /**
     * Create an instance of {@link BalanceCheckResponse }
     * 
     */
    public BalanceCheckResponse createBalanceCheckResponse() {
        return new BalanceCheckResponse();
    }

    /**
     * Create an instance of {@link Cancel }
     * 
     */
    public Cancel createCancel() {
        return new Cancel();
    }

    /**
     * Create an instance of {@link Refund }
     * 
     */
    public Refund createRefund() {
        return new Refund();
    }

    /**
     * Create an instance of {@link RefundResponse }
     * 
     */
    public RefundResponse createRefundResponse() {
        return new RefundResponse();
    }

    /**
     * Create an instance of {@link ModificationRequest }
     * 
     */
    public ModificationRequest createModificationRequest() {
        return new ModificationRequest();
    }

    /**
     * Create an instance of {@link Capture }
     * 
     */
    public Capture createCapture() {
        return new Capture();
    }

    /**
     * Create an instance of {@link DirectDebitResponse }
     * 
     */
    public DirectDebitResponse createDirectdebitResponse() {
        return new DirectDebitResponse();
    }

    /**
     * Create an instance of {@link ForexQuote }
     * 
     */
    public ForexQuote createForexQuote() {
        return new ForexQuote();
    }

    /**
     * Create an instance of {@link CancelResponse }
     * 
     */
    public CancelResponse createCancelResponse() {
        return new CancelResponse();
    }

    /**
     * Create an instance of {@link BalanceCheck }
     * 
     */
    public BalanceCheck createBalanceCheck() {
        return new BalanceCheck();
    }

    /**
     * Create an instance of {@link AuthoriseReferral }
     * 
     */
    public AuthoriseReferral createAuthoriseReferral() {
        return new AuthoriseReferral();
    }

    /**
     * Create an instance of {@link AnyType2AnyTypeMap.Entry }
     * 
     */
    public AnyType2AnyTypeMap.Entry createAnyType2AnyTypeMapEntry() {
        return new AnyType2AnyTypeMap.Entry();
    }

    /**
     * Create an instance of {@link Directdebit }
     * 
     */
    public Directdebit createDirectdebit() {
        return new Directdebit();
    }

    /**
     * Create an instance of {@link CancelOrRefundResponse }
     * 
     */
    public CancelOrRefundResponse createCancelOrRefundResponse() {
        return new CancelOrRefundResponse();
    }

    /**
     * Create an instance of {@link FraudResult }
     * 
     */
    public FraudResult createFraudResult() {
        return new FraudResult();
    }

    /**
     * Create an instance of {@link BalanceCheckRequest }
     * 
     */
    public BalanceCheckRequest createBalanceCheckRequest() {
        return new BalanceCheckRequest();
    }

    /**
     * Create an instance of {@link ServiceException }
     * 
     */
    public ServiceException createServiceException() {
        return new ServiceException();
    }

    /**
     * Create an instance of {@link ArrayOfFraudCheckResult }
     * 
     */
    public ArrayOfFraudCheckResult createArrayOfFraudCheckResult() {
        return new ArrayOfFraudCheckResult();
    }

    /**
     * Create an instance of {@link BrowserInfo }
     * 
     */
    public BrowserInfo createBrowserInfo() {
        return new BrowserInfo();
    }

    /**
     * Create an instance of {@link AnyType2AnyTypeMap }
     * 
     */
    public AnyType2AnyTypeMap createAnyType2AnyTypeMap() {
        return new AnyType2AnyTypeMap();
    }

    /**
     * Create an instance of {@link RefundWithDataResponse }
     * 
     */
    public RefundWithDataResponse createRefundWithDataResponse() {
        return new RefundWithDataResponse();
    }

    /**
     * Create an instance of {@link FundTransferResult }
     * 
     */
    public FundTransferResult createFundTransferResult() {
        return new FundTransferResult();
    }

    /**
     * Create an instance of {@link BalanceCheckResult }
     * 
     */
    public BalanceCheckResult createBalanceCheckResult() {
        return new BalanceCheckResult();
    }

    /**
     * Create an instance of {@link Authorise }
     * 
     */
    public Authorise createAuthorise() {
        return new Authorise();
    }

    /**
     * Create an instance of {@link Recurring }
     * 
     */
    public Recurring createRecurring() {
        return new Recurring();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link RefundWithData }
     * 
     */
    public RefundWithData createRefundWithData() {
        return new RefundWithData();
    }

    /**
     * Create an instance of {@link FraudCheckResult }
     * 
     */
    public FraudCheckResult createFraudCheckResult() {
        return new FraudCheckResult();
    }

    /**
     * Create an instance of {@link BankAccount }
     * 
     */
    public BankAccount createBankAccount() {
        return new BankAccount();
    }

    /**
     * Create an instance of {@link ModificationResult }
     * 
     */
    public ModificationResult createModificationResult() {
        return new ModificationResult();
    }

    /**
     * Create an instance of {@link Authorise3D }
     * 
     */
    public Authorise3D createAuthorise3D() {
        return new Authorise3D();
    }

    /**
     * Create an instance of {@link FundTransfer }
     * 
     */
    public FundTransfer createFundTransfer() {
        return new FundTransfer();
    }

    /**
     * Create an instance of {@link DirectDebitResponse }
     * 
     */
    public DirectDebitResponse createDirectDebitResponse() {
        return new DirectDebitResponse();
    }

    /**
     * Create an instance of {@link DirectDebitRequest }
     * 
     */
    public DirectDebitRequest createDirectDebitRequest() {
        return new DirectDebitRequest();
    }

    /**
     * Create an instance of {@link CheckFraudResponse }
     * 
     */
    public CheckFraudResponse createCheckFraudResponse() {
        return new CheckFraudResponse();
    }

    /**
     * Create an instance of {@link CaptureResponse }
     * 
     */
    public CaptureResponse createCaptureResponse() {
        return new CaptureResponse();
    }

    /**
     * Create an instance of {@link AuthoriseResponse }
     * 
     */
    public AuthoriseResponse createAuthoriseResponse() {
        return new AuthoriseResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "ServiceException")
    public JAXBElement<ServiceException> createServiceException(ServiceException value) {
        return new JAXBElement<ServiceException>(_ServiceException_QNAME, ServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfFraudCheckResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "results", scope = FraudResult.class)
    public JAXBElement<ArrayOfFraudCheckResult> createFraudResultResults(ArrayOfFraudCheckResult value) {
        return new JAXBElement<ArrayOfFraudCheckResult>(_FraudResultResults_QNAME, ArrayOfFraudCheckResult.class, FraudResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperInteraction", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DShopperInteraction(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperInteraction_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "sessionId", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DSessionId(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSessionId_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "selectedBrand", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DSelectedBrand(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSelectedBrand_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "md", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DMd(String value) {
        return new JAXBElement<String>(_PaymentRequest3DMd_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalAmount", scope = PaymentRequest3D.class)
    public JAXBElement<Amount> createPaymentRequest3DAdditionalAmount(Amount value) {
        return new JAXBElement<Amount>(_PaymentRequest3DAdditionalAmount_QNAME, Amount.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BrowserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "browserInfo", scope = PaymentRequest3D.class)
    public JAXBElement<BrowserInfo> createPaymentRequest3DBrowserInfo(BrowserInfo value) {
        return new JAXBElement<BrowserInfo>(_PaymentRequest3DBrowserInfo_QNAME, BrowserInfo.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "amount", scope = PaymentRequest3D.class)
    public JAXBElement<Amount> createPaymentRequest3DAmount(Amount value) {
        return new JAXBElement<Amount>(_PaymentRequest3DAmount_QNAME, Amount.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "paResponse", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DPaResponse(String value) {
        return new JAXBElement<String>(_PaymentRequest3DPaResponse_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "deliveryAddress", scope = PaymentRequest3D.class)
    public JAXBElement<Address> createPaymentRequest3DDeliveryAddress(Address value) {
        return new JAXBElement<Address>(_PaymentRequest3DDeliveryAddress_QNAME, Address.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Recurring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "recurring", scope = PaymentRequest3D.class)
    public JAXBElement<Recurring> createPaymentRequest3DRecurring(Recurring value) {
        return new JAXBElement<Recurring>(_PaymentRequest3DRecurring_QNAME, Recurring.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "selectedRecurringDetailReference", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DSelectedRecurringDetailReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSelectedRecurringDetailReference_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperReference", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DShopperReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperReference_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperIP", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DShopperIP(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperIP_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "reference", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DReference_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperStatement", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DShopperStatement(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperStatement_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "merchantAccount", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DMerchantAccount(String value) {
        return new JAXBElement<String>(_PaymentRequest3DMerchantAccount_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperEmail", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DShopperEmail(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperEmail_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalData", scope = PaymentRequest3D.class)
    public JAXBElement<AnyType2AnyTypeMap> createPaymentRequest3DAdditionalData(AnyType2AnyTypeMap value) {
        return new JAXBElement<AnyType2AnyTypeMap>(_PaymentRequest3DAdditionalData_QNAME, AnyType2AnyTypeMap.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "fraudOffset", scope = PaymentRequest3D.class)
    public JAXBElement<Integer> createPaymentRequest3DFraudOffset(Integer value) {
        return new JAXBElement<Integer>(_PaymentRequest3DFraudOffset_QNAME, Integer.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForexQuote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "dccQuote", scope = PaymentRequest3D.class)
    public JAXBElement<ForexQuote> createPaymentRequest3DDccQuote(ForexQuote value) {
        return new JAXBElement<ForexQuote>(_PaymentRequest3DDccQuote_QNAME, ForexQuote.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "orderReference", scope = PaymentRequest3D.class)
    public JAXBElement<String> createPaymentRequest3DOrderReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DOrderReference_QNAME, String.class, PaymentRequest3D.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bankLocationId", scope = ELV.class)
    public JAXBElement<String> createELVBankLocationId(String value) {
        return new JAXBElement<String>(_ELVBankLocationId_QNAME, String.class, ELV.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "accountHolderName", scope = ELV.class)
    public JAXBElement<String> createELVAccountHolderName(String value) {
        return new JAXBElement<String>(_ELVAccountHolderName_QNAME, String.class, ELV.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bankName", scope = ELV.class)
    public JAXBElement<String> createELVBankName(String value) {
        return new JAXBElement<String>(_ELVBankName_QNAME, String.class, ELV.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bankAccountNumber", scope = ELV.class)
    public JAXBElement<String> createELVBankAccountNumber(String value) {
        return new JAXBElement<String>(_ELVBankAccountNumber_QNAME, String.class, ELV.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bankLocation", scope = ELV.class)
    public JAXBElement<String> createELVBankLocation(String value) {
        return new JAXBElement<String>(_ELVBankLocation_QNAME, String.class, ELV.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperInteraction", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestShopperInteraction(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperInteraction_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "sessionId", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestSessionId(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSessionId_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "selectedBrand", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestSelectedBrand(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSelectedBrand_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalAmount", scope = BalanceCheckRequest.class)
    public JAXBElement<Amount> createBalanceCheckRequestAdditionalAmount(Amount value) {
        return new JAXBElement<Amount>(_PaymentRequest3DAdditionalAmount_QNAME, Amount.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BrowserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "browserInfo", scope = BalanceCheckRequest.class)
    public JAXBElement<BrowserInfo> createBalanceCheckRequestBrowserInfo(BrowserInfo value) {
        return new JAXBElement<BrowserInfo>(_PaymentRequest3DBrowserInfo_QNAME, BrowserInfo.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "amount", scope = BalanceCheckRequest.class)
    public JAXBElement<Amount> createBalanceCheckRequestAmount(Amount value) {
        return new JAXBElement<Amount>(_PaymentRequest3DAmount_QNAME, Amount.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "deliveryAddress", scope = BalanceCheckRequest.class)
    public JAXBElement<Address> createBalanceCheckRequestDeliveryAddress(Address value) {
        return new JAXBElement<Address>(_PaymentRequest3DDeliveryAddress_QNAME, Address.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bankAccount", scope = BalanceCheckRequest.class)
    public JAXBElement<BankAccount> createBalanceCheckRequestBankAccount(BankAccount value) {
        return new JAXBElement<BankAccount>(_BalanceCheckRequestBankAccount_QNAME, BankAccount.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Recurring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "recurring", scope = BalanceCheckRequest.class)
    public JAXBElement<Recurring> createBalanceCheckRequestRecurring(Recurring value) {
        return new JAXBElement<Recurring>(_PaymentRequest3DRecurring_QNAME, Recurring.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ThreeDSecureData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "mpiData", scope = BalanceCheckRequest.class)
    public JAXBElement<ThreeDSecureData> createBalanceCheckRequestMpiData(ThreeDSecureData value) {
        return new JAXBElement<ThreeDSecureData>(_BalanceCheckRequestMpiData_QNAME, ThreeDSecureData.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "selectedRecurringDetailReference", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestSelectedRecurringDetailReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSelectedRecurringDetailReference_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "card", scope = BalanceCheckRequest.class)
    public JAXBElement<Card> createBalanceCheckRequestCard(Card value) {
        return new JAXBElement<Card>(_BalanceCheckRequestCard_QNAME, Card.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperReference", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestShopperReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperReference_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperIP", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestShopperIP(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperIP_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "reference", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DReference_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperStatement", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestShopperStatement(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperStatement_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "merchantAccount", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestMerchantAccount(String value) {
        return new JAXBElement<String>(_PaymentRequest3DMerchantAccount_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperEmail", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestShopperEmail(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperEmail_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalData", scope = BalanceCheckRequest.class)
    public JAXBElement<AnyType2AnyTypeMap> createBalanceCheckRequestAdditionalData(AnyType2AnyTypeMap value) {
        return new JAXBElement<AnyType2AnyTypeMap>(_PaymentRequest3DAdditionalData_QNAME, AnyType2AnyTypeMap.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ELV }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "elv", scope = BalanceCheckRequest.class)
    public JAXBElement<ELV> createBalanceCheckRequestElv(ELV value) {
        return new JAXBElement<ELV>(_BalanceCheckRequestElv_QNAME, ELV.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "fraudOffset", scope = BalanceCheckRequest.class)
    public JAXBElement<Integer> createBalanceCheckRequestFraudOffset(Integer value) {
        return new JAXBElement<Integer>(_PaymentRequest3DFraudOffset_QNAME, Integer.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForexQuote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "dccQuote", scope = BalanceCheckRequest.class)
    public JAXBElement<ForexQuote> createBalanceCheckRequestDccQuote(ForexQuote value) {
        return new JAXBElement<ForexQuote>(_PaymentRequest3DDccQuote_QNAME, ForexQuote.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "orderReference", scope = BalanceCheckRequest.class)
    public JAXBElement<String> createBalanceCheckRequestOrderReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DOrderReference_QNAME, String.class, BalanceCheckRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "ownerName", scope = BankAccount.class)
    public JAXBElement<String> createBankAccountOwnerName(String value) {
        return new JAXBElement<String>(_BankAccountOwnerName_QNAME, String.class, BankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "iban", scope = BankAccount.class)
    public JAXBElement<String> createBankAccountIban(String value) {
        return new JAXBElement<String>(_BankAccountIban_QNAME, String.class, BankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bankLocationId", scope = BankAccount.class)
    public JAXBElement<String> createBankAccountBankLocationId(String value) {
        return new JAXBElement<String>(_ELVBankLocationId_QNAME, String.class, BankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bic", scope = BankAccount.class)
    public JAXBElement<String> createBankAccountBic(String value) {
        return new JAXBElement<String>(_BankAccountBic_QNAME, String.class, BankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bankName", scope = BankAccount.class)
    public JAXBElement<String> createBankAccountBankName(String value) {
        return new JAXBElement<String>(_ELVBankName_QNAME, String.class, BankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bankAccountNumber", scope = BankAccount.class)
    public JAXBElement<String> createBankAccountBankAccountNumber(String value) {
        return new JAXBElement<String>(_ELVBankAccountNumber_QNAME, String.class, BankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "countryCode", scope = BankAccount.class)
    public JAXBElement<String> createBankAccountCountryCode(String value) {
        return new JAXBElement<String>(_BankAccountCountryCode_QNAME, String.class, BankAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.services.adyen.com", name = "type", scope = ServiceException.class)
    public JAXBElement<Type> createServiceExceptionType(Type value) {
        return new JAXBElement<Type>(_ServiceExceptionType_QNAME, Type.class, ServiceException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Error }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.services.adyen.com", name = "error", scope = ServiceException.class)
    public JAXBElement<Error> createServiceExceptionError(Error value) {
        return new JAXBElement<Error>(_ServiceExceptionError_QNAME, Error.class, ServiceException.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "response", scope = ModificationResult.class)
    public JAXBElement<String> createModificationResultResponse(String value) {
        return new JAXBElement<String>(_ModificationResultResponse_QNAME, String.class, ModificationResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "pspReference", scope = ModificationResult.class)
    public JAXBElement<String> createModificationResultPspReference(String value) {
        return new JAXBElement<String>(_ModificationResultPspReference_QNAME, String.class, ModificationResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalData", scope = ModificationResult.class)
    public JAXBElement<AnyType2AnyTypeMap> createModificationResultAdditionalData(AnyType2AnyTypeMap value) {
        return new JAXBElement<AnyType2AnyTypeMap>(_PaymentRequest3DAdditionalData_QNAME, AnyType2AnyTypeMap.class, ModificationResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "startYear", scope = Card.class)
    public JAXBElement<String> createCardStartYear(String value) {
        return new JAXBElement<String>(_CardStartYear_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "issueNumber", scope = Card.class)
    public JAXBElement<String> createCardIssueNumber(String value) {
        return new JAXBElement<String>(_CardIssueNumber_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "startMonth", scope = Card.class)
    public JAXBElement<String> createCardStartMonth(String value) {
        return new JAXBElement<String>(_CardStartMonth_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "billingAddress", scope = Card.class)
    public JAXBElement<Address> createCardBillingAddress(Address value) {
        return new JAXBElement<Address>(_CardBillingAddress_QNAME, Address.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "cvc", scope = Card.class)
    public JAXBElement<String> createCardCvc(String value) {
        return new JAXBElement<String>(_CardCvc_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "brand", scope = Card.class)
    public JAXBElement<String> createCardBrand(String value) {
        return new JAXBElement<String>(_CardBrand_QNAME, String.class, Card.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "originalReference", scope = FundTransferRequest.class)
    public JAXBElement<String> createFundTransferRequestOriginalReference(String value) {
        return new JAXBElement<String>(_FundTransferRequestOriginalReference_QNAME, String.class, FundTransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "reference", scope = FundTransferRequest.class)
    public JAXBElement<String> createFundTransferRequestReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DReference_QNAME, String.class, FundTransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperStatement", scope = FundTransferRequest.class)
    public JAXBElement<String> createFundTransferRequestShopperStatement(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperStatement_QNAME, String.class, FundTransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "merchantAccount", scope = FundTransferRequest.class)
    public JAXBElement<String> createFundTransferRequestMerchantAccount(String value) {
        return new JAXBElement<String>(_PaymentRequest3DMerchantAccount_QNAME, String.class, FundTransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "authorisationCode", scope = FundTransferRequest.class)
    public JAXBElement<String> createFundTransferRequestAuthorisationCode(String value) {
        return new JAXBElement<String>(_FundTransferRequestAuthorisationCode_QNAME, String.class, FundTransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperEmail", scope = FundTransferRequest.class)
    public JAXBElement<String> createFundTransferRequestShopperEmail(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperEmail_QNAME, String.class, FundTransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "modificationAmount", scope = FundTransferRequest.class)
    public JAXBElement<Amount> createFundTransferRequestModificationAmount(Amount value) {
        return new JAXBElement<Amount>(_FundTransferRequestModificationAmount_QNAME, Amount.class, FundTransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalData", scope = FundTransferRequest.class)
    public JAXBElement<AnyType2AnyTypeMap> createFundTransferRequestAdditionalData(AnyType2AnyTypeMap value) {
        return new JAXBElement<AnyType2AnyTypeMap>(_PaymentRequest3DAdditionalData_QNAME, AnyType2AnyTypeMap.class, FundTransferRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "refusalReason", scope = DirectDebitResponse.class)
    public JAXBElement<String> createDirectDebitResponseRefusalReason(String value) {
        return new JAXBElement<String>(_DirectDebitResponseRefusalReason_QNAME, String.class, DirectDebitResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "pspReference", scope = DirectDebitResponse.class)
    public JAXBElement<String> createDirectDebitResponsePspReference(String value) {
        return new JAXBElement<String>(_ModificationResultPspReference_QNAME, String.class, DirectDebitResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FraudResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "fraudResult", scope = DirectDebitResponse.class)
    public JAXBElement<FraudResult> createDirectDebitResponseFraudResult(FraudResult value) {
        return new JAXBElement<FraudResult>(_DirectDebitResponseFraudResult_QNAME, FraudResult.class, DirectDebitResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalData", scope = DirectDebitResponse.class)
    public JAXBElement<AnyType2AnyTypeMap> createDirectDebitResponseAdditionalData(AnyType2AnyTypeMap value) {
        return new JAXBElement<AnyType2AnyTypeMap>(_PaymentRequest3DAdditionalData_QNAME, AnyType2AnyTypeMap.class, DirectDebitResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "resultCode", scope = DirectDebitResponse.class)
    public JAXBElement<String> createDirectDebitResponseResultCode(String value) {
        return new JAXBElement<String>(_DirectDebitResponseResultCode_QNAME, String.class, DirectDebitResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperInteraction", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestShopperInteraction(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperInteraction_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "sessionId", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestSessionId(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSessionId_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "selectedBrand", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestSelectedBrand(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSelectedBrand_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalAmount", scope = PaymentRequest.class)
    public JAXBElement<Amount> createPaymentRequestAdditionalAmount(Amount value) {
        return new JAXBElement<Amount>(_PaymentRequest3DAdditionalAmount_QNAME, Amount.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BrowserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "browserInfo", scope = PaymentRequest.class)
    public JAXBElement<BrowserInfo> createPaymentRequestBrowserInfo(BrowserInfo value) {
        return new JAXBElement<BrowserInfo>(_PaymentRequest3DBrowserInfo_QNAME, BrowserInfo.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "amount", scope = PaymentRequest.class)
    public JAXBElement<Amount> createPaymentRequestAmount(Amount value) {
        return new JAXBElement<Amount>(_PaymentRequest3DAmount_QNAME, Amount.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "deliveryAddress", scope = PaymentRequest.class)
    public JAXBElement<Address> createPaymentRequestDeliveryAddress(Address value) {
        return new JAXBElement<Address>(_PaymentRequest3DDeliveryAddress_QNAME, Address.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bankAccount", scope = PaymentRequest.class)
    public JAXBElement<BankAccount> createPaymentRequestBankAccount(BankAccount value) {
        return new JAXBElement<BankAccount>(_BalanceCheckRequestBankAccount_QNAME, BankAccount.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Recurring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "recurring", scope = PaymentRequest.class)
    public JAXBElement<Recurring> createPaymentRequestRecurring(Recurring value) {
        return new JAXBElement<Recurring>(_PaymentRequest3DRecurring_QNAME, Recurring.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ThreeDSecureData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "mpiData", scope = PaymentRequest.class)
    public JAXBElement<ThreeDSecureData> createPaymentRequestMpiData(ThreeDSecureData value) {
        return new JAXBElement<ThreeDSecureData>(_BalanceCheckRequestMpiData_QNAME, ThreeDSecureData.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "selectedRecurringDetailReference", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestSelectedRecurringDetailReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSelectedRecurringDetailReference_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Card }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "card", scope = PaymentRequest.class)
    public JAXBElement<Card> createPaymentRequestCard(Card value) {
        return new JAXBElement<Card>(_BalanceCheckRequestCard_QNAME, Card.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperReference", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestShopperReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperReference_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperIP", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestShopperIP(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperIP_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "reference", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DReference_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperStatement", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestShopperStatement(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperStatement_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "merchantAccount", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestMerchantAccount(String value) {
        return new JAXBElement<String>(_PaymentRequest3DMerchantAccount_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperEmail", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestShopperEmail(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperEmail_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalData", scope = PaymentRequest.class)
    public JAXBElement<AnyType2AnyTypeMap> createPaymentRequestAdditionalData(AnyType2AnyTypeMap value) {
        return new JAXBElement<AnyType2AnyTypeMap>(_PaymentRequest3DAdditionalData_QNAME, AnyType2AnyTypeMap.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ELV }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "elv", scope = PaymentRequest.class)
    public JAXBElement<ELV> createPaymentRequestElv(ELV value) {
        return new JAXBElement<ELV>(_BalanceCheckRequestElv_QNAME, ELV.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "fraudOffset", scope = PaymentRequest.class)
    public JAXBElement<Integer> createPaymentRequestFraudOffset(Integer value) {
        return new JAXBElement<Integer>(_PaymentRequest3DFraudOffset_QNAME, Integer.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForexQuote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "dccQuote", scope = PaymentRequest.class)
    public JAXBElement<ForexQuote> createPaymentRequestDccQuote(ForexQuote value) {
        return new JAXBElement<ForexQuote>(_PaymentRequest3DDccQuote_QNAME, ForexQuote.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "orderReference", scope = PaymentRequest.class)
    public JAXBElement<String> createPaymentRequestOrderReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DOrderReference_QNAME, String.class, PaymentRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "originalReference", scope = ModificationRequest.class)
    public JAXBElement<String> createModificationRequestOriginalReference(String value) {
        return new JAXBElement<String>(_FundTransferRequestOriginalReference_QNAME, String.class, ModificationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "merchantAccount", scope = ModificationRequest.class)
    public JAXBElement<String> createModificationRequestMerchantAccount(String value) {
        return new JAXBElement<String>(_PaymentRequest3DMerchantAccount_QNAME, String.class, ModificationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "authorisationCode", scope = ModificationRequest.class)
    public JAXBElement<String> createModificationRequestAuthorisationCode(String value) {
        return new JAXBElement<String>(_FundTransferRequestAuthorisationCode_QNAME, String.class, ModificationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "modificationAmount", scope = ModificationRequest.class)
    public JAXBElement<Amount> createModificationRequestModificationAmount(Amount value) {
        return new JAXBElement<Amount>(_FundTransferRequestModificationAmount_QNAME, Amount.class, ModificationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalData", scope = ModificationRequest.class)
    public JAXBElement<AnyType2AnyTypeMap> createModificationRequestAdditionalData(AnyType2AnyTypeMap value) {
        return new JAXBElement<AnyType2AnyTypeMap>(_PaymentRequest3DAdditionalData_QNAME, AnyType2AnyTypeMap.class, ModificationRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperInteraction", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestShopperInteraction(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperInteraction_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "sessionId", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestSessionId(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSessionId_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "selectedBrand", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestSelectedBrand(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSelectedBrand_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalAmount", scope = DirectDebitRequest.class)
    public JAXBElement<Amount> createDirectDebitRequestAdditionalAmount(Amount value) {
        return new JAXBElement<Amount>(_PaymentRequest3DAdditionalAmount_QNAME, Amount.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BrowserInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "browserInfo", scope = DirectDebitRequest.class)
    public JAXBElement<BrowserInfo> createDirectDebitRequestBrowserInfo(BrowserInfo value) {
        return new JAXBElement<BrowserInfo>(_PaymentRequest3DBrowserInfo_QNAME, BrowserInfo.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "amount", scope = DirectDebitRequest.class)
    public JAXBElement<Amount> createDirectDebitRequestAmount(Amount value) {
        return new JAXBElement<Amount>(_PaymentRequest3DAmount_QNAME, Amount.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Address }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "deliveryAddress", scope = DirectDebitRequest.class)
    public JAXBElement<Address> createDirectDebitRequestDeliveryAddress(Address value) {
        return new JAXBElement<Address>(_PaymentRequest3DDeliveryAddress_QNAME, Address.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "bankAccount", scope = DirectDebitRequest.class)
    public JAXBElement<BankAccount> createDirectDebitRequestBankAccount(BankAccount value) {
        return new JAXBElement<BankAccount>(_BalanceCheckRequestBankAccount_QNAME, BankAccount.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Recurring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "recurring", scope = DirectDebitRequest.class)
    public JAXBElement<Recurring> createDirectDebitRequestRecurring(Recurring value) {
        return new JAXBElement<Recurring>(_PaymentRequest3DRecurring_QNAME, Recurring.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "selectedRecurringDetailReference", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestSelectedRecurringDetailReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DSelectedRecurringDetailReference_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperReference", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestShopperReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperReference_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperIP", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestShopperIP(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperIP_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "reference", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DReference_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperStatement", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestShopperStatement(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperStatement_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "merchantAccount", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestMerchantAccount(String value) {
        return new JAXBElement<String>(_PaymentRequest3DMerchantAccount_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "shopperEmail", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestShopperEmail(String value) {
        return new JAXBElement<String>(_PaymentRequest3DShopperEmail_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalData", scope = DirectDebitRequest.class)
    public JAXBElement<AnyType2AnyTypeMap> createDirectDebitRequestAdditionalData(AnyType2AnyTypeMap value) {
        return new JAXBElement<AnyType2AnyTypeMap>(_PaymentRequest3DAdditionalData_QNAME, AnyType2AnyTypeMap.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "fraudOffset", scope = DirectDebitRequest.class)
    public JAXBElement<Integer> createDirectDebitRequestFraudOffset(Integer value) {
        return new JAXBElement<Integer>(_PaymentRequest3DFraudOffset_QNAME, Integer.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForexQuote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "dccQuote", scope = DirectDebitRequest.class)
    public JAXBElement<ForexQuote> createDirectDebitRequestDccQuote(ForexQuote value) {
        return new JAXBElement<ForexQuote>(_PaymentRequest3DDccQuote_QNAME, ForexQuote.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "orderReference", scope = DirectDebitRequest.class)
    public JAXBElement<String> createDirectDebitRequestOrderReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DOrderReference_QNAME, String.class, DirectDebitRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "response", scope = FundTransferResult.class)
    public JAXBElement<String> createFundTransferResultResponse(String value) {
        return new JAXBElement<String>(_ModificationResultResponse_QNAME, String.class, FundTransferResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "pspReference", scope = FundTransferResult.class)
    public JAXBElement<String> createFundTransferResultPspReference(String value) {
        return new JAXBElement<String>(_ModificationResultPspReference_QNAME, String.class, FundTransferResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalData", scope = FundTransferResult.class)
    public JAXBElement<AnyType2AnyTypeMap> createFundTransferResultAdditionalData(AnyType2AnyTypeMap value) {
        return new JAXBElement<AnyType2AnyTypeMap>(_PaymentRequest3DAdditionalData_QNAME, AnyType2AnyTypeMap.class, FundTransferResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BalanceCheckResponseCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "responseCode", scope = BalanceCheckResult.class)
    public JAXBElement<BalanceCheckResponseCode> createBalanceCheckResultResponseCode(BalanceCheckResponseCode value) {
        return new JAXBElement<BalanceCheckResponseCode>(_BalanceCheckResultResponseCode_QNAME, BalanceCheckResponseCode.class, BalanceCheckResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "pspReference", scope = BalanceCheckResult.class)
    public JAXBElement<String> createBalanceCheckResultPspReference(String value) {
        return new JAXBElement<String>(_ModificationResultPspReference_QNAME, String.class, BalanceCheckResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "currentBalance", scope = BalanceCheckResult.class)
    public JAXBElement<Amount> createBalanceCheckResultCurrentBalance(Amount value) {
        return new JAXBElement<Amount>(_BalanceCheckResultCurrentBalance_QNAME, Amount.class, BalanceCheckResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "paRequest", scope = PaymentResult.class)
    public JAXBElement<String> createPaymentResultPaRequest(String value) {
        return new JAXBElement<String>(_PaymentResultPaRequest_QNAME, String.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "refusalReason", scope = PaymentResult.class)
    public JAXBElement<String> createPaymentResultRefusalReason(String value) {
        return new JAXBElement<String>(_DirectDebitResponseRefusalReason_QNAME, String.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "md", scope = PaymentResult.class)
    public JAXBElement<String> createPaymentResultMd(String value) {
        return new JAXBElement<String>(_PaymentRequest3DMd_QNAME, String.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "pspReference", scope = PaymentResult.class)
    public JAXBElement<String> createPaymentResultPspReference(String value) {
        return new JAXBElement<String>(_ModificationResultPspReference_QNAME, String.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "authCode", scope = PaymentResult.class)
    public JAXBElement<String> createPaymentResultAuthCode(String value) {
        return new JAXBElement<String>(_PaymentResultAuthCode_QNAME, String.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "dccSignature", scope = PaymentResult.class)
    public JAXBElement<String> createPaymentResultDccSignature(String value) {
        return new JAXBElement<String>(_PaymentResultDccSignature_QNAME, String.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "dccAmount", scope = PaymentResult.class)
    public JAXBElement<Amount> createPaymentResultDccAmount(Amount value) {
        return new JAXBElement<Amount>(_PaymentResultDccAmount_QNAME, Amount.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "issuerUrl", scope = PaymentResult.class)
    public JAXBElement<String> createPaymentResultIssuerUrl(String value) {
        return new JAXBElement<String>(_PaymentResultIssuerUrl_QNAME, String.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FraudResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "fraudResult", scope = PaymentResult.class)
    public JAXBElement<FraudResult> createPaymentResultFraudResult(FraudResult value) {
        return new JAXBElement<FraudResult>(_DirectDebitResponseFraudResult_QNAME, FraudResult.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyType2AnyTypeMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "additionalData", scope = PaymentResult.class)
    public JAXBElement<AnyType2AnyTypeMap> createPaymentResultAdditionalData(AnyType2AnyTypeMap value) {
        return new JAXBElement<AnyType2AnyTypeMap>(_PaymentRequest3DAdditionalData_QNAME, AnyType2AnyTypeMap.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "resultCode", scope = PaymentResult.class)
    public JAXBElement<String> createPaymentResultResultCode(String value) {
        return new JAXBElement<String>(_DirectDebitResponseResultCode_QNAME, String.class, PaymentResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "interbank", scope = ForexQuote.class)
    public JAXBElement<Amount> createForexQuoteInterbank(Amount value) {
        return new JAXBElement<Amount>(_ForexQuoteInterbank_QNAME, Amount.class, ForexQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "source", scope = ForexQuote.class)
    public JAXBElement<String> createForexQuoteSource(String value) {
        return new JAXBElement<String>(_ForexQuoteSource_QNAME, String.class, ForexQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "sell", scope = ForexQuote.class)
    public JAXBElement<Amount> createForexQuoteSell(Amount value) {
        return new JAXBElement<Amount>(_ForexQuoteSell_QNAME, Amount.class, ForexQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "buy", scope = ForexQuote.class)
    public JAXBElement<Amount> createForexQuoteBuy(Amount value) {
        return new JAXBElement<Amount>(_ForexQuoteBuy_QNAME, Amount.class, ForexQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Amount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "baseAmount", scope = ForexQuote.class)
    public JAXBElement<Amount> createForexQuoteBaseAmount(Amount value) {
        return new JAXBElement<Amount>(_ForexQuoteBaseAmount_QNAME, Amount.class, ForexQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "signature", scope = ForexQuote.class)
    public JAXBElement<String> createForexQuoteSignature(String value) {
        return new JAXBElement<String>(_ForexQuoteSignature_QNAME, String.class, ForexQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "reference", scope = ForexQuote.class)
    public JAXBElement<String> createForexQuoteReference(String value) {
        return new JAXBElement<String>(_PaymentRequest3DReference_QNAME, String.class, ForexQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "type", scope = ForexQuote.class)
    public JAXBElement<String> createForexQuoteType(String value) {
        return new JAXBElement<String>(_ForexQuoteType_QNAME, String.class, ForexQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "accountType", scope = ForexQuote.class)
    public JAXBElement<String> createForexQuoteAccountType(String value) {
        return new JAXBElement<String>(_ForexQuoteAccountType_QNAME, String.class, ForexQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "account", scope = ForexQuote.class)
    public JAXBElement<String> createForexQuoteAccount(String value) {
        return new JAXBElement<String>(_ForexQuoteAccount_QNAME, String.class, ForexQuote.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.services.adyen.com", name = "stateOrProvince", scope = Address.class)
    public JAXBElement<String> createAddressStateOrProvince(String value) {
        return new JAXBElement<String>(_AddressStateOrProvince_QNAME, String.class, Address.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.services.adyen.com", name = "country", scope = Address.class)
    public JAXBElement<String> createAddressCountry(String value) {
        return new JAXBElement<String>(_AddressCountry_QNAME, String.class, Address.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.services.adyen.com", name = "city", scope = Address.class)
    public JAXBElement<String> createAddressCity(String value) {
        return new JAXBElement<String>(_AddressCity_QNAME, String.class, Address.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.services.adyen.com", name = "houseNumberOrName", scope = Address.class)
    public JAXBElement<String> createAddressHouseNumberOrName(String value) {
        return new JAXBElement<String>(_AddressHouseNumberOrName_QNAME, String.class, Address.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.services.adyen.com", name = "postalCode", scope = Address.class)
    public JAXBElement<String> createAddressPostalCode(String value) {
        return new JAXBElement<String>(_AddressPostalCode_QNAME, String.class, Address.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://common.services.adyen.com", name = "street", scope = Address.class)
    public JAXBElement<String> createAddressStreet(String value) {
        return new JAXBElement<String>(_AddressStreet_QNAME, String.class, Address.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "contract", scope = Recurring.class)
    public JAXBElement<String> createRecurringContract(String value) {
        return new JAXBElement<String>(_RecurringContract_QNAME, String.class, Recurring.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "recurringDetailName", scope = Recurring.class)
    public JAXBElement<String> createRecurringRecurringDetailName(String value) {
        return new JAXBElement<String>(_RecurringRecurringDetailName_QNAME, String.class, Recurring.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "authenticationResponse", scope = ThreeDSecureData.class)
    public JAXBElement<String> createThreeDSecureDataAuthenticationResponse(String value) {
        return new JAXBElement<String>(_ThreeDSecureDataAuthenticationResponse_QNAME, String.class, ThreeDSecureData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "eci", scope = ThreeDSecureData.class)
    public JAXBElement<String> createThreeDSecureDataEci(String value) {
        return new JAXBElement<String>(_ThreeDSecureDataEci_QNAME, String.class, ThreeDSecureData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "cavvAlgorithm", scope = ThreeDSecureData.class)
    public JAXBElement<String> createThreeDSecureDataCavvAlgorithm(String value) {
        return new JAXBElement<String>(_ThreeDSecureDataCavvAlgorithm_QNAME, String.class, ThreeDSecureData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "directoryResponse", scope = ThreeDSecureData.class)
    public JAXBElement<String> createThreeDSecureDataDirectoryResponse(String value) {
        return new JAXBElement<String>(_ThreeDSecureDataDirectoryResponse_QNAME, String.class, ThreeDSecureData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "cavv", scope = ThreeDSecureData.class)
    public JAXBElement<byte[]> createThreeDSecureDataCavv(byte[] value) {
        return new JAXBElement<byte[]>(_ThreeDSecureDataCavv_QNAME, byte[].class, ThreeDSecureData.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://payment.services.adyen.com", name = "xid", scope = ThreeDSecureData.class)
    public JAXBElement<byte[]> createThreeDSecureDataXid(byte[] value) {
        return new JAXBElement<byte[]>(_ThreeDSecureDataXid_QNAME, byte[].class, ThreeDSecureData.class, ((byte[]) value));
    }

}
