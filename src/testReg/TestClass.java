package testReg;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;

import testReg.test.PayAprvlAuditResVo;

public class TestClass {

	public static void main(String[] args) {
		
		System.out.println("intVal:"+(int)(Double.parseDouble("1000.00")));
		System.out.println("intVal:"+(int)(Double.parseDouble("1001.40")));
		System.out.println("intVal:"+(int)(Double.parseDouble("1001.99")));
		
		int dday = 0;
		System.out.println("DDAY:::"+(dday >= -1 && dday <= 1));
		
		try {
			String lsRate = "1.000001111";
			if (lsRate.matches("^([0-9]){1,}\\.([0-9]{7,})$")) {
				lsRate = lsRate.replaceAll("^([0-9]){1,}\\.([0-9]{6}).*$", "$1.$2"); 
			}
			System.out.println("###lsRate:"+lsRate);
			
			String payDate = "21/11/12 17:55:45";
			String payTimelimitDt = "20211112175545";

			// 입금일시
			payDate = "20" + payDate.replaceAll("[^0-9]", "");
			
			// 입금기한일시
			if (payTimelimitDt.length() == 12) payTimelimitDt += "59";
			else if (payTimelimitDt.length() == 8) payTimelimitDt += "235959";
			if (payTimelimitDt.length() != 14) {
				System.out.println("입금기한일자 12자리, 8자리, 14자리가 아니면 에러!!!!!!!!!!!!!!!");
			} else {
				// 입금일시 > 입금기한일시 체크
				Date dtPayDate = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA).parse(payDate);
				Date dtPayLimit = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA).parse(payTimelimitDt);
				if (dtPayDate.compareTo(dtPayLimit) > 0) {
					System.out.println("입금기한일시Over[입금일시:" + payDate + "], [입금기한일시:"+payTimelimitDt+"]");
				} else {
					System.out.println("입금기한일시Limit[입금일시:" + payDate + "], [입금기한일시:"+payTimelimitDt+"]");
				}
			}
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		String sitaPayInfo[] = {"CLEC211024-0001311799", "CL/EC211024-0001311799", "CL211024-0001311799", "CLEC2110240001311799", "CL/EC2110240001311799", "CL2110240001311799"
				, "CLCP211024000131", "CL/CP21102401311799", "CLAT211024000131", "CL/AT21102401311799", "CLUP211024000131", "CL/UP21102401311799", "CLWC211024000131", "CL/WC21102401311799"
				, "CLSP211024000131", "CL/SP21102401311799"};
		for (String str : sitaPayInfo) {
			String orderId = str.replaceAll("^CL/?([\\w\\d\\-]{1,})$", "$1");
			System.out.println("###ORDER_ID:"+orderId);
			if (orderId.matches("^(EC)?[0-9]{6}-?[0-9]{10}$")) {
				orderId = orderId.replaceAll("[^0-9]", "").replaceAll("^([0-9]{6})([0-9]{1,})$", "$1-$2");
				System.out.println("==>ECON_ORDER_ID:"+orderId);				
			}
		}
		System.out.println("###ECON###");
		String orderNoArr[] = {"211003-0001311602", "211003-0001311602-1", "211003-0001311602-2", "211003-0001311602-3"};
		for (String orderNo : orderNoArr) {
			if (orderNo.matches("^.*\\-.*\\-[0-9]{1,}$")) {
				int tmpNum = Integer.parseInt(orderNo.replaceAll("^(.*\\-.*\\-)([0-9]{1,})$", "$2")) + 1;
				orderNo = orderNo.replaceAll("^(.*\\-.*\\-)([0-9]{1,})$", "$1") + tmpNum;
			} else {
				orderNo = orderNo + "-1";
			}
			System.out.println("orderNo:"+orderNo);
		}
		

		
		
		String str1 = "20211025";
		String str2 = "MCC5DYKM21926124535";
		System.out.println("DATE:::"+str1 + str2.replaceAll("^.*([0-9]{6})$", "$1"));
		
		System.out.println("Tel:"+("010-22323_12332".replaceAll("[^0-9]", "")));
		
		String cancAmt = "1000.00";
		if (cancAmt.contains(".")) {
			cancAmt = cancAmt.replaceAll("^([0-9]{1,})\\..*$", "$1");
		}
		System.out.println("ReplaceAmt:"+cancAmt);
		
		System.out.println("Replace:"+("aaa bbb ccc dddd".replace(" ", "+")));
		
		String testYn = " YN ";
		System.out.println(testYn.trim().substring(0, 1));
		
		int sizePlus = 0;
		int sizeMax = 1;
        if(++sizePlus == sizeMax) {
        	System.out.println("sizePlus++ == sizeMax : true");
        } else {
        	System.out.println("sizePlus++ == sizeMax : false");
        }
        System.out.println("sizePlus : " + sizePlus);
        if(sizePlus++ == sizeMax) {
        	System.out.println("sizePlus++ == sizeMax : true");
        } else {
        	System.out.println("sizePlus++ == sizeMax : false");
        }
        System.out.println("sizePlus : " + sizePlus);

		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		
		String nowDt1 = "20210901";		
		System.out.println("###nowDt1:"+nowDt1);
		try {
			Date date1 = sdf.parse(nowDt1);
			nowDt1 = addDate(date1, Calendar.DATE, 1, "yyyyMMdd");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("###nowDt1:"+nowDt1);
		
		String testStr = "asfsf\tdfsdsfd\rsdffsd\nafsd\" fds}{sf\"dafsad\"";
		System.out.println("###testStr:"+testStr);
		testStr = testStr.replaceAll("\\{|\\}|.*\\=|\\r\\n|\\s|\"|\\t*", "");
		System.out.println("###testStr:"+testStr);
		
		String strStDate = "20210901100400";
		String strEdDate = "20210903100500";
		try {
			String nowDt = strStDate.substring(0, 8);
			String edDt = strEdDate.substring(0, 8);
			String actDt = "";
			while (Integer.parseInt(nowDt) <= Integer.parseInt(edDt)) {
				if (nowDt.equals(strStDate.substring(0, 8))) {
					actDt = nowDt + strStDate.substring(8);
				} else if (nowDt.equals(strEdDate.substring(0, 8))) {
					actDt = nowDt + strEdDate.substring(8);
				} else {
					actDt = nowDt + "000000";
				}
				System.out.println("###ACT_DT:"+actDt);
				nowDt = sdf.format(DateUtils.addDays(sdf.parse(nowDt), 1));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		PayAprvlAuditResVo testVo = new PayAprvlAuditResVo();
		System.out.println("###testVo:"+testVo.toString());
		testVo.setFailCnt(999);
		System.out.println("###testVo2:"+testVo.toString());
		
		double dblCancTotAmt = 10000.000;
		dblCancTotAmt += Double.parseDouble("-10000".replaceAll("[^0-9\\.]", ""));
		System.out.println("###dblCancTotAmt:"+dblCancTotAmt);
		
    	StringBuffer reqMsg = new StringBuffer();
    	reqMsg.append("|approve_no`")
    	.append("1231232")
    	.append("|password`")
    	.append("99999999")
    	.append("|job_type`")
    	.append("CC")
    	.append("|date`")
    	.append("12212112")
    	.append("|to_date`")
    	.append("23234");
    	System.out.println("###reqMsg:"+reqMsg.toString());

    	
		String createDt = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA).format(new Date());
		int mint = Integer.parseInt(createDt.substring(4, 6));
		String orderId = "KP"
		+ "TSTPNR"
		+ createDt.substring(2, 4)
		+ (mint > 11 ? "C" : mint > 10 ? "B" : mint > 9 ? "A" : String.valueOf(mint))
		+ createDt.substring(6);
		System.out.println("###orderId:"+orderId);

		double reqAmt = Double.parseDouble("1000.999");
		double aprAmt = Double.parseDouble("1001");
		if (!(reqAmt > 0 && aprAmt > 0 && reqAmt == aprAmt)) {
			System.out.println("Invalid Amount(DB-Amount : " + aprAmt+", REQ-Amount : " + reqAmt);
		} else {
			System.out.println("Amount Success");
		}

		String tstr = "\"	영 	업	일	\"";
		System.out.println("RES:::["+tstr.replaceAll("[\\t\\s]", "")+"]");
		
		String oPrice = "111005.00".replaceAll("^([0-9]{1,})\\.*.*", "$1"); // 원결제 금액 
		String cPrice = "11110.000".replaceAll("^([0-9]{1,})\\.*.*", "$1"); // 취소 요청 금액
		
		oPrice = "111005.99"; 
		cPrice = "11110.99";
		oPrice = String.valueOf(Math.round(Double.parseDouble(oPrice)));
		cPrice = String.valueOf(Math.round(Double.parseDouble(oPrice)));
		System.out.println("oPrice::"+oPrice+"/cPrice::"+cPrice);
		int calcAmt = Integer.parseInt(oPrice) - Integer.parseInt(cPrice);
		System.out.println("calcAmt::"+calcAmt);
		
		String chkAmt = "1000.222.222";
		String aaaa = chkAmt;
		if (aaaa.startsWith("\\.") || aaaa.split("\\.").length > 2) {
			System.out.println("ERROR::Invalid Amount:::"+aaaa);
		}
		// 금액 소수점 2자리 이상인 경우 2자리 이후 제거
		if (aaaa.matches("^[0-9]{1,}\\.[0-9]{3,}.*$")) {
			aaaa = aaaa.replaceAll("^([0-9]{1,})\\.([0-9]{2}).*$", "$1.$2");
		}
		System.out.println("aaaa:"+aaaa);
		System.out.println("chkAmt:"+chkAmt);
		
		aaaa = aaaa.replaceAll("([0-9]{1,})\\.([0-9]{2}).*", "$1.$2");
		if (aaaa.endsWith("."))  aaaa = aaaa.replaceAll("([0-9]{1,})\\.", "$1");
		System.out.println("aaaa:"+aaaa);
		System.out.println("chkAmt:"+chkAmt);
		
		int searchDay = 180;
		System.out.println("searchDate:"+addDate(new Date(), Calendar.DATE, -searchDay, "yyyyMMdd"));
		
		BigDecimal amount = new BigDecimal("100000100");
		System.out.println("BigDecimal amount:"+amount);
		amount = new BigDecimal("100100.000");
		System.out.println("BigDecimal amount:"+amount);
		amount = new BigDecimal("100100.010");
		System.out.println("BigDecimal amount:"+amount);

		System.out.println("BigDecimal1-0:"+(new BigDecimal("15000.000") == new BigDecimal("15000.000")));
		System.out.println("BigDecimal1-1:"+(new BigDecimal("15000.000") == new BigDecimal("15000")));
		System.out.println("BigDecimal1-2:"+(new BigDecimal("15000.000") == new BigDecimal("15000.0")));
		System.out.println("BigDecimal1-3:"+(new BigDecimal("15000.000") == new BigDecimal("15000.0001")));
		System.out.println("BigDecimal2-0:"+(new BigDecimal("15000.000").equals(new BigDecimal("15000.000"))));
		System.out.println("BigDecimal2-1:"+(new BigDecimal("15000.000").equals(new BigDecimal("15000"))));
		System.out.println("BigDecimal2-2:"+(new BigDecimal("15000.000").equals(new BigDecimal("15000.0"))));
		System.out.println("BigDecimal2-3:"+(new BigDecimal("15000.000").equals(new BigDecimal("15000.0001"))));
		System.out.println("BigDecimal3-0:"+(new BigDecimal("15000.000").compareTo(new BigDecimal("15000.000"))));
		System.out.println("BigDecimal3-1:"+(new BigDecimal("15000.000").compareTo(new BigDecimal("15000"))));
		System.out.println("BigDecimal3-2:"+(new BigDecimal("15000.000").compareTo(new BigDecimal("15000.0"))));
		System.out.println("BigDecimal3-3:"+(new BigDecimal("15000.000").compareTo(new BigDecimal("15000.0001"))));
		System.out.println("BigDecimal4-0:"+(new BigDecimal("15000.000").add(new BigDecimal("100.000"))));
		System.out.println("BigDecimal4-1:"+(new BigDecimal("15000.000").add(new BigDecimal("1000"))));
		System.out.println("BigDecimal4-2:"+(new BigDecimal("15000.000").add(new BigDecimal("1000.010"))));
		System.out.println("BigDecimal4-3:"+(new BigDecimal("15000.000").add(new BigDecimal("1000.0001"))));

		System.out.println("DOUBLE_valueOf0:"+(Double.valueOf("15000.000") == Double.valueOf("15000.000")));
		System.out.println("DOUBLE_valueOf1:"+(Double.valueOf("15000.000") == Double.valueOf("15000")));
		System.out.println("DOUBLE_valueOf2:"+(Double.valueOf("15000.000") == Double.valueOf("15000.0")));
		System.out.println("DOUBLE_valueOf3:"+(Double.valueOf("15000.000") == Double.valueOf("15000.0001")));

		System.out.println("DOUBLE_valueOf0:"+(Double.valueOf("15000.000").equals(Double.valueOf("15000.000"))));
		System.out.println("DOUBLE_valueOf1:"+(Double.valueOf("15000.000").equals(Double.valueOf("15000"))));
		System.out.println("DOUBLE_valueOf2:"+(Double.valueOf("15000.000").equals(Double.valueOf("15000.0"))));
		System.out.println("DOUBLE_valueOf3:"+(Double.valueOf("15000.000").equals(Double.valueOf("15000.0001"))));
		
		System.out.println("DOUBLE_EQ1:"+(Double.parseDouble("15000.000") == Double.parseDouble("15000.000")));
		System.out.println("DOUBLE_EQ1:"+(Double.parseDouble("15000.000") == Double.parseDouble("15000")));
		System.out.println("DOUBLE_EQ1:"+(Double.parseDouble("15000.000") == Double.parseDouble("15000.0")));
		System.out.println("DOUBLE_EQ1:"+(Double.parseDouble("15000.000") == Double.parseDouble("15000.0001")));
				
		System.out.println("STARTSWITH:"+("TS0SPAAA01010101".startsWith("SP")));

		System.out.println("CONT:"+("https://fcstdpay.inicis.com{resourcepath-param}".contains("fcstdpay.inicis.com")));

		double aprvlAmt = Double.parseDouble("15000.005");
		double cancTotAmt = Double.parseDouble("5000");
		cancTotAmt += Double.parseDouble("5000.10");
		System.out.println("balance1-1:"+String.valueOf(aprvlAmt - cancTotAmt));
		System.out.println("balance1-2:"+String.valueOf(aprvlAmt > cancTotAmt));
		System.out.println("balance1-3:"+String.valueOf(aprvlAmt != cancTotAmt));
		
		aprvlAmt = Double.valueOf("15000.005");
		cancTotAmt = Double.valueOf("5000");
		cancTotAmt += Double.valueOf("5000.10"); // 기존 취소금액 + 요청 취소금액
		System.out.println("balance2-1:"+String.valueOf(aprvlAmt - cancTotAmt));
		System.out.println("balance2-2:"+String.valueOf(aprvlAmt > cancTotAmt));
		System.out.println("balance2-3:"+String.valueOf(aprvlAmt != cancTotAmt));

		
		System.out.println("MCXXXXXXXX1150".matches("^MC[\\*Xx]{1,}1450$"));
		System.out.println("MC*******1111".matches("^MC.*"));
		System.out.println("Contains:"+("OC|MC|KO".contains("MC")));
		
		System.out.println("Replace:"+("110921".replaceAll("([0-9]{2})([0-9]{2})([0-9]{2})", "$3$2$1")));
		System.out.println("Replace:"+("010120".replaceAll("([0-9]{2})([0-9]{2})([0-9]{2})", "$3$2$1")));
		
		String str = "1229";
		if (str.matches("^[01][0-9][2-9][0-9]$")) {
			str = str.replaceAll("^([01][0-9])([2-9][0-9])$", "$2$1");
		}
		System.out.println("str:"+str);
		
		System.out.println("TEST:"+("WC|AP|CP|JA|OC".contains("WC")));
		System.out.println("TEST_REG1:"+("JNP".matches("(JNL|LAT|PNT)")));
		System.out.println("TEST_REG1:"+("Q".matches("C|A")));
	}



	/**
	 * 기준 시간에 지정된 항목을 더하여 문자열 형태로 출력
	 * @param base
	 * @param field
	 * @param gap
	 * @param outFormat
	 * @return
	 */
    private static String addDate(Date base, int field, int gap, String outFormat) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(base);
        cal.add(field, gap);
        return new SimpleDateFormat(outFormat).format(cal.getTime());
    }

}
