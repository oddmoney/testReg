package testReg;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import testReg.kicc.DateUtils;

public class TestDate {

	public static void main(String[] args) {
		try {
			System.out.println("getCurrentDate:" + DateUtils.getCurrentDate("yyyyMMddHHmmss"));
			
			System.out.println("addDate:" + DateUtils.addDate(new Date(), Calendar.DATE, 5, "yyyyMMdd"));
			System.out.println("addDate:" + DateUtils.addDate(new Date(), Calendar.HOUR, 5, "HHmmss"));
			System.out.println("addDate:" + DateUtils.addDate(new Date(), Calendar.HOUR, -5, "HHmmss"));
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			System.out.println("dateCompareTo:" + diffOfDays("20210525", "yyyyMMdd"));
			System.out.println("dateCompareTo:" + diffOfDays("20210530", "yyyyMMdd"));
			System.out.println("dateCompareTo:" + diffOfDays("20210531", "yyyyMMdd"));
			System.out.println("dateCompareTo:" + diffOfDays("20210601", "yyyyMMdd"));
			System.out.println("dateCompareTo:" + diffOfDays("20210609", "yyyyMMdd"));
			System.out.println("dateCompareTo:" + diffOfDays("210525", "yyMMdd"));
			System.out.println("dateCompareTo:" + diffOfDays("210530", "yyMMdd"));
			System.out.println("dateCompareTo:" + diffOfDays("210531", "yyMMdd"));
			System.out.println("dateCompareTo:" + diffOfDays("210601", "yyMMdd"));
			System.out.println("dateCompareTo:" + diffOfDays("210609", "yyMMdd"));
			System.out.println("dateCompareTo:" + diffOfDays("20210525012934", "yyyyMMddHHmmss"));
			System.out.println("dateCompareTo:" + diffOfDays("20210530112934", "yyyyMMddHHmmss"));
			System.out.println("dateCompareTo:" + diffOfDays("20210531212934", "yyyyMMddHHmmss"));
			System.out.println("dateCompareTo:" + diffOfDays("20210601112934", "yyyyMMddHHmmss"));
			System.out.println("dateCompareTo:" + diffOfDays("20210609212934", "yyyyMMddHHmmss"));

			System.out.println("====================\n=====================");

			System.out.println("dateCompareTo2:" + diffOfDays2("20210525", "yyyyMMdd"));
			System.out.println("dateCompareTo2:" + diffOfDays2("20210530", "yyyyMMdd"));
			System.out.println("dateCompareTo2:" + diffOfDays2("20210531", "yyyyMMdd"));
			System.out.println("dateCompareTo2:" + diffOfDays2("20210601", "yyyyMMdd"));
			System.out.println("dateCompareTo2:" + diffOfDays2("20210609", "yyyyMMdd"));
			System.out.println("dateCompareTo2:" + diffOfDays2("210525", "yyMMdd"));
			System.out.println("dateCompareTo2:" + diffOfDays2("210530", "yyMMdd"));
			System.out.println("dateCompareTo2:" + diffOfDays2("210531", "yyMMdd"));
			System.out.println("dateCompareTo2:" + diffOfDays2("210601", "yyMMdd"));
			System.out.println("dateCompareTo2:" + diffOfDays2("210609", "yyMMdd"));
			System.out.println("dateCompareTo2:" + diffOfDays2("20210525012934", "yyyyMMddHHmmss"));
			System.out.println("dateCompareTo2:" + diffOfDays2("20210530112934", "yyyyMMddHHmmss"));
			System.out.println("dateCompareTo2:" + diffOfDays2("20210531212934", "yyyyMMddHHmmss"));
			System.out.println("dateCompareTo2:" + diffOfDays2("20210601112934", "yyyyMMddHHmmss"));
			System.out.println("dateCompareTo2:" + diffOfDays2("20210609212934", "yyyyMMddHHmmss"));

			
			String strAprvlDate = "20210525162233";
			String strNowDate = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA).format(new Date());

			System.out.println("diff:"+(getBetweenDays(strAprvlDate, strNowDate) > 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static long diffOfDays(String strStDt, String strStFormat) throws Exception {
		SimpleDateFormat format1 = new SimpleDateFormat(strStFormat, Locale.KOREA);
		SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		Date beginDate = format2.parse(format2.format(format1.parse(strStDt)));
		Date endDate = format2.parse(format2.format(new Date()));
		return beginDate.compareTo(endDate);
	}

	private static long diffOfDays2(String strStDt, String strStFormat) throws Exception {
		SimpleDateFormat format1 = new SimpleDateFormat(strStFormat, Locale.KOREA);
		SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		String stdt = format2.format(format1.parse(strStDt));
		String eddt = format2.format(new Date());
		return ChronoUnit.DAYS.between(LocalDate.of(Integer.parseInt(stdt.substring(0,4)), 
				Integer.parseInt(stdt.substring(4,6)), Integer.parseInt(stdt.substring(6,8))), 
		LocalDate.of(Integer.parseInt(eddt.substring(0,4)), 
				Integer.parseInt(eddt.substring(4,6)), Integer.parseInt(eddt.substring(6,8))));
	}

	private static long getBetweenDays(String stDate, String edDate) throws Exception {
		return ChronoUnit.DAYS.between(LocalDate.of(Integer.parseInt(stDate.substring(0,4)), 
						Integer.parseInt(stDate.substring(4,6)), Integer.parseInt(stDate.substring(6,8))), 
				LocalDate.of(Integer.parseInt(edDate.substring(0,4)), 
						Integer.parseInt(edDate.substring(4,6)), Integer.parseInt(edDate.substring(6,8))));
	}

}
