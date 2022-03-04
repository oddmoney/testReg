package testReg.kicc;

/*
 * KICC 전문 Entity
 */
public class EntityKiccVo {
	
	/* 전문 구성 항목 */
    private String headerFixCd;		// Header Initial 	(요청/응답 사용)
    private String comment;			// 가맹점 Return Data	(요청/응답 사용)
    private String dealDt;			// 거래일자			(요청/응답 사용)
    private String msgSeqNo;		// 전문 일련번호			(요청/응답 사용)
    private String msgReqCd;		// 전문 요청코드			(요청/응답 사용)
    private String msgDivCd;		// 전문 구분코드			(요청/응답 사용)
    private String terminalId;		// 단말기 고유번호		(요청/응답 사용)
    private String respCd;			// 응답코드			(    응답 사용)
    private String keyInDivCd;		// KeyIn구분코드		(요청 사용)
    private String refNoData;		// 카드번호-유효기간		(요청 사용)
    private String installment;		// 할부기간			(요청 사용)
    private String aprvlAmt;		// 승인금액			(요청 사용)
    private String serviceAmt;		// 봉사료금액			(요청 사용)
    private String taxAmt;			// TAX금액			(요청 사용)
    private String orgAprvlDt;		// 원승인일자(취소 시)	(요청 사용)
    private String orgAprvlNo;		// 원승인번호(취소 시)	(요청 사용)
    private String identNumFlag;	// 인증구분			(요청 사용)
    private String identNum;		// 주민번호/사업자번호	(요청 사용)
    private String cardPswd;		// 카드비밀번호			(요청 사용)
    private String aprvlNo;			// 승인번호			(    응답 사용)
    private String mid;				// 가맹점 번호			(    응답 사용)
    private String cardNm;			// 카드명				(    응답 사용)
    private String issueCorpCd;		// 발급사코드			(    응답 사용)
    private String issueCorpNm;		// 발급사명			(    응답 사용)
    private String purchCorpCd;		// 매입사코드			(    응답 사용)
    private String purchCorpNm;		// 매입사명			(    응답 사용)
    private String cardPrefixCd;	// Card Prefix Code	(    응답 사용)
    private String space;			// Space			(요청 사용)
    private String filler;			// Filler			(    응답 사용)
    private String cr;				// CR				(요청/응답 사용)
    
    
    private String statusCd;

	public String getHeaderFixCd() {
		return headerFixCd;
	}
	public void setHeaderFixCd(String headerFixCd) {
		this.headerFixCd = headerFixCd;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDealDt() {
		return dealDt;
	}
	public void setDealDt(String dealDt) {
		this.dealDt = dealDt;
	}
	public String getMsgSeqNo() {
		return msgSeqNo;
	}
	public void setMsgSeqNo(String msgSeqNo) {
		this.msgSeqNo = msgSeqNo;
	}
	public String getMsgReqCd() {
		return msgReqCd;
	}
	public void setMsgReqCd(String msgReqCd) {
		this.msgReqCd = msgReqCd;
	}
	public String getMsgDivCd() {
		return msgDivCd;
	}
	public void setMsgDivCd(String msgDivCd) {
		this.msgDivCd = msgDivCd;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getRespCd() {
		return respCd;
	}
	public void setRespCd(String respCd) {
		this.respCd = respCd;
	}
	public String getKeyInDivCd() {
		return keyInDivCd;
	}
	public void setKeyInDivCd(String keyInDivCd) {
		this.keyInDivCd = keyInDivCd;
	}
	public String getRefNoData() {
		return refNoData;
	}
	public void setRefNoData(String refNoData) {
		this.refNoData = refNoData;
	}
	public String getInstallment() {
		return installment;
	}
	public void setInstallment(String installment) {
		this.installment = installment;
	}
	public String getAprvlAmt() {
		return aprvlAmt;
	}
	public void setAprvlAmt(String aprvlAmt) {
		this.aprvlAmt = aprvlAmt;
	}
	public String getServiceAmt() {
		return serviceAmt;
	}
	public void setServiceAmt(String serviceAmt) {
		this.serviceAmt = serviceAmt;
	}
	public String getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(String taxAmt) {
		this.taxAmt = taxAmt;
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
	public String getCardPswd() {
		return cardPswd;
	}
	public void setCardPswd(String cardPswd) {
		this.cardPswd = cardPswd;
	}
	public String getAprvlNo() {
		return aprvlNo;
	}
	public void setAprvlNo(String aprvlNo) {
		this.aprvlNo = aprvlNo;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getCardNm() {
		return cardNm;
	}
	public void setCardNm(String cardNm) {
		this.cardNm = cardNm;
	}
	public String getIssueCorpCd() {
		return issueCorpCd;
	}
	public void setIssueCorpCd(String issueCorpCd) {
		this.issueCorpCd = issueCorpCd;
	}
	public String getIssueCorpNm() {
		return issueCorpNm;
	}
	public void setIssueCorpNm(String issueCorpNm) {
		this.issueCorpNm = issueCorpNm;
	}
	public String getPurchCorpCd() {
		return purchCorpCd;
	}
	public void setPurchCorpCd(String purchCorpCd) {
		this.purchCorpCd = purchCorpCd;
	}
	public String getPurchCorpNm() {
		return purchCorpNm;
	}
	public void setPurchCorpNm(String purchCorpNm) {
		this.purchCorpNm = purchCorpNm;
	}
	public String getCardPrefixCd() {
		return cardPrefixCd;
	}
	public void setCardPrefixCd(String cardPrefixCd) {
		this.cardPrefixCd = cardPrefixCd;
	}
	public String getSpace() {
		return space;
	}
	public void setSpace(String space) {
		this.space = space;
	}
	public String getFiller() {
		return filler;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}
	public String getCr() {
		return cr;
	}
	public void setCr(String cr) {
		this.cr = cr;
	}
	public String getStatusCd() {
		return statusCd;
	}
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
	@Override
	public String toString() {
		return "EntityKiccVo [headerFixCd=" + headerFixCd + ", comment=" + comment + ", dealDt=" + dealDt
				+ ", msgSeqNo=" + msgSeqNo + ", msgReqCd=" + msgReqCd + ", msgDivCd=" + msgDivCd + ", terminalId="
				+ terminalId + ", respCd=" + respCd + ", keyInDivCd=" + keyInDivCd + ", refNoData=" + refNoData
				+ ", installment=" + installment + ", aprvlAmt=" + aprvlAmt + ", serviceAmt=" + serviceAmt + ", taxAmt="
				+ taxAmt + ", orgAprvlDt=" + orgAprvlDt + ", orgAprvlNo=" + orgAprvlNo + ", identNumFlag="
				+ identNumFlag + ", identNum=" + identNum + ", cardPswd=" + cardPswd + ", aprvlNo=" + aprvlNo + ", mid="
				+ mid + ", cardNm=" + cardNm + ", issueCorpCd=" + issueCorpCd + ", issueCorpNm=" + issueCorpNm
				+ ", purchCorpCd=" + purchCorpCd + ", purchCorpNm=" + purchCorpNm + ", cardPrefixCd=" + cardPrefixCd
				+ ", space=" + space + ", filler=" + filler + ", cr=" + cr + ", statusCd=" + statusCd + "]";
	}
  
	
}
