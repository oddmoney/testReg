package testReg.test;

public class PayAprvlAuditResVo {

	private String agencyType = "test";			// KRP, GALAXIA, VTP, INICIS, LGU, KAKAO, NAVER, TOSS
	private int targetCnt = 0;		// 전체 대상 건수
	private int procCnt = 0;		// 처리 건수
	private int failCnt = 0;		// 실패 건수
	
	public String getAgencyType() {
		return agencyType;
	}
	public void setAgencyType(String agencyType) {
		this.agencyType = agencyType;
	}
	public int getTargetCnt() {
		return targetCnt;
	}
	public void setTargetCnt(int targetCnt) {
		this.targetCnt = targetCnt;
	}
	public int getProcCnt() {
		return procCnt;
	}
	public void setProcCnt(int procCnt) {
		this.procCnt = procCnt;
	}
	public int getFailCnt() {
		return failCnt;
	}
	public void setFailCnt(int failCnt) {
		this.failCnt = failCnt;
	}
	
	@Override
	public String toString() {
		return "PayAprvlAuditResVo [agencyType=" + agencyType + ", targetCnt=" + targetCnt + ", procCnt=" + procCnt
				+ ", failCnt=" + failCnt + "]";
	}
	
}
