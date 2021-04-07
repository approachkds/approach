package iacess.di;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iacess.di.entity.Hello;
import iacess.di.ui.Printer;

public class junitExam {

	ApplicationContext context;
	
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("iacess/di/config.xml");
		System.out.println("컨테이너 생성 " + this);
	}
	
	@Test
	public void bean1() {
		System.out.println("bean1 method :" + this);
		Hello hello = (Hello)context.getBean("hello");
		assertEquals("SPRING", hello.getName());
		hello.print("hello");
	}
	
	@Test
	public void bean2() {
		System.out.println("bean2 method :" + this);
		Printer printer = (Printer)context.getBean("printer");
		
		Printer printer2 = context.getBean("printer", Printer.class);
		
		assertSame(printer, printer2);
	}
	
}
