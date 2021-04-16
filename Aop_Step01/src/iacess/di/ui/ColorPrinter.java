package iacess.di.ui;

import org.springframework.stereotype.Component;

@Component // Component 시 클래스명의 이름이 앞의 한 글자가 소문자가 되어 들어간다.
public class ColorPrinter implements Printer {

	@Override
	public void print(String s) {

		System.out.println("----- Color Printer Start-----");
		System.out.println(s);
		System.out.println("----- Color Printer End-----");
		
	}

}
