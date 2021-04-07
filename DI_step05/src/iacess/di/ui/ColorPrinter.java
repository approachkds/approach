package iacess.di.ui;

public class ColorPrinter implements Printer {

	@Override
	public void print(String s) {

		System.out.println("----- Color Printer Start-----");
		System.out.println(s);
		System.out.println("----- Color Printer End-----");
		
	}

}
