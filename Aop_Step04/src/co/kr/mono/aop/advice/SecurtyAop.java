package co.kr.mono.aop.advice;

import co.kr.mono.aop.utill.UtilLib;

public class SecurtyAop {

	public void displayLine() {
		System.out.println(UtilLib.lpad("*", 50, "*"));
	}
	
	public void logAfterThrowing(IllegalArgumentException ex) {
		System.out.println("μμΈλ°μ : " + ex.toString());
		
	}
	
}
