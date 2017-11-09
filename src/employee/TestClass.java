package employee;

public class TestClass {

	public static void main(String[] args) {
		// create PermanentEmployee object
		PermanentEmployee joe = new PermanentEmployee("003", "Joe", 10.00F, 20);
		joe.display();
		
		// create HourlyWorker object
		HourlyWorker mary = new HourlyWorker("004", "Mary", 9.00F, 10, "Jill", 5);
		mary.display();
		
		// create Manager object
		Manager jill = new Manager("001", "Jill", 30.00F, 0, 10);
		jill.setManagerBonus(1000);
		jill.display();
		
	} // main

} // class
