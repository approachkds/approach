package proxy.test;

import proxy.entity.Hello;
import proxy.ui.ColorPrinter;
import proxy.ui.Printer;
import proxy.ui.ProxyPrinter;

public class ProxyTest {

	public static void main(String[] args) {

		Printer p = new ProxyPrinter(new ColorPrinter());
		
//		Printer p = new ColorPrinter();
		
		Hello hello = new Hello(p);
		hello.printMag("안녕하세요......");
	}

}
