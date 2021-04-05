package iacess.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import iacess.di.entity.Hello;

public class DiExam {

	public static void main(String[] args) {
		
		/* contact 방식*/
		/*
		//Printer printer = new ColorPrinter();
		Printer printer = new MonoPrinter();
		Hello hello = new Hello(printer);
		hello.setPrinter(printer);
		hello.print("Hello");
		*/
		
		/*
		// set 방식
		Printer printer = new MonoPrinter();
		//Printer printer = new ColorPrinter();
		Hello hello = new Hello();
		hello.setPrinter(printer);
		hello.print("hello");
		*/
		
		ApplicationContext ctx = new GenericXmlApplicationContext("iacess/di/config.xml");
		
		//Hello hello = (Hello)ctx.getBean("hello");
		Hello hello = ctx.getBean(Hello.class);
		//Hello hello = ctx.getBean("hello", Hello.class);
		
		hello.print("hello");
		
	}
	
}
