package iacess.di.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import iacess.di.ui.Printer;

@Component
public class Hello {

	// 프로퍼티
	@Autowired // 프로퍼티가 없어도 당장 오류가 나지 않는다.
	@Qualifier("monoPrinter")
	private Printer printer;

	
	public void print(String s) {
		printer.print(s);
	}
	
	
	
	

	
 	
}
