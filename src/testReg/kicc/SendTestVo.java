package testReg.kicc;

import testReg.testSocket.SocketUtils;

public class SendTestVo {
	
	private static final boolean IS_ESB = true; // NESB 통과 여부
	private static final boolean IS_LIVE = false; // 운영계 여부
	
	private static final String ORG_APRVL_DT = "211015"; // "210812";   // 원 승인일자 (취소 시 필수)
	private static final String ORG_APRVL_NO = "46667542"; // "04920864"; //원 승인번호 (취소 시 필수)			

	private static final boolean IS_CARD = true; // 카드여부 (현금영수증 : false) 
	
	private static final boolean CTI_AUTH_FLAG = true; // CTI 인증여부
	private static final String CTI_AUTH_PSWD = "10"; // CTI 인증 시 비밀번호 앞2자리
	private static final String CTI_AUTH_IDEN = "771217"; // CTI 인증 시 생년월일 6자리
	
	// 카드이면 '카드번호=유효기간'(yymm), 현금영수증인 경우 주민번호/전화번호/카드번호
	//private static final String CARD_NO = "7712171446824";
	//private static final String CARD_NO = "01089093587";
	//private static final String CARD_NO = "4111111111111111=2606";
	private static final String CARD_NO = "4221550010259785=2609";
	
	private static final String AMOUNT = "10000"; // 금액
	
	public static void main(String[] args) {
		//testKicc(); // 21.10.15 : 운영계 가능
		testKmps(); // 운영계 방화벽 막힘
	}
	
	private static void testKmps() {
		String host = null;
		String port = null;
		String mid = "10718540"; // 개발,운영 MID
		if (IS_ESB) {
			host = IS_LIVE ? "PRD-PRI-CESB-NLB-NW-3efea3bd7e6ba7a6.elb.ap-northeast-2.amazonaws.com"
					: "dev-cesb-nlb-nw-8cff77cb1c8b4d51.elb.ap-northeast-2.amazonaws.com";
			port = "8302";
		} else {
			host = IS_LIVE ? "177.200.3.1" : "177.200.3.151"; 
			port = "22071"; // KMPS PORT;
		}
		
		try {
			sendVan(mid, host, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testKicc() {
		String host = null;
		String port = null;
		String mid = "106424"; // 개발,운영 MID
		//String mid = "788888"; // 개발
		if (IS_ESB) {
			host = IS_LIVE ? "PRD-PRI-CESB-NLB-NW-3efea3bd7e6ba7a6.elb.ap-northeast-2.amazonaws.com"
					: "dev-cesb-nlb-nw-8cff77cb1c8b4d51.elb.ap-northeast-2.amazonaws.com";
			port = "8301";
		} else {
			host = IS_LIVE ? "203.209.3.6" : "203.209.3.11";
			port = "4021"; // KICC PORT;
		}

		try {
			sendVan(mid, host, port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static EntityKiccVo sendVan(String mid, String host, String port) throws Exception {
		String reqMsg = getApproveReqKiccMsg(getReqKiccVo(mid));
		
		System.out.println("###Req-Msg:::"+reqMsg);
		
		byte[] resByt = new SocketUtils().sendSocket(reqMsg.getBytes(), host, port);
		System.out.println("===========[sendSocket]resStr:::"+new String(resByt, EntityRange.KICC_RES_CHAR));
		
		EntityKiccVo resVo = new EntityKiccParse().getApproveResKiccVo(resByt);
		System.out.println("===========[PayKiccOfflineCard.approveProcessOffline]resVo:::"+resVo.toString());
		
		return resVo;
	}
	
	public static EntityKiccVo getReqKiccVo(String mid) throws Exception {
		String identNum = "";	// 주민번호(생년월일 + 뒤 7자리는 0 패딩)/사업자번호 (승인인 경우에만 사용)
		String cardPswd = "";	// 카드비밀번호 (승인인 경우에만 사용)
		String msgReqCd = "";	// 전문요청코드 CC(카드결제) 승인:0200, 취소:0420 / KK(현금영수증) 승인:0700, 취소:0720
		String msgDivCd = "";	// 전문구분코드 CC(카드결제) 단독승인(수기특약) : 10 / 인증+승인 : 20 / 취소 : 10
		String identNumFlag = "JJ";	// 개인:JJ/사업자구분:BB (승인인 경우에만 사용)
		
		boolean isCancel = ORG_APRVL_DT != null && ORG_APRVL_DT.length() > 0 && ORG_APRVL_NO != null && ORG_APRVL_NO.length() > 0;
		
		// 전문요청코드 CC(카드결제) 승인:0200, 취소:0420 / KK(현금영수증) 승인:0700, 취소:0720
		if (IS_CARD) {
			msgReqCd = isCancel ? "0420" : "0200";
			if (!isCancel && CTI_AUTH_FLAG) {
				identNum = CTI_AUTH_IDEN;
				cardPswd = CTI_AUTH_PSWD;
				msgDivCd = "20";
			} else {
				msgDivCd = "10";
			}
		} else {
			msgReqCd = isCancel ? "0720" : "0700";
			msgDivCd = "10";
		}

		EntityKiccVo vo = new EntityKiccVo();
		vo.setHeaderFixCd(	"JEJUAIR");				// 1. Header initial (고정값 7자리)
        vo.setComment(		"TSTPNR");		// 2. PNR Alpha (30자리 고정) 
        vo.setDealDt(		DateUtils.getCurrentDate("yyMMdd"));	// 3. 거래일자 6자리 (yyMMdd)
        vo.setMsgSeqNo(		"123456");	// 4. 전문일련번호 생성(승인번호 6자리)
        vo.setMsgReqCd(		msgReqCd);				// 5. 전문요청코드 CC(카드결제) 승인:0200, 취소:0420 / KK(현금영수증) 승인:0700, 취소:0720
        vo.setMsgDivCd(		msgDivCd);					// 6. 전문구분코드 CC/KK(카드결제/현금영수증) 승인:10, 취소:10
        vo.setTerminalId(	mid);	// 7. VAN 에서 부여한 단말기 번호 (8자리 고정, ' '으로 패딩)
        vo.setKeyInDivCd(	"@");					// 8. @ (1자리 고정) (Key IN:'@', Swipe: 'A')
        vo.setRefNoData(	CARD_NO);// 9. 카드이면서 wcc 가 @ 이면 '카드번호=유효기간', 아니면 '카드번호' (고정 37자리, 뒤 ' ' 으로 패딩)
        vo.setInstallment(	"00");// 10. 할부기간 (고정 2자리)
        vo.setAprvlAmt(		AMOUNT);// 11. 금액 (소수점 제거, 금액 앞 0 으로 패딩) (고정 10자리)
        vo.setServiceAmt(	"");					// 12. 봉사료 (소수점 제거, 금액 앞 0 으로 패딩) (고정 10자리)
        vo.setTaxAmt(		"");					// 13. 세금 (소수점 제거, 금액 앞 0 으로 패딩) (고정 10자리)
        vo.setOrgAprvlDt(	ORG_APRVL_DT); // 14. 취소인 경우 원승인일자 (yyMMdd) (6자리 고정, 취소 아닌 경우 ' ' 으로 패딩)
        vo.setOrgAprvlNo(	ORG_APRVL_NO); // 15. 취소인 경우 원승인번호 (12자리 고정, 뒤 ' ' 으로 패딩, 취소 아닌 경우 ' ' 으로 패딩)
        vo.setIdentNumFlag(	identNumFlag);			// 16. 인증구분 (JJ:개인, BB:사업자) (2자리 고정, 취소 또는 값이 없는 경우 ' ' 으로 패딩)
        vo.setIdentNum(		identNum);				// 17. 주민번호/사업자번호 (13자리 고정, 주민번호 뒤 7자리인 경우 000000+7자리, 주민번호 앞 6자리인 경우 6자리+0000000, 사업자번호 10자리인 경우 10자리+' ' 패딩, 취소 또는 입력안된 경우 ' ' 으로 패딩)
        vo.setCardPswd(		cardPswd);				// 18. 카드비밀번호 (4자리 고정, 2자리 입력된 경우 2자리+' ' 패딩, 취소 또는 입력안된 경우 ' ' 으로 패딩)
        vo.setSpace(		"");					// 19. Filler (60자리 고정, ' '  패딩)
        vo.setCr(			"\r");					// 20. CR (고정 1자리, \r)
		return vo;
	}

	public static String getApproveReqKiccMsg(EntityKiccVo vo) throws Exception {
		/*
		 * 로깅 출력을 위한 임시 코딩 시작
		 */
		StringBuffer logSpec = new StringBuffer();
		logSpec.append("\n[1. Header initial]:"+getPadItem('A', 7,  vo.getHeaderFixCd())) 
        .append("\n[2. PNR Alpha]:"+getPadItem('A', 30, vo.getComment()))  
        .append("\n[3. 거래일자]:"+getPadItem('A', 6,  vo.getDealDt())) 
        .append("\n[4. 전문일련번호]:"+getPadItem('A', 6,  vo.getMsgSeqNo())) 
        .append("\n[5. 전문 요청코드]:"+getPadItem('A', 4,  vo.getMsgReqCd())) 
        .append("\n[6. 전문 구분코드 ]:"+getPadItem('A', 2,  vo.getMsgDivCd())) 
        .append("\n[7. 단말기 번호]:"+getPadItem('A', 8,  vo.getTerminalId())) 
        .append("\n[8. KeyIn 구분코드]:"+getPadItem('A', 1,  vo.getKeyInDivCd())) 
        .append("\n[9. 카드번호]:"+getPadItem('A', 37, vo.getRefNoData())) 
        .append("\n[10. 할부기간]:"+getPadItem('N', 2,  vo.getInstallment())) 
        .append("\n[11. 금액]:"+getPadItem('N', 10, vo.getAprvlAmt())) 
        .append("\n[12. 봉사료]:"+getPadItem('N', 10, vo.getServiceAmt())) 
        .append("\n[13. 세금]:"+getPadItem('N', 10, vo.getTaxAmt())) 
        .append("\n[14. 원승인일자]:"+getPadItem('A', 6,  vo.getOrgAprvlDt())) 
        .append("\n[15. 원승인번호]:"+getPadItem('A', 12, vo.getOrgAprvlNo())) 
        .append("\n[16. 인증구분]:"+getPadItem('A', 2,  vo.getIdentNumFlag())) 
        .append("\n[17. 주민번호/사업자번호]:"+getPadItem('A', 13, vo.getIdentNum()))
        .append("\n[18. 카드비밀번호]:"+getPadItem('A', 4,  vo.getCardPswd())) 
        .append("\n[19. Filler]:"+getPadItem('A', 60, vo.getSpace())) 
        .append("\n[20. CR]:"+getPadItem('A', 1,  vo.getCr())); 
		System.out.println("###VAN-SPEC:::"+logSpec.toString());
		/*
		 * 로깅 출력을 위한 임시 코딩 종료
		 */
		
		StringBuffer vanSpec = new StringBuffer();
		
		vanSpec.append(getPadItem('A', 7,  vo.getHeaderFixCd()))// 1. Header initial (고정값 7자리)
        .append(getPadItem('A', 30, vo.getComment()))			// 2. PNR Alpha (30자리 고정) 
        .append(getPadItem('A', 6,  vo.getDealDt()))			// 3. 거래일자 6자리 (yyMMdd)
        .append(getPadItem('A', 6,  vo.getMsgSeqNo()))			// 4. 전문일련번호 생성(승인번호 6자리)
        .append(getPadItem('A', 4,  vo.getMsgReqCd()))			// 5. 전문 요청코드 CC(카드결제) 승인:0200, 취소:0420 / KK(현금영수증) 승인:0700, 취소:0720
        .append(getPadItem('A', 2,  vo.getMsgDivCd()))			// 6. 전문 구분코드 CC/KK(카드결제/현금영수증) 승인, 취소 인 경우 '10'
        .append(getPadItem('A', 8,  vo.getTerminalId()))		// 7. VAN 에서 부여한 단말기 번호 (8자리 고정, ' '으로 패딩)
        .append(getPadItem('A', 1,  vo.getKeyInDivCd()))		// 8. @ (1자리 고정) (Key IN:'@', Swipe: 'A')
        .append(getPadItem('A', 37, vo.getRefNoData()))			// 9. 카드이면서 wcc 가 @ 이면 '카드번호=유효기간', 아니면 '카드번호' (고정 37자리, 뒤 ' ' 으로 패딩)
        .append(getPadItem('N', 2,  vo.getInstallment()))		// 10. 할부기간 (고정 2자리)
        .append(getPadItem('N', 10, vo.getAprvlAmt()))			// 11. 금액 (소수점 제거, 금액 앞 0 으로 패딩) (고정 10자리)
        .append(getPadItem('N', 10, vo.getServiceAmt()))		// 12. 봉사료 (소수점 제거, 금액 앞 0 으로 패딩) (고정 10자리)
        .append(getPadItem('N', 10, vo.getTaxAmt()))			// 13. 세금 (소수점 제거, 금액 앞 0 으로 패딩) (고정 10자리)
        .append(getPadItem('A', 6,  vo.getOrgAprvlDt()))		// 14. 취소인 경우 원승인일자 (yyMMdd) (6자리 고정, 취소 아닌 경우 ' ' 으로 패딩)
        .append(getPadItem('A', 12, vo.getOrgAprvlNo()))		// 15. 취소인 경우 원승인번호 (12자리 고정, 뒤 ' ' 으로 패딩, 취소 아닌 경우 ' ' 으로 패딩)
        .append(getPadItem('A', 2,  vo.getIdentNumFlag()))		// 16. 인증구분 (JJ:개인, BB:사업자) (2자리 고정, 취소 또는 값이 없는 경우 ' ' 으로 패딩)
        .append(getPadItem('A', 13, vo.getIdentNum()))			// 17. 주민번호/사업자번호 (13자리 고정, 주민번호 뒤 7자리인 경우 000000+7자리, 주민번호 앞 6자리인 경우 6자리+0000000, 사업자번호 10자리인 경우 10자리+' ' 패딩, 취소 또는 입력안된 경우 ' ' 으로 패딩)
        .append(getPadItem('A', 4,  vo.getCardPswd()))			// 18. 카드비밀번호 (4자리 고정, 2자리 입력된 경우 2자리+' ' 패딩, 취소 또는 입력안된 경우 ' ' 으로 패딩)
        .append(getPadItem('A', 60, vo.getSpace()))				// 19. Filler (60자리 고정, ' '  패딩)
        .append(getPadItem('A', 1,  vo.getCr()));				// 20. CR (고정 1자리, \r)
		return vanSpec.toString();
	}

	public static String getPadItem(char typ, int len, String str) throws Exception {
		return getPadStr(str == null ? "" : str, typ, len);
	}

    public static String getPadStr(String msg, char typ, int len) {
    	return 'N' == typ ? getLpad(msg, len, '0') : getRpad(msg, len, ' ');
    }

    /**
     * <pre>
     * Length 에 맞게 오른쪽에 Padding Char를 추가한다.
     * </pre>
     * @param String
     * @param int
     * @param char
     * @return String
     */
    public static String getRpad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		} else {
			//int pads = size - str.length();
			int pads = size - str.getBytes().length;
			return pads <= 0 ? str
				: (pads > 8192 ? getRpad(str, size, String.valueOf(padChar)) : str.concat(getRepeat(padChar, pads)));
		}
	}
    
    /**
     * <pre>
     * Length 에 맞게 왼쪽에 Padding Char를 추가한다.
     * </pre>
     * @param String
     * @param int
     * @param char
     * @return String
     */
    public static String getLpad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		} else {
			//int pads = size - str.length();
			int pads = size - str.getBytes().length;
			return pads <= 0 ? str
				: (pads > 8192 ? getLpad(str, size, String.valueOf(padChar)) : getRepeat(padChar, pads).concat(str));
		}
	}
    
    /**
     * <pre>
     * Length 에 맞게 오른쪽에 Padding 문자열을 추가한다.
     * public 으로 접근할 수 없음 : getPadString 을 통해서 접근
     * </pre>
     * @param String
     * @param int
     * @param String
     * @return String
     */
    private static String getRpad(String str, int size, String padStr) {
		if (str == null) {
			return null;
		} else {
			if (!(padStr != null && padStr.trim().length() > 0)) { padStr = " "; }
			int padLen = padStr.length();
			int strLen = str.length();
			int pads = size - strLen;
			if (pads <= 0) {
				return str;
			} else if (padLen == 1 && pads <= 8192) {
				return getRpad(str, size, padStr.charAt(0));
			} else if (pads == padLen) {
				return str.concat(padStr);
			} else if (pads < padLen) {
				return str.concat(padStr.substring(0, pads));
			} else {
				char[] padding = new char[pads];
				char[] padChars = padStr.toCharArray();
				for (int i = 0; i < pads; ++i) { padding[i] = padChars[i % padLen]; }
				return str.concat(new String(padding));
			}
		}
	}
    
    /**
     * <pre>
     * Length 에 맞게 왼른쪽에 Padding 문자열을 추가한다.
     * public 으로 접근할 수 없음 : getPadString 을 통해서 접근
     * </pre>
     * @param String
     * @param int
     * @param String
     * @return String
     */
    private static String getLpad(String str, int size, String padStr) {
		if (str == null) { 
			return null;
		} else {
			if (!(padStr != null && padStr.trim().length() > 0)) { padStr = " "; }
			int padLen = padStr.length();
			int strLen = str.length();
			int pads = size - strLen;
			if (pads <= 0) {
				return str;
			} else if (padLen == 1 && pads <= 8192) {
				return getLpad(str, size, padStr.charAt(0));
			} else if (pads == padLen) {
				return padStr.concat(str);
			} else if (pads < padLen) {
				return padStr.substring(0, pads).concat(str);
			} else {
				char[] padding = new char[pads];
				char[] padChars = padStr.toCharArray();
				for (int i = 0; i < pads; ++i) { padding[i] = padChars[i % padLen]; }
				return (new String(padding)).concat(str);
			}
		}
	}

    /**
     * <pre>
     * Length 에 맞게 문자열을 추가한다.
     * public 으로 접근할 수 없음 : getPadString 을 통해서 접근
     * </pre>
     * @param char
     * @param int
     * @return String
     */
    private static String getRepeat(char ch, int repeat) {
		char[] buf = new char[repeat];
		for (int i = repeat - 1; i >= 0; --i) { buf[i] = ch; }
		return new String(buf);
	}
}
