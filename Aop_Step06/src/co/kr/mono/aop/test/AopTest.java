package co.kr.mono.aop.test;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.mono.aop.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:co/kr/mono/aop/test/config.xml")

public class AopTest {

	@Autowired
	ApplicationContext context;
	public static String loginName = "강감찬";
	
	@Test
	
	public void bean1() {
		
		Person person = context.getBean(Person.class);
		
		/* 
		System.out.println("\n### STEP0 : 클라이언트 person.print() 호출");
		person.print();
		*/
		
		/*
		System.out.println("\n### STEP0");
		Set<Map.Entry<String, Float>> entries = person.getTot("1").entrySet();
		System.out.println("\n### Client 결과");
		*/
		
		System.out.println("\n### STEP0");
		person.printThrowException();
		
		
		//person.printThrowException();
		
	}
	
}
