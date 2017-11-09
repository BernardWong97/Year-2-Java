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
	
	public PermanentEmployee(String id, String name, float hourlyRate, int numHolidays, float overtime) {
		this(id, name, hourlyRate, numHolidays);
		this.overtime = overtime;
	}
	

	// Override abstract methods
	@Override
	public double calculateSalary() {
		
		// calculate weekly salary
		weeklySalary = hourlyRate * normalNumOfHours;
		
		if(overtime > 0) {
			weeklySalary += (overtime * hourlyRate * 2);
		}// if overtime, hourly rate doubled
		
		return weeklySalary;
	} // calculateSalary

	@Override
	public void display() {
		System.out.println("Permanent Employee ID: " + id);
		System.out.println("Permanent Employee name: " + name);
		System.out.println("Permanent Employee number of holidays: " + numHolidays);
		System.out.println("Permanent Employee weekly salary: " + String.format("%.2f", calculateSalary()));
		System.out.println("=======================================================================");
	} // display()

} // class
