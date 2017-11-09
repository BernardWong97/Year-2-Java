package employee;

public final class PermanentEmployee extends Employee {
	// Variables
	int numHolidays;

	// Constructors
	public PermanentEmployee(String id, String name, float hourlyRate, int numHolidays) {
		this.id = id;
		this.name = name;
		this.hourlyRate = hourlyRate;
		this.numHolidays = numHolidays;
	}

	// Override abstract methods
	@Override
	public double calculateSalary() {
		return hourlyRate * normalNumOfHours;
	} // calculateSalary

	@Override
	public void display() {
		System.out.println("Permanent Employee ID: " + id);
		System.out.println("Permanent Employee name: " + name);
		System.out.println("Permanent Employee number of holidays: " + numHolidays);
		System.out.println("Permanent Employee weekly salary: " + calculateSalary());
	} // display()

	public static void main(String[] args) {
		// create test object
		PermanentEmployee joe = new PermanentEmployee("003", "Joe", 10.00F, 20);
		joe.display();

	} // main

}