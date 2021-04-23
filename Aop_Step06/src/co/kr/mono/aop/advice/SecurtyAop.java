package co.kr.mono.aop.advice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import co.kr.mono.aop.test.AopTest;
import co.kr.mono.aop.utill.UtilLib;

public class SecurtyAop {

	public void displayLine() {
		System.out.println(UtilLib.lpad("*", 50, "*"));
	}
	
	public void logBefore(JoinPoint joinPoint) {
		
		String signatureStr = joinPoint.getSignature().toString();
		displayLine();
		
		
		System.out.println("### STEP1 : <aop:before> : 메서드 실행 전에 적용되는 어드바이스" );
		System.out.println("### STEP1 : " + signatureStr + " 시작전");
		
		displayLine();
	}
	
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		String signatureStr = joinPoint.getSignature().toShortString();
		displayLine();
		System.out.println("### STEP2 :<aop:around> : 메서드 호출 이전, 이후, 예외 발생 등 모든 시점에 적용 가능한 어드바이스 형태");
		
		try {
			
			Object result = joinPoint.proceed();
			return result;
		
		} finally {
			
			System.out.println("### STEP2 : " + signatureStr + "around 종료.");
			displayLine();
		}
		
	}
	
	public void logAfterReturning(JoinPoint joinPoint, Object retVal) {
		
		String signatureStr = joinPoint.getSignature().toString();
		displayLine();
		System.out.println("###  STEP3 : " + "<aop:after-returning> : 메서드가 정상적으로 실행항ㄴ 후에 적용되는 어드바이스 정의");
		displayLine();
	}
	
	public void logAfterThrowing(IllegalArgumentException ex) {
		displayLine();
		
		System.out.println("### STPE4 : <aop-throwing>");
		System.out.println("### Step4 : 예외발생 => " + ex.toString());
		displayLine();
		
	}
	
	public void logAfter(JoinPoint joinpoint) {
		String signatureStr = joinpoint.getSignature().toShortString();
		displayLine();
		
		System.out.println("### STEP5 : <aop:after>");
		System.out.println("### STEP5" + signatureStr + " 종료");
		displayLine();

	}
	
}
