package co.kr.mono.aop.advice;

import org.aspectj.lang.JoinPoint;

import co.kr.mono.aop.utill.UtilLib;

public class SecurtyAop {

	public void displayLine() {
		System.out.println(UtilLib.lpad("*", 50, "*"));
	}
	
	public void logAfterReturning(JoinPoint joinPoint, Object retVal) {
		
		String signatureStr = joinPoint.getSignature().toString();
		System.out.println("After Returning 내부 결과 출력 ");
		System.out.println("### : " + signatureStr + "\n### : 실행 결과 [" + retVal + "]");
	}
	
}
