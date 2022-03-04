package testReg.kicc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/***********************************************************************************
 * <pre>
 * PROJECT      : Jeju_BookingEngine_EngineUpgrade
 * PROGRAM ID   : DateUtils.java
 * PROGRAM NAME : Date Util Class
 * DESCRIPTION  : 날짜관련 공용 유틸성 클래스
 * AUTHOR       : tour-m05
 * CREATED DATE : 2017.03.10.
 * HISTORY
 * =================================================================================
 *     DATE       NAME      DESCRIPTION
 * ---------------------------------------------------------------------------------
 * 2017. 3. 10.  tour-m05  First Generated
 * </pre>
 ***********************************************************************************/

public class DateUtils {

	/**
	 * <pre>
	 * 현재 일자를 format에 맞춰 return한다.
	 * </pre>
	 * 
	 * @param format
	 * @return
	 */
	public static final String getCurrentDate(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}

	/**
	 * <pre>
	 * 시간차를 계산한다
	 * </pre>
	 * 
	 * @param startDate (yyyyMMddHHmmss)
	 * @param endDate   (yyyyMMddHHmmss)
	 * @param type      (구분자 ex)DATE, MINUTE)
	 * @return
	 */
	public static long diffOfDateTime(String startDateStr, String endDateStr, String type) throws Exception {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);

		Date beginDate = formatter.parse(startDateStr);
		Date endDate = formatter.parse(endDateStr);
		long diff = endDate.getTime() - beginDate.getTime();
		long diffDays = 0L;

		if (type.equals("DATE")) {
			diffDays = diff / 86400000L;
		} else if (type.equals("MINUTE")) {
			diffDays = diff / 60000L;
		} else {
			diffDays = diff / 3600000L;
		}
		
		return diffDays;
	}

	/**
	 * 기준 시간에 지정된 항목을 더하여 문자열 형태로 출력
	 * @param base
	 * @param field
	 * @param gap
	 * @param outFormat
	 * @return
	 */
    public static String addDate(Date base, int field, int gap, String outFormat) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(base);
        cal.add(field, gap);
        return new SimpleDateFormat(outFormat).format(cal.getTime());
    }

}
