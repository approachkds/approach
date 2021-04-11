package iacess.di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import iacess.di.entity.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:iacess/di/config.xml")


public class junitExam {

	@Autowired
	ApplicationContext context;
	
	
	@Test
	public void bean1() {
		
		Hello hello = context.getBean(Hello.class);
		System.out.println("hello");
		hello.print("hello");
		
	}
	
	
}
