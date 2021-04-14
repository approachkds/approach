package iacess.di.entity;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Car c1 = new Car("k5", 2000);
		Car c2 = new Car("A6", 8000);
		Car c3 = new Car("BMW3", 4000);
		
		Car[] cars = {c1, c2, c3};
		
		Arrays.sort(cars);
		
		for(Car tmp : cars) {
			System.out.println(tmp.getName() + " ");
		}
		
	}

	
}
