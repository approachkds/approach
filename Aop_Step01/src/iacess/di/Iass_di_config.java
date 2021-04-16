package iacess.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import iacess.di.entity.Hello;
import iacess.di.ui.ColorPrinter;
import iacess.di.ui.MonoPrinter;

@ComponentScan({"iacess.di.ui, iacess.di.entity"})
@Configuration


public class Iass_di_config {

	@Bean
	public Hello hello () {
		return new Hello();
	}
	
	@Bean
	public ColorPrinter colorPrinter() {
		return new ColorPrinter();
	}
	
	@Bean
	public MonoPrinter momoPrinter() {
		return new MonoPrinter();
	}
	
}

