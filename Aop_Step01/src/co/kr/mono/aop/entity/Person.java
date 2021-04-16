package co.kr.mono.aop.entity;

import java.util.List;

import iacess.di.ui.Printer;

public class Person {

	String name;
	String major;
	List<ExamScore> examList;
	private Printer printer;
	
	public Person() {
		
	}

	public Person(String name, String major, List<ExamScore> examList, Printer printer) {
		super();
		this.name = name;
		this.major = major;
		this.examList = examList;
		this.printer = printer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<ExamScore> getExamList() {
		return examList;
	}

	public void setExamList(List<ExamScore> examList) {
		this.examList = examList;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public void print() {
		
		String str = "Person [name=]" + name + ", major=" + major + "]\n"
				+ "ExamList=" + examList + "]";
		
		printer.print(str);
	}
	
	
}
