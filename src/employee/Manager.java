package employee;

public class Manager extends Employee {
	// Variables
	float managerBonus;
	float weeklySalary, overtime;
	
	// Constructors
	public Manager(String id, String name, float hourlyRate, float bonus) {
		this.id = id;
		this.name = name;
		this.hourlyRate = hourlyRate;
		setManagerBonus(bonus);
	}
	
	public Manager(String id, String name, float hourlyRate, float bonus, float overtime) {
		this(id, name, hourlyRate, bonus);
		this.overtime = overtime;
		setShareValue(40.00F);
	}
	
	// Get/Set Methods
	public void setManagerBonus(float managerBonus) {
		this.managerBonus = managerBonus;
	}
	
	public float getManagerBonus() {
		return managerBonus;
	}

	// override calculate salary method
	@Override
	public double calculateSalary()  throws SalaryException {
		// Throw exception
		if(normalNumOfHours + overtime > 100) {
			throw new SalaryException("The number of hours worked has exceeded 100 hours");
		} // if throw exception
		
		//calculate weekly salary
		weeklySalary = hourlyRate * normalNumOfHours;
		
		if(overtime > 0) {
			weeklySalary += (overtime * hourlyRate * 1.5F);
		} // if overtime, hourly rate is multiplied by 1.5
		
		return weeklySalary;
	} // calculateSalary()

	// override display method
	@Override
	public void display() {
		System.out.println("Manager ID: " + id);
		System.out.println("Manager name: " + name);
		try {
			calculateSalary();
			System.out.println("Manager salary for the week: " + String.format("%.2f", calculateSalary()));
			System.out.println("Manager bonus: " + String.format("%.2f", managerBonus));
			System.out.println("Share Value: " + String.format("%.2f", shareValue));
		} catch (SalaryException e) {
			System.out.println(e.getMessage());
		} // try catch exception
		System.out.println("=======================================================================");
	} // display()
	
	public static void main(String[] args) {
		// set share value
		setShareValue(40.00F);
		
		// share same share value because of static
		Manager jack = new Manager("005", "Jack", 10.00F, 1000);
		Manager sean = new Manager("006", "Sean", 20.00F, 1000);
		jack.display();
		sean.display();
	} // main

} // class
