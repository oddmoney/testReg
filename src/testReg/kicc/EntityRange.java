package testReg.kicc;

/*
 * 응답 전문 Range
 */
public class EntityRange {
	// 오프라인 KICC Socket 응답 CharSet
	public static final String KICC_RES_CHAR = "KSC5601";
	//public static final String KICC_RES_CHAR = "EUC-KR";
	//public static final String KICC_RES_CHAR = "UTF-8";
	// 오프라인 KICC Socket 응답 Byte Range 정보
	public static final int[][] KICC_RES_IDX = {
		{0,7}			// HEADER INITIAL
		, {7,37}		// 가맹점 RETURN DATA
		, {37,43}		// 거래일자
		, {43,49}		// 전문 일련번호
		, {49,53}		// 거래 유형
		, {53,55}		// 전문 구분코드
		, {55,63}		// 단말기 고유번호
		, {63,67}		// 응답 코드
		, {67,79}		// 승인 번호
		, {79,94}		// 가맹점 번호
		, {94,126}		// 카드명
		, {126,129}		// 발급사 코드
		, {129,161}		// 발급사 명
		, {161,164}		// 매입회사 코드
		, {164,196}		// 매입회사 명
		, {196,198}		// Card Prefix Code
		, {198,226}		// Filler
		, {226,227}		// CR
	};


	// 온라인 KICC Socket 응답 CharSet
	public static final String KICC_ONLINE_RES_CHAR = "KSC5601";
	//public static final String KICC_ONLINE_RES_CHAR = "EUC-KR";
	//public static final String KICC_ONLINE_RES_CHAR = "UTF-8";
	// 온라인 KICC Socket 응답 Byte Range 정보
	public static final int[][] KICC_ONLINE_RES_IDX = {
		{0, 4}  		// 길이
		, {4, 5}  		// 암호화여부
		, {5, 9}  		// 전문버젼
		, {9, 19}  		// 단말기번호
		, {19, 24}  	// 취급기관코드
		, {24, 36}  	// 전문일련번호
		, {36, 38}  	// 가맹점 Timeout
		, {38, 58}  	// 관리자명
		, {58, 71}  	// 회사전화번호
		, {71, 84}  	// 휴대폰번호
		, {84, 127}  	// 여유필드
		, {127, 131}  	// 전문구분
		, {131, 143}  	// VAN-TR
		, {143, 144}  	// Status
		, {144, 156}  	// 거래일시
		, {156, 176} 	// 카드번호
		, {176, 180}  	// 유효기간
		, {180, 182}  	// 할부개월수
		, {182, 194}  	// 총금액
		, {194, 210}  	// 메시지1
		, {210, 226}  	// 메시지2
		, {226, 242}  	// 메시지3
		, {242, 258}  	// 메시지4
		, {258, 270}  	// 승인번호
		, {270, 286}  	// 카드종류명
		, {286, 288}  	// 발급사코드
		, {288, 290}  	// 매입사코드
		, {290, 305}  	// 가맹점번호
		, {305, 307}  	// 전송구분
		, {307, 327}  	// Notice
		, {327, 339}  	// 발생포인트
		, {339, 351}  	// 가용포인트
		, {351, 363}  	// 누적포인트
		, {363, 403}  	// 포인트카드사메시지
		, {403, 405}  	// 가맹점사용ID
		, {405, 435}  	// 가맹점사용필드
		, {435, 465}  	// 여유필드
	};

}
