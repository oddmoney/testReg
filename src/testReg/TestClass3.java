package testReg;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestClass3 {

	public static void main(String[] args) {
		System.out.println("FROM_TIME:::"+ (getTimeRegulate(getCurrentDate(), "MINUTE", -( 3+ 1439)).substring(0, 12)+"00"));
		System.out.println("TO_TIME:::"+ (getTimeRegulate(getCurrentDate(), "MINUTE", - 3).substring(0, 12)+"59"));

	}
	
	public static String getCurrentDate()
    {
        SimpleDateFormat lSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date today = new Date(System.currentTimeMillis());
        String lsToday = lSimpleDateFormat.format(today);
        return lsToday;
    }
    public static String getTimeRegulate(String inputDate, String inputGubn, int dateVal)
    {
        String year = inputDate.substring(0, 4);
        String month = inputDate.substring(4, 6);
        String date = inputDate.substring(6, 8);
        String hour = inputDate.substring(8, 10);
        String minute = inputDate.substring(10, 12);
        String second = inputDate.substring(12, 14);
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(date), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second));
        if(inputGubn.equals("YEAR"))
            cal.add(1, dateVal);
        if(inputGubn.equals("MONTH"))
            cal.add(2, dateVal);
        if(inputGubn.equals("DATE"))
            cal.add(5, dateVal);
        if(inputGubn.equals("HOUR"))
            cal.add(11, dateVal);
        if(inputGubn.equals("MINUTE"))
            cal.add(12, dateVal);
        if(inputGubn.equals("SECOND"))
            cal.add(13, dateVal);
        year = String.valueOf(cal.get(1));
        if(cal.get(2) + 1 < 10)
            month = (new StringBuilder("0")).append(String.valueOf(cal.get(2) + 1)).toString();
        else
            month = String.valueOf(cal.get(2) + 1);
        if(cal.get(5) < 10)
            date = (new StringBuilder("0")).append(String.valueOf(cal.get(5))).toString();
        else
            date = String.valueOf(cal.get(5));
        hour = String.valueOf(cal.get(11));
        minute = String.valueOf(cal.get(12));
        second = String.valueOf(cal.get(13));
        if(hour.length() < 2)
            hour = (new StringBuilder("0")).append(hour).toString();
        if(minute.length() < 2)
            minute = (new StringBuilder("0")).append(minute).toString();
        if(second.length() < 2)
            second = (new StringBuilder("0")).append(second).toString();
        return (new StringBuilder(String.valueOf(year))).append(month).append(date).append(hour).append(minute).append(second).toString();
    }

}
