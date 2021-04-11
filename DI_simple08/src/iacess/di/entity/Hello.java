package iacess.di.entity;

import java.util.List;

import iacess.di.ui.Printer;

public class Hello {

	private Printer printer;
	private List<Person> persons;

	public Hello() {
		
	};
	
	public Hello(Printer printer) {
		this.printer = printer;
	}
	
	


	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
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
