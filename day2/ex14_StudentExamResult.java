package exercises;

import java.util.Random;
import java.util.Scanner;

public class ex14_StudentExamResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student student = new Student();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter name and roll no: ");
		student.name = s.nextLine();
		student.rollNo = s.nextInt();
		student.writeExam();
		student.afterExam();
		
	} 

}

class Student{
	String name;
	int rollNo;
	Exam exam;

	void writeExam() {
		exam = new Exam();
		exam.detailsOfStudent(name,rollNo);	
	}
	
	void afterExam() {
		exam.calculateMark();
	}
}

class Exam extends Student {
	
	float m1,m2,m3;
	Result result;

	public void detailsOfStudent(String name, int rollNo) {
		System.out.println("Student name: "+name);
		System.out.println("Roll no: "+rollNo);	
	}

	public void calculateMark() {
		m1 = (float) (Math.random() * (100 - 0) + 0);
		m2 = (float) (Math.random() * (100 - 0) + 0);
		m3 = (float) (Math.random() * (100 - 0) + 0);
		result = new Result();
		result.calculateTotalMark(m1,m2,m3);
	}
	
}

class Result extends Exam{

	float totalmark;

	void calculateTotalMark(float m1,float m2,float m3) {
		System.out.printf("Marks are %.1f, %.1f, %.1f",m1,m2,m3);
		totalmark = m1+m2+m3;
		System.out.printf("\nTotal mark: %.1f",totalmark);
	}
}
