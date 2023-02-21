package exercises;

import java.util.Scanner;

public class ex14_StudentExamResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student student = new Student();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter name and roll no: ");
		student.name = s.nextLine();
		student.rollNo = s.nextInt();
		
		System.out.println("Enter marks for 3 subjects: ");
		Exam exam = new Exam();
		exam.m1 = s.nextFloat();
		exam.m2 = s.nextFloat();
		exam.m3 = s.nextFloat();
		
		student.writeExam(exam);
		exam.calculateMark();
		
	} 

}

class Student{
	String name;
	int rollNo;
	
	void writeExam(Exam exam) {
		exam.detailsOfStudent(name,rollNo);
	}
}

class Exam extends Student{
	
	float m1,m2,m3;
	
	public void detailsOfStudent(String name, int rollNo) {
		System.out.println("Student name: "+name);
		System.out.println("Roll no: "+rollNo);
	}
	
	void calculateMark() {
		Result result = new Result();
		result.calculateTotalMark(m1,m2,m3);
	}
	
}

class Result extends Exam{

	float totalmark;

	void calculateTotalMark(float m1,float m2,float m3) {
		totalmark = m1+m2+m3;
		System.out.println("Total mark: "+totalmark);
	}
}