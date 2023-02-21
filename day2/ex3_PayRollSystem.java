package exercises;

import java.util.Scanner;

public class ex3_PayRollSystem {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter employee type:");
		String className = s.nextLine();
		className = "exercises." + className;
		Employee employee = (Employee)Class.forName(className).getConstructor().newInstance() ;
		System.out.println("Enter date,month and year:");
		int date = s.nextInt();
		int month = s.nextInt();
		int year = s.nextInt();
		System.out.println("Enter the no. of hours worked:");
		int noOfHours = s.nextInt();
		employee.noOfHoursWorked = noOfHours;
		employee.dateOfJoining = new Date(date,month,year);
		System.out.println("Employee details:");
		employee.printDetails();
	}

}

abstract class Employee{
	
	Date dateOfJoining;
	double grossPay;
	int noOfHoursWorked;
	int payPerHour;
	abstract void printDateOfJoining(Date date);
	abstract void printDetails();
	abstract void printGrossPay();
}
class Date{
	int day,month,year;
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

}
class SalesPerson extends Employee{
	public SalesPerson() {
		
	}
	
	@Override
	void printDateOfJoining(Date dateOfJoining) {
		// TODO Auto-generated method stub
		System.out.println("Date of joining:"+dateOfJoining.day+"/"+dateOfJoining.month+"/"+dateOfJoining.year);
	}
	
	@Override
	void printGrossPay() {
		// TODO Auto-generated method stub
		payPerHour = 2000;
		System.out.println("Gross pay is:"+(payPerHour*noOfHoursWorked));
	}
	
	void printDetails() {
		printDateOfJoining(dateOfJoining);
		printGrossPay();
	}
	
	
}

class Worker extends Employee{

	@Override
	void printDateOfJoining(Date ddateOfJoiningate) {
		// TODO Auto-generated method stub
		System.out.println(dateOfJoining.day+"/"+dateOfJoining.month+"/"+dateOfJoining.year);
	}
	@Override
	void printGrossPay() {
		// TODO Auto-generated method stub
		payPerHour = 4000;
		System.out.println("Gross pay is:"+(payPerHour*noOfHoursWorked));
	}
	@Override
	void printDetails() {
		printDateOfJoining(dateOfJoining);
		printGrossPay();
	}
	
}


class SalesManager extends SalesPerson{

	@Override
	void printDateOfJoining(Date dateOfJoining) {
		// TODO Auto-generated method stub
		System.out.println(dateOfJoining.day+"/"+dateOfJoining.month+"/"+dateOfJoining.year);
	}
	
	@Override
	void printGrossPay() {
		// TODO Auto-generated method stub
		payPerHour = 6000;
		System.out.println("Gross pay is:"+(payPerHour*noOfHoursWorked));
	}
	
	void printDetails() {
		printDateOfJoining(dateOfJoining);
		printGrossPay();
	}
}

class SalesTerritoryManager extends SalesManager{

	@Override
	void printDateOfJoining(Date dateOfJoining) {
		// TODO Auto-generated method stub
		System.out.println(dateOfJoining.day+"/"+dateOfJoining.month+"/"+dateOfJoining.year);
	}
	
	@Override
	void printGrossPay() {
		// TODO Auto-generated method stub
		payPerHour = 6000;
		System.out.println("Gross pay is:"+(payPerHour*noOfHoursWorked));
	}
	
	void printDetails() {
		printDateOfJoining(dateOfJoining);
		printGrossPay();
	}
	
}