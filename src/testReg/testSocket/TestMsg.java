package testReg.testSocket;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestMsg {

	public static void main(String[] args) {
		try {
			System.out.println(new DecimalFormat("#0.00").format(122333.22222));
			System.out.println("EQ:"+("OC|WC|UP|AP".indexOf("AC") >= 0));
			System.out.println("FORMAT:"+String.valueOf((long)Double.parseDouble("1000000000.9888889")));
			System.out.println("replace:"+"1000055500.021300".replaceAll("^([0-9]{1,})(\\.*)$", "$1"));
			System.out.println("replace2:"+"AQDFD12322F12312323".replaceAll("^([A-Z]{2}[A-Z0-9]{6}[0-9]{2})([FGHIJ])([0-9]{8})$", "$2"));
			System.out.println("replace3:"+"AQDFD12322H12312323".replaceAll("^([A-Z]{2}[A-Z0-9]{6}[0-9]{2})([FGHIJ])([0-9]{8})$", "$2"));
			System.out.println("replace4:"+"510900000000000".matches("^([5-7]10)([1-9])(0{11,12})$"));
			System.out.println("replace5:"+"510900000000000".replaceAll("^([5-7]10)([1-9])(0{11,12})$", "$2"));
			System.out.println("DATE_DIFF_HOUR:"+diffOfDateTime("20210322043000", "20210322052959", "HOUR"));
			System.out.println("DATE_DIFF_DATE:"+diffOfDateTime("20210301043000", "20210828042959", "DATE"));
					
			String str = "JEJUAIRQSSD23                        21031764776802001011709547000088112727    170635460      �쁽��移대뱶                    08 �쁽��移대뱶�궗                 08 �쁽��移대뱶�궗                                               \n";
			System.out.println("###LENGTH:"+str.getBytes().length);
			byte[] resb = new byte[str.getBytes().length];
			System.out.println("###BEFORE:"+new String(resb));
			putAddByte(resb, str.getBytes(), 0);
			System.out.println("###AFTER:"+new String(resb, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void putAddByte(byte[] orgb, byte[] newb, int pos) throws Exception{
		if (orgb != null && newb != null && orgb.length >= (pos + newb.length))
			System.arraycopy(newb, 0, orgb, pos, newb.length);
	}

	public static final String getConvertDate(String orgStr, String orgFormat, String newFormat) throws Exception {
		return new SimpleDateFormat(newFormat).format(
				new SimpleDateFormat(orgFormat).parse(orgStr));
	}





	/**
	 * <pre>
	 * �떆媛꾩감瑜� 怨꾩궛�븳�떎
	 * </pre>
	 * 
	 * @param startDate (yyyyMMddHHmmss)
	 * @param endDate   (yyyyMMddHHmmss)
	 * @param type      (援щ텇�옄 ex)DATE, MINUTE)
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

}
