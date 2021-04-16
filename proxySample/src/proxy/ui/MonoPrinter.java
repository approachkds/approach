package proxy.ui;

public class MonoPrinter implements Printer {

	@Override
	public void print(String s) {

		System.out.println("=====[Mono Printer Start]=====");
		System.out.println(s);
		System.out.println("=====ColorPrinter.java[Mono Printer End]=====");
	}

}
