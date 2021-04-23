package co.kr.mono.aop.utill;

public class UtilLib {

	public static String lpad(String str, int len, String addStr) {
		String result = str;
		int templen = len - result.length();
		
		for(int i = 0; i < templen; i++) {
			result = addStr + result;
		}
		
		return result;
	}
}
