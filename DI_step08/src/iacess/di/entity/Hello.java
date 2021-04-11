package iacess.di.entity;

import org.springframework.beans.factory.annotation.Autowired;

import iacess.di.ui.Printer;

public class Hello {

	private Printer printer;

	public Hello() {
		
	}

	public Hello(Printer printer) {
		super();
		this.printer = printer;
	}

	public Printer getPrinter() {
		return printer;
	}

	@Autowired  // 자동주입
	public void setPrinter(Printer printer) {
		System.out.println();
		this.printer = printer;
	}
	
	@Autowired  // 자동주입
	public void nomalPrinter(Printer printer) {
		this.printer = printer;
		System.out.println();
	}
	
	public void print(String s) {
		printer.print(s);
	}
	
	
	
	

	
 	
}
