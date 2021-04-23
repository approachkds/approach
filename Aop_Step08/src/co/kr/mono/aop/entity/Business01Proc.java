package co.kr.mono.aop.entity;

import org.springframework.stereotype.Component;

@Component 
public class Business01Proc {

	public Business01Proc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String cmdComponent01() {
		return "Business01Proc : cmdComponent01 =>" + "NO VALUE";
	}
	public String cmdComponent02(String str) {
		return "Business01Proc : cmdComponent01 =>" + str;
	}
	
}
