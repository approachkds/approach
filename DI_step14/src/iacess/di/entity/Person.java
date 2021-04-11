package iacess.di.entity;

public class Person implements Comparable<Person> {

	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
	public Person(String name, int age ) {
		this.name=name;
		this.age=age;
	}
	public Person() {
		
	}
	
	@Override
	public int compareTo(Person arg0) {
		// TODO Auto-generated method stub
		return this.name.compareTo(arg0.name);
	}

}
