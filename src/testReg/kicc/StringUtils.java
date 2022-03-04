package testReg.kicc;

public class StringUtils {
   
	/**
	 * <pre>
	 * null String을 &quot;&quot; String으로 변환한다.
	 * </pre>
	 *
	 * @param String text
	 * @return String
	 */
	public static String getNullToEmpty(String text) {

		String rtn;
		rtn = "";
		if (text == null || text.toLowerCase().trim().equals("null"))
			return rtn;
		else
			return text.trim();
	}

	
	/**
	 * <pre>
	 * Length 에 맞게 왼쪽 또는 오른쪽에 Padding 문자열 추가한다.
	 * typ == 'N' 이면 왼쪽에 '0' 패딩, 아니면 오른쪽에 ' ' 패딩
     * </pre>
	 * @param String
	 * @param char
	 * @param int
	 * @return String
	 */
    public static String getPadString(String msg, char typ, int len) {
    	return 'N' == typ ? leftPad(msg, len, '0') : rightPad(msg, len, ' ');
    }

    /**
     * <pre>
     * Length 에 맞게 오른쪽에 Padding Char를 추가한다.
     * public 으로 접근할 수 없음 : getPadString 을 통해서 접근
     * </pre>
     * @param String
     * @param int
     * @param char
     * @return String
     */
    private static String rightPad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		} else {
			//int pads = size - str.length();
			int pads = size - str.getBytes().length;
			return pads <= 0 ? str
				: (pads > 8192 ? rightPad(str, size, String.valueOf(padChar)) : str.concat(repeat(padChar, pads)));
		}
	}
    
    /**
     * <pre>
     * Length 에 맞게 왼쪽에 Padding Char를 추가한다.
     * public 으로 접근할 수 없음 : getPadString 을 통해서 접근
     * </pre>
     * @param String
     * @param int
     * @param char
     * @return String
     */
    private static String leftPad(String str, int size, char padChar) {
		if (str == null) {
			return null;
		} else {
			//int pads = size - str.length();
			int pads = size - str.getBytes().length;
			return pads <= 0 ? str
				: (pads > 8192 ? leftPad(str, size, String.valueOf(padChar)) : repeat(padChar, pads).concat(str));
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
    private static String rightPad(String str, int size, String padStr) {
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
				return rightPad(str, size, padStr.charAt(0));
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
    private static String leftPad(String str, int size, String padStr) {
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
				return leftPad(str, size, padStr.charAt(0));
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
    private static String repeat(char ch, int repeat) {
		char[] buf = new char[repeat];
		for (int i = repeat - 1; i >= 0; --i) { buf[i] = ch; }
		return new String(buf);
	}
    
}
