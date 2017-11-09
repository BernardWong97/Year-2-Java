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
	public double calculateSalary() throws SalaryException {
		// Throw exception
		if(normalNumOfHours + overtime > 100) {
			throw new SalaryException("The number of hours worked has exceeded 100 hours");
		} // if throw exception
		
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
		try {
			System.out.println("Permanent Employee salary for the week: " + String.format("%.2f", calculateSalary()));
		} catch (SalaryException e) {
			System.out.println(e.getMessage());
		} // try catch exception
		System.out.println("=======================================================================");
	} // display()

} // class
