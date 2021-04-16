package iacess.di.ui;

import org.springframework.stereotype.Component;

@Component
public class MonoPrinter implements Printer {

	@Override
	public void print(String s) {

		System.out.println("----- Mono Printer Start-----");
		System.out.println(s);
		System.out.println("----- Mono Printer End-----");
		
	}

}
