package iacess.di.entity;

public class Car implements Comparable<Car>{

	private String name;
	private int price;
	
	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public int compareTo(Car c) {
		
		int comPrice = c.getPrice();
		
		return this.price-comPrice;
		
	}
	
}
