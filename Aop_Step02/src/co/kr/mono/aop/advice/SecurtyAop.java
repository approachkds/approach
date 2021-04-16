package co.kr.mono.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;

import co.kr.mono.aop.utill.UtilLib;

public class SecurtyAop {

	public void displayLine() {
		System.out.println(UtilLib.lpad("*", 50, "*"));
	}
	
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		String signatureStr = joinPoint.getSignature().toShortString();
		System.out.println("### : " + signatureStr + " 시작.");
		
		long start = System.currentTimeMillis();
		
		try {
			
			Object result = joinPoint.proceed();
			return result;
		
		} finally {
			
			long finish = System.currentTimeMillis();
			
			System.out.println("### : " + signatureStr + " 실행시간:" + (finish - start) + "ms");
			System.out.println("### : " + signatureStr + " 종료.");
		}
		
	}
}
