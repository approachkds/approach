package proxy.ui;

public class ProxyPrinter implements Printer {

	Printer p;
	
	public ProxyPrinter(Printer p) {
		this.p = p;
	}
	
	@Override
	public void print(String s) {

		System.out.println("=====[Proxy Before work]=====");
		p.print(s);
		System.out.println("=====[Proxy after work]=====");
	}

}
