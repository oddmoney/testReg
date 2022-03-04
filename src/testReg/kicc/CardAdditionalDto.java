package testReg.kicc;

public class CardAdditionalDto {
	private String readyApprovalNo;		// 국내카드 수기특약인 경우 VAN 비율에 따른 PG 사를 결정하기 위해  미리 생성한 승인번호
	private String cardNo;				// 수기특약 인 경우 카드번호 (마스킹되지 않은 카드번호)
	private String expiryDate;			// 수기특약 인 경우 SkyPay 로부터 전달받은 유효기간
	private String currencyNo;			// 통화구분 1: 원화 2: 달러 (달러승인 없음), 5: 해외카드 취소인 경우
	private String currencyComment;		// 해외카드 취소인 경우 Currency Comment
	private String telNo;				// 수기특약 해외카드, 일본카드 인 경우 SkyPay 로부터 전달받은 연락처
	private String emailAddr;			// 수기특약 해외카드, 일본카드 인 경우 SkyPay 로부터 전달받은 이메일
	private String cvv;					// 수기특약 해외카드, 일본카드 인 경우 SkyPay 로부터 전달받은 CVV
	private String juminno;				// 수기특약 ARS 인 경우 SkyPay 로부터 전달받은 주민번호(yyMMdd) 또는 사업자번호 10자리
	private String cardpswd;			// 수기특약 ARS 인 경우 SkyPay 로부터 전달받은 카드비밀번호 앞 2자리
	private String orgAprvlDt;			// 원승인일시 (yyMMdd) - 취소 시
	private String orgAprvlNo;			// 원승인번호 - 취소 시
	private String vnCont;				// VAN 추가정보
	public String getReadyApprovalNo() {
		return readyApprovalNo;
	}
	public void setReadyApprovalNo(String readyApprovalNo) {
		this.readyApprovalNo = readyApprovalNo;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCurrencyNo() {
		return currencyNo;
	}
	public void setCurrencyNo(String currencyNo) {
		this.currencyNo = currencyNo;
	}
	public String getCurrencyComment() {
		return currencyComment;
	}
	public void setCurrencyComment(String currencyComment) {
		this.currencyComment = currencyComment;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getJuminno() {
		return juminno;
	}
	public void setJuminno(String juminno) {
		this.juminno = juminno;
	}
	public String getCardpswd() {
		return cardpswd;
	}
	public void setCardpswd(String cardpswd) {
		this.cardpswd = cardpswd;
	}
	public String getOrgAprvlDt() {
		return orgAprvlDt;
	}
	public void setOrgAprvlDt(String orgAprvlDt) {
		this.orgAprvlDt = orgAprvlDt;
	}
	public String getOrgAprvlNo() {
		return orgAprvlNo;
	}
	public void setOrgAprvlNo(String orgAprvlNo) {
		this.orgAprvlNo = orgAprvlNo;
	}
	public String getVnCont() {
		return vnCont;
	}
	public void setVnCont(String vnCont) {
		this.vnCont = vnCont;
	}
	
	@Override
	public String toString() {
		return "CardAdditionalDto [readyApprovalNo=" + readyApprovalNo + ", cardNo=" + cardNo + ", expiryDate="
				+ expiryDate + ", currencyNo=" + currencyNo + ", currencyComment=" + currencyComment + ", telNo="
				+ telNo + ", emailAddr=" + emailAddr + ", cvv=" + cvv + ", juminno=" + juminno + ", cardpswd="
				+ cardpswd + ", orgAprvlDt=" + orgAprvlDt + ", orgAprvlNo=" + orgAprvlNo + ", vnCont=" + vnCont + "]";
	}
	
}
