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
	public double calculateSalary() {
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
		System.out.println("Manager salary for the week: " + String.format("%.2f", calculateSalary()));
		System.out.println("Manager bonus: " + String.format("%.2f", managerBonus));
		System.out.println("Share Value: " + String.format("%.2f", shareValue));
		System.out.println("=======================================================================");
	} // display()

} // class
