package co.kr.mono.aop.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iacess.di.ui.Printer;

public class Person {

	String name;
	String major;
	ArrayList<ExamScore> examList;
	private Printer printer;
	
	public Person() {
		
	}

	public Person(String name, String major, ArrayList<ExamScore> examList, Printer printer) {
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

	public ArrayList<ExamScore> getExamList() {
		return examList;
	}

	public void setExamList(ArrayList<ExamScore> examList) {
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
	
	public HashMap<String, Float> getTot() {
		
		ArrayList<ExamScore> exams = this.getExamList();
		HashMap<String, Float> gradeAvg = new HashMap<>();
		
		for(ExamScore exam : exams) {
			Float avg = (float)(exam.getKor() + exam.getEng() + exam.getMat());
			gradeAvg.put(exam.getGrade(), avg);
		}
		System.out.println("====> getTot 내부 실행 : " + gradeAvg);
		return gradeAvg;
				
	}
	
	public HashMap<String, Float> getTot(String grade) {
		
		ArrayList<ExamScore> exams = this.getExamList();
		HashMap<String, Float> gradeAvg = new HashMap<>();
		
		for(ExamScore exam  :  exams) {
			if(exam.getGrade().equals(grade)) {
				Float avg = (float)(exam.getKor() + exam.getEng() + exam.getMat()) / 3;
				gradeAvg.put(exam.getGrade(), avg);
			}
		}
		return gradeAvg;
	}
	
}
