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
		System.out.println("Hourly Worker ID: " + id);
		System.out.println("Hourly Worker name: " + name);
		System.out.println("Hourly Worker number of holidays: " + numHolidays);
		try {
			System.out.println("Hourly Worker salary for the week: " + String.format("%.2f", calculateSalary()));
			System.out.println("Hourly Worker manager name: " + managerName);
			System.out.println("Hourly Worker fee: " + String.format("%.2f", calculateFee()));
		} catch (SalaryException e) {
			System.out.println(e.getMessage());
		} // try catch exception
		System.out.println("=======================================================================");
	} // display()

	// implement interface method
	@Override
	public float calculateFee() {
		return hourlyRate * .05F;
	} // calculateFee()
	
	// override equals method
	@Override
	public boolean equals(Object obj){
		HourlyWorker other = (HourlyWorker)obj;
		if(other.id==id 
				&& other.name==name 
				&& other.numHolidays==numHolidays
				&& other.name==name
				&& other.overtime==overtime
				)
			return true;
		else
			return false;
	} // equals()
	
	public static void main(String[] args) {
		// compare 2 objects
		HourlyWorker myHusbandsAccount = new HourlyWorker("007", "Alex", 10.00F, 10);
		HourlyWorker myWifesAccount = new HourlyWorker("007", "Alex", 10.00F, 10);
		System.out.println(myHusbandsAccount.equals(myWifesAccount));
	} // main

} // class
