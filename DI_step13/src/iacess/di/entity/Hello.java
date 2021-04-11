package iacess.di.entity;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import iacess.di.ui.Printer;

public class Hello {

	// 프로퍼티
	@Autowired(required=false) // 프로퍼티가 없어도 당장 오류가 나지 않는다.
	@Qualifier("printer1")
	private Printer printer;

	public Hello() {
		
	}

	// 생성자
	@Autowired
	public Hello(@Qualifier("printer1") Printer printer) {
		super();
		this.printer = printer;
	}

	public Printer getPrinter() {
		return printer;
	}

	// getter
	//@Autowired  // 자동주입
	//@Qualifier("printer2")
	@Resource(name="printer2")	// name 값에 직접 값을 넣어준다.
	public void setPrinter(Printer printer) {
		System.out.println();
		this.printer = printer;
	}
	/*
	@Autowired  // 자동주입
	@Qualifier("printer2")
	public void nomalPrinter(Printer printer) {
		this.printer = printer;
		System.out.println();
	}
	*/
	public void print(String s) {
		printer.print(s);
	}
	
	
	
	

	
 	
}
