package co.kr.mono.aop.advice;

import org.aspectj.lang.JoinPoint;

import co.kr.mono.aop.utill.UtilLib;

public class SecurtyAop {

	public void displayLine() {
		System.out.println(UtilLib.lpad("*", 50, "*"));
	}
	
	public void logAfter(JoinPoint joinpoint) {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println("### : after "+signatureStr + "완료");

	}
	
}
