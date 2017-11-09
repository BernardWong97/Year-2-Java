package employee;

public abstract class Employee {
	// Variables
	String id, name;
	float hourlyRate, normalNumOfHours = 37.5F, overtime, weeklySalary;
	static float shareValue; // static variable
	
	// abstract methods
	public abstract double calculateSalary();
	public abstract void display();
	
	// static methods
	public static void setShareValue(float value){
		shareValue = value;
	} // setShareValue()

} // class
