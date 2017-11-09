package employee;

public class HourlyWorker extends Employee implements UnionMember{
	// Variables
	int numHolidays;
	String managerName;

	// Constructors
	public HourlyWorker(String id, String name, float hourlyRate, int numHolidays) {
		this.id = id;
		this.name = name;
		this.hourlyRate = hourlyRate;
		this.numHolidays = numHolidays;
	}
	
	public HourlyWorker(String id, String name, float hourlyRate, int numHolidays, String managerName, float overtime) {
		this(id, name, hourlyRate, numHolidays);
		this.overtime = overtime;
		this.managerName = managerName;
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
		System.out.println("Hourly Worker ID: " + id);
		System.out.println("Hourly Worker name: " + name);
		System.out.println("Hourly Worker number of holidays: " + numHolidays);
		System.out.println("Hourly Worker weekly salary: " + String.format("%.2f", calculateSalary()));
		System.out.println("Hourly Worker manager name: " + managerName);
		System.out.println("Hourly Worker fee: " + String.format("%.2f", calculateFee()));
		System.out.println("=======================================================================");
	} // display()

	// implement interface method
	@Override
	public float calculateFee() {
		return hourlyRate * .05F;
	} // calculateFee()

} // class
