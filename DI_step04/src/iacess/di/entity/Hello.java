package iacess.di.entity;

import iacess.di.ui.Printer;

public class Hello {

	private Printer printer;
	private String name = " ";

	public Hello() {
		
	};
	
	public Hello(Printer printer, String name) {
		System.out.println("constructor 2 parameter");
		this.printer = printer;
		this.name = name;
	}
	public Hello(Printer printer) {
		System.out.println("constructor 1 parameter");
		this.printer = printer;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void print(String s) {
		
		if(this.name != null) {
			printer.print(this.name + "" + s) ;
		} else {
			printer.print(s);
		}
	}
	
}
