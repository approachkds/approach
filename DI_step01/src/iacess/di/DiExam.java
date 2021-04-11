package iacess.di;

import iacess.di.entity.Hello;
import iacess.di.ui.ColorPrinter;
import iacess.di.ui.MonoPrinter;
import iacess.di.ui.Printer;

public class DiExam {

	public static void main(String[] args) {
		
		/* constructor 방식*/
		/*
		//Printer printer = new ColorPrinter();
		Printer printer = new MonoPrinter();
		Hello hello = new Hello(printer);
		hello.setPrinter(printer);
		hello.print("Hello");
		*/
		
		// set 방식
		//Printer printer = new MonoPrinter();
		Printer printer = new ColorPrinter();
		
		
		Hello hello = new Hello();
		hello.setPrinter(printer);
		hello.print("hello");
	}
	
}
