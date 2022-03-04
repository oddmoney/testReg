package testReg.kicc;

public class SendKiccVo {

	private String headerInitial;       // 1. Header Initial ('JEJUAIR' 고정 7자리)
	private String comment;             // 2. PNR Alpha (30자리 고정) 
	private String transactionDateTime; // 3. 거래일자 (yyMMdd) (6자리 고정)
	private String sequenceNo;          // 4. 전문일련번호 생성(6자리 고정)
	private String serviceTypeCode;     // 5. 카드, 현금영수증에 따른 Service Type Code (4자리 고정)
	private String reqClassCode;        // 6. 카드, 현금영수증에 따른 Request Class Code (2자리 고정)
	private String terminalId;          // 7. VAN 에서 부여한 단말기 번호
	private String wcc;                 // 8. @ (1자리 고정) (Key IN:'@', Swipe: 'A')
	private String creditCardNum;       // 9. 카드이면서 wcc 가 @ 이면 '카드번호=유효기간', 아니면 '카드번호' (고정 37자리, 뒤 ' ' 으로 패딩)
	private String extPayment;          // 10. 할부기간 (고정 2자리)
	private String amount;              // 11. 금액 (소수점 제거, 금액 앞 0 으로 패딩) (고정 10자리)
	private String serviceCharge;       // 12. 봉사료 (소수점 제거, 금액 앞 0 으로 패딩) (고정 10자리)
	private String tax;                 // 13. 세금 (소수점 제거, 금액 앞 0 으로 패딩) (고정 10자리)
	private String oriApprovalDate;     // 14. 취소인 경우 원승인일자 (yyMMdd) (6자리 고정, 취소 아닌 경우 ' ' 으로 패딩)
	private String oriApprovalNum;      // 15. 취소인 경우 원승인번호 (12자리 고정, 뒤 ' ' 으로 패딩, 취소 아닌 경우 ' ' 으로 패딩)
	private String identNumFlag;        // 16. 인증구분 (JJ:개인, BB:사업자) (2자리 고정, 취소 또는 값이 없는 경우 ' ' 으로 패딩)
	private String identNum;            // 17. 주민번호/사업자번호 (13자리 고정, 주민번호 뒤 7자리인 경우 000000+7자리, 주민번호 앞 6자리인 경우 6자리+0000000, 사업자번호 10자리인 경우 10자리+' ' 패딩, 취소 또는 입력안된 경우 ' ' 으로 패딩)
	private String cardPw;              // 18. 카드비밀번호 (4자리 고정, 2자리 입력된 경우 2자리+' ' 패딩, 취소 또는 입력안된 경우 ' ' 으로 패딩)
	private String filler;              // 19. Filler (60자리 고정, ' '  패딩)

	// 추가정보
	private String expiryDate;          // 유효기간

	
	public String getHeaderInitial() {
		return headerInitial;
	}
	public void setHeaderInitial(String headerInitial) {
		this.headerInitial = headerInitial;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public String getSequenceNo() {
		return sequenceNo;
	}
	public void setSequenceNo(String sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	public String getServiceTypeCode() {
		return serviceTypeCode;
	}
	public void setServiceTypeCode(String serviceTypeCode) {
		this.serviceTypeCode = serviceTypeCode;
	}
	public String getReqClassCode() {
		return reqClassCode;
	}
	public void setReqClassCode(String reqClassCode) {
		this.reqClassCode = reqClassCode;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getWcc() {
		return wcc;
	}
	public void setWcc(String wcc) {
		this.wcc = wcc;
	}
	public String getCreditCardNum() {
		return creditCardNum;
	}
	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
	}
	public String getExtPayment() {
		return extPayment;
	}
	public void setExtPayment(String extPayment) {
		this.extPayment = extPayment;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getOriApprovalDate() {
		return oriApprovalDate;
	}
	public void setOriApprovalDate(String oriApprovalDate) {
		this.oriApprovalDate = oriApprovalDate;
	}
	public String getOriApprovalNum() {
		return oriApprovalNum;
	}
	public void setOriApprovalNum(String oriApprovalNum) {
		this.oriApprovalNum = oriApprovalNum;
	}
	public String getIdentNumFlag() {
		return identNumFlag;
	}
	public void setIdentNumFlag(String identNumFlag) {
		this.identNumFlag = identNumFlag;
	}
	public String getIdentNum() {
		return identNum;
	}
	public void setIdentNum(String identNum) {
		this.identNum = identNum;
	}
	public String getCardPw() {
		return cardPw;
	}
	public void setCardPw(String cardPw) {
		this.cardPw = cardPw;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
