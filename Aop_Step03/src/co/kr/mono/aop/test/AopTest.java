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
		
		Set<Map.Entry<String, Float>> entries = person.getTot().entrySet();
		
		System.out.println("Client Test 결과 출력");
		
		for(Map.Entry<String, Float> entry : entries ) {
			System.out.println("key: " + entry.getKey());
			System.out.println(", Value: " + String.format("%.1f", entry.getValue()));
		}
		
	}
	
}
