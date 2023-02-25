package exercises;

import java.util.Scanner;
import java.lang.Math;

public class ex2_CalculateAreaVolume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		Circle c = new Circle();
		Square square = new Square();
		Triangle triangle = new Triangle();
		Sphere sphere = new Sphere();
		Cuboid cuboid = new Cuboid();
		
		System.out.println("Enter the shape you want:");
		String str = s.nextLine();
		
		switch(str) {
		case "circle":
			System.out.println("Enter the radius: ");
			c.radius = s.nextDouble();
			c.calculateArea();
			c.calculatePerimeter();
			break;
		case "square":
			System.out.println("Enter the side: ");
			square.side = s.nextDouble();
			square.calculateArea();
			square.calculatePerimeter();
			break;
		case "triangle":
			System.out.println("Enter 3 sides: ");
			triangle.sideA = s.nextDouble();
			triangle.sideB = s.nextDouble();
			triangle.sideB = s.nextDouble();
			triangle.calculateArea();
			triangle.calculatePerimeter();
			break;
		case "sphere":
			System.out.println("Enter the radius: ");
			sphere.radius = s.nextDouble();
			sphere.calculateArea();
			sphere.calculatePerimeter();
			sphere.calculateSurfaceArea();
			sphere.calculateVolume();
			break;
		case "cuboid":
			System.out.println("Enter the side: ");
			cuboid.side = s.nextDouble();
			cuboid.calculateArea();
			cuboid.calculatePerimeter();
			cuboid.calculateSurfaceArea();
			cuboid.calculateVolume();
			break;
			
		}
	}

}

interface CalcArea{
	void calculateArea();
}

interface CalcVolume{
	void calculateVolume();
}

interface CalcPerimeter{
	void calculatePerimeter();
}

interface CalcSurfaceArea{
	void calculateSurfaceArea();
}

class Circle implements CalcArea,CalcPerimeter{
	
	double pi = Math.PI;
	double radius;
	@Override
	public void calculatePerimeter() {
		// TODO Auto-generated method stub
		double perimeter = 2*pi*radius;
		System.out.println("Perimeter of circle is "+perimeter);
	}

	@Override
	public void calculateArea() {
		// TODO Auto-generated method stub
		double area = pi*radius*radius;
		System.out.println("Area of circle is "+area);
	}
	
}

class Square implements CalcArea,CalcPerimeter{
	double side;
	@Override
	public void calculatePerimeter() {
		// TODO Auto-generated method stub
		double perimeter = side*side;
		System.out.println("Perimeter of square is "+perimeter);
		
	}

	@Override
	public void calculateArea() {
		// TODO Auto-generated method stub
		double area = 4*side;
		System.out.println("Area of square is "+area);
		
	}
	
}

class Triangle implements CalcArea,CalcPerimeter{
	double sideA,sideB,sideC;
	@Override
	public void calculatePerimeter() {
		// TODO Auto-generated method stub
		double perimeter = sideA+sideB+sideC;
		System.out.println("Perimeter of triangle is "+perimeter);
		
	}

	@Override
	public void calculateArea() {
		// TODO Auto-generated method stub
		double area = 0.5*sideA*sideB;
		System.out.println("Area of triangle is "+area);
		
	}
	
}

class Sphere implements CalcArea,CalcVolume,CalcSurfaceArea,CalcPerimeter{
	double pi = Math.PI;
	double radius;
	@Override
	public void calculatePerimeter() {
		// TODO Auto-generated method stub
		double perimeter = pi*radius*radius;
		System.out.println("Perimeter of sphere is "+perimeter);
		
	}

	@Override
	public void calculateSurfaceArea() {
		// TODO Auto-generated method stub
		double surfaceArea = 4*pi*radius*radius;
		System.out.println("Surface area of sphere is "+surfaceArea);
		
	}

	@Override
	public void calculateVolume() {
		// TODO Auto-generated method stub
		double volume = (4/3)*pi*radius*radius*radius;
		System.out.println("Volume of sphere is "+volume);
	}

	@Override
	public void calculateArea() {
		// TODO Auto-generated method stub
		double area = 2*pi*radius;
		System.out.println("Area of sphere is "+area);
		
	}
	
}

class Cuboid implements CalcArea,CalcVolume,CalcSurfaceArea,CalcPerimeter{
	double side;
	@Override
	public void calculatePerimeter() {
		// TODO Auto-generated method stub
		double perimeter = side*side;
		System.out.println("Perimeter of cuboid is "+perimeter);
		
	}

	@Override
	public void calculateSurfaceArea() {
		// TODO Auto-generated method stub
		double surfaceArea = 6*side*side;
		System.out.println("Surface area of cuboid is "+surfaceArea);
		
	}

	@Override
	public void calculateVolume() {
		// TODO Auto-generated method stub
		double volume = side*side*side;
		System.out.println("Volume of cuboid is "+volume);
		
	}

	@Override
	public void calculateArea() {
		// TODO Auto-generated method stub
		double area = 4*side;
		System.out.println("Area of cuboid is "+area);
		
	}
	
}
