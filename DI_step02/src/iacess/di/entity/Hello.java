package iacess.di.entity;

import iacess.di.ui.Printer;

public class Hello {

	private Printer printer;

	public Hello() {
		
	};
	
	public Hello(Printer printer) {
		this.printer = printer;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	};
	
	
	public void print(String s) {
		printer.print(s);
	}
	
}
