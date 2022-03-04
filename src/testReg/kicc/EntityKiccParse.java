package testReg.kicc;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class EntityKiccParse {

	/**
	 * <pre>
	 * Kicc 소켓 응답 전문 VO를 생성한다.
	 * </pre>
	 * @param byte[]
	 * @return EntityKiccVo
	 * @throws Exception
	 */
	public EntityKiccVo getApproveResKiccVo(byte[] msg) throws Exception {
		EntityKiccVo vo = new EntityKiccVo();
		int idx = 0;
		/*
		 * 응답전문 Parsing
		 */
		vo.setHeaderFixCd(getCopyRange(msg, idx++));// Header Initial
		vo.setComment(getCopyRange(msg, 	idx++));// 가맹점 Return Data
		vo.setDealDt(getCopyRange(msg,		idx++));// 거래일자
		vo.setMsgSeqNo(getCopyRange(msg, 	idx++));// 전문 일련번호
		vo.setMsgReqCd(getCopyRange(msg, 	idx++));// 전문 요청코드
		vo.setMsgDivCd(getCopyRange(msg, 	idx++));// 전문 구분코드
		vo.setTerminalId(getCopyRange(msg, 	idx++));// 단말기 고유번호
		vo.setRespCd(getCopyRange(msg, 		idx++));// 응답코드
		vo.setAprvlNo(getCopyRange(msg, 	idx++));// 승인번호
		vo.setMid(getCopyRange(msg, 		idx++));// 가맹점 번호
		vo.setCardNm(getCopyRange(msg, 		idx++));// 카드명
		vo.setIssueCorpCd(getCopyRange(msg, idx++));// 발급사코드
		vo.setIssueCorpNm(getCopyRange(msg, idx++));// 발급사명
		vo.setPurchCorpCd(getCopyRange(msg, idx++));// 매입사코드
		vo.setPurchCorpNm(getCopyRange(msg, idx++));// 매입사명
		vo.setCardPrefixCd(getCopyRange(msg,idx++));// Card Prefix Code (AX/HN/SK...)
		vo.setFiller(getCopyRange(msg, 		idx++));// Filler
		vo.setCr(getCopyRange(msg, 			idx++));// CR
		return vo;
	}

	/**
	 * <pre>
	 * 온라인 Kicc 소켓 응답 전문 VO를 생성한다.
	 * </pre>
	 * @param byte[]
	 * @return EntityKiccVo
	 * @throws Exception
	 */
	public EntityKiccVo getOnlineResKiccVo(byte[] msg) throws Exception {
		EntityKiccVo vo = new EntityKiccVo();
		int idx = 0;
		/*
		 * 응답전문 Parsing
		 */
		idx++;												// 길이
		idx++;												// 암호화여부
		idx++;												// 전문버젼
		vo.setTerminalId(getOnlineCopyRange(msg, 	idx++));// 단말기 고유번호
		idx++;												// 취급기관코드
		vo.setMsgSeqNo(getOnlineCopyRange(msg, 		idx++));// 전문 일련번호
		idx++;												// 가맹점 Timeout
		idx++;												// 관리자명
		idx++;												// 회사전화번호
		idx++;												// 휴대폰번호
		idx++;												// 여유필드
		vo.setMsgReqCd(getOnlineCopyRange(msg, 		idx++));// 전문구분(전문요청코드 : 1130(승인요청), 1131(승인응답), 1210(취소요청), 1211(취소응답) ,  0200 , 0210, 0420, 0430)
		vo.setFiller(getOnlineCopyRange(msg, 		idx++));// VAN-TR
		vo.setStatusCd(getOnlineCopyRange(msg, 		idx++));// 상태코드
		vo.setDealDt(getOnlineCopyRange(msg,		idx++));// 거래일자
		idx++;												// 카드번호
		idx++;												// 유효기간
		idx++;												// 할부개월수
		vo.setAprvlAmt(getOnlineCopyRange(msg,		idx++));// 거래금액
		idx++;												// 메시지1
		idx++;												// 메시지2
		idx++;												// 메시지3
		idx++;												// 메시지4
		vo.setAprvlNo(getOnlineCopyRange(msg, 	idx++));	// 승인번호
		vo.setCardNm(getOnlineCopyRange(msg, 		idx++));// 카드명
		vo.setIssueCorpCd(getOnlineCopyRange(msg, idx++));	// 발급사코드
		vo.setPurchCorpCd(getOnlineCopyRange(msg, idx++));	// 매입사코드
		vo.setMid(getOnlineCopyRange(msg, 		idx++));	// 가맹점 번호
		idx++;												// 전송구분
		idx++;												// Notice
		idx++;												// 발생포인트
		idx++;												// 가용포인트
		idx++;												// 누적포인트
		idx++;												// 포인트카드사메시지
		idx++;												// 가맹점사용ID
		idx++;												// 가맹점사용필드
		idx++;												// 여유필드
		
		/*
		 * 응답 VO 에 추가정보 SET : 요청 전문 VO 입력
		 */
		vo.setHeaderFixCd(vo.getHeaderFixCd());		// Header Initial
		vo.setMsgDivCd("1311".equals(vo.getMsgReqCd()) ? "10" : "1211".equals(vo.getMsgReqCd()) ? "20" : "") ; // 전문 구분코드 (승인:10, 취소:20)
		vo.setRespCd("O".equals(vo.getStatusCd()) ? "0000" : StringUtils.isNotBlank(vo.getAprvlNo()) ? vo.getAprvlNo() : "X002"); // 응답코드 (정상:0000, 그외:응답코드)
		return vo;
	}
	
	/**
	 * <pre>
	 * 오프라인 KICC VAN 메시지 응답을 추출한다.
	 * </pre>
	 * @param typ
	 * @param len
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private String getCopyRange(byte[] resMsg, int idx) throws Exception {
		//return new String(Arrays.copyOfRange(resMsg, EntityRange.KICC_RES_IDX[idx][0]
		//		, EntityRange.KICC_RES_IDX[idx][1]), EntityRange.KICC_RES_CHAR);
		// 한글잘림으로 인해 변경
		int idx1 = EntityRange.KICC_RES_IDX[idx][0];
		int idx2 = EntityRange.KICC_RES_IDX[idx][1];
		byte[] btmp = new byte[idx2-idx1];
		String tmp = new String(Arrays.copyOfRange(resMsg, idx1, idx2), EntityRange.KICC_RES_CHAR);
		System.arraycopy(tmp.getBytes(), 0, btmp, 0, idx2-idx1);
		return new String(btmp);
	}

	/**
	 * <pre>
	 * ONLINE KICC VAN 메시지 응답을 추출한다.
	 * </pre>
	 * @param typ
	 * @param len
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private String getOnlineCopyRange(byte[] resMsg, int idx) throws Exception {
		//return new String(Arrays.copyOfRange(resMsg, EntityRange.KICC_ONLINE_RES_IDX[idx][0]
		//		, EntityRange.KICC_ONLINE_RES_IDX[idx][1]), EntityRange.KICC_ONLINE_RES_CHAR);
		// 한글잘림으로 인해 변경
		int idx1 = EntityRange.KICC_ONLINE_RES_IDX[idx][0];
		int idx2 = EntityRange.KICC_ONLINE_RES_IDX[idx][1];
		byte[] btmp = new byte[idx2-idx1];
		String tmp = new String(Arrays.copyOfRange(resMsg, idx1, idx2), EntityRange.KICC_ONLINE_RES_CHAR);
		System.arraycopy(tmp.getBytes(), 0, btmp, 0, idx2-idx1);
		return new String(btmp);
	}

}
