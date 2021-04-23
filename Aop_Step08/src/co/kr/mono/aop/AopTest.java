package co.kr.mono.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.mono.aop.entity.Business01Proc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:co/kr/mono/aop/config.xml")

public class AopTest {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void bean1() {
		
		Business01Proc bisComponent01 = context.getBean(Business01Proc.class);
		
		/*
		bisComponent01.cmdComponent01();
		*/
		
		String cmdMap01 = bisComponent01.cmdComponent02("Test");
		System.out.println(cmdMap01);
	}
	
}
