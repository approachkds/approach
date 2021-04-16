package proxy.entity;

import proxy.ui.Printer;

public class Hello {

	Printer p;
	
	public Hello(Printer p) {
		this.p = p;
	}
	
	public void printMag(String s) {
		p.print(s);
	}
}
