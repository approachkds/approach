package iacess.di;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import iacess.di.entity.Hello;
import iacess.di.ui.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:iacess/di/config.xml")


public class junitExam {

	@Autowired
	ApplicationContext context;
	
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("iacess/di/config.xml");
		System.out.println("컨테이너 생성 " + this);
	}
	
	@Test
	public void bean1() {
		System.out.println("컨테이너 : " + context);
		System.out.println("bean1() :" + this);
		Hello hello = context.getBean(Hello.class);
		assertEquals("SPRING", hello.getName());
		hello.print("hello");
	}
	
	@Test
	public void bean2() {
		System.out.println("컨테이너 : " + context);
		System.out.println("bean2() : " + this);
		Printer printer = context.getBean(Printer.class);
		
		Printer printer2 = context.getBean("printer", Printer.class);
		
		assertSame(printer, printer2);
	}
	
}
