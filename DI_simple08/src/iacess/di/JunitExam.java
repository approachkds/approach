package iacess.di;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import iacess.di.entity.Hello;
import iacess.di.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:iacess/di/config.xml")

public class JunitExam {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void bean1() {
		Hello hello = context.getBean(Hello.class);
		
		/* List 정렬 */
		List<Person> persons = hello.getPersons();
		Collections.sort(persons);
		
		for(Person p : persons) {
			System.out.println(p.getName());
		}
		
		for(Person p : persons) {
			System.out.println(p.getAge());
		}
	
		
	}
	
}
