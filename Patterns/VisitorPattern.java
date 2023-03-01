package Patterns;

import java.util.Scanner;


//Visitor lets you define a new operation without changing the classes of the elements on which it operates.
public class VisitorPattern {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter item to play with dog:");
		Child child = new Child();
		Dog dog = new Dog();
		String item = s.nextLine();
		child.playWithDog(dog, item);
	}
	
}

class Child{
	void playWithDog(Dog dog,String item) {
		try {
			dog.play(item);
		}
		catch(DogExceptions de) {
			System.out.println(de);
			de.visit();
		}
	}
	
}

class Dog{
	void play(String item) throws DogExceptions {
		if(item.equals("shoe")) {
			throw new DogBiteException("I will bite you if you throw a shoe at me!!!");
		}
		else if(item.equals("stone")) {
			throw new DogBarkException("I will bark you if you throw a stone at me!!!");
		}
		else if(item.equals("biscuit")) {
			throw new DogLickException("I will happy if!!!");
		}
	}
}

abstract class Handler911{
	public abstract void handle(DogBiteException dbe);
	public abstract void handle(DogBarkException dbee);
	public abstract void handle(DogLickException dbee);
}

class HandlerImplementation extends Handler911{

	@Override
	public void handle(DogBiteException dbe) {
		// TODO Auto-generated method stub
		System.out.println("Go to hospital!!!");
		
	}

	@Override
	public void handle(DogBarkException dbee) {
		// TODO Auto-generated method stub
		System.out.println("Run!!!");
		
	}

	@Override
	public void handle(DogLickException dbee) {
		// TODO Auto-generated method stub
		System.out.println("Continue to play with dog!!");
		
	}
	
}

abstract class DogExceptions extends Exception{
	abstract void visit();
}

class DogBiteException extends DogExceptions{
	String msg;
	public DogBiteException(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.msg;
	}
	@Override
	void visit() {
		// TODO Auto-generated method stub
		Handler911 handler911 = new HandlerImplementation();
		handler911.handle(this);
	}
	
}

class DogBarkException extends DogExceptions{
	String msg;
	public DogBarkException(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.msg;
	}
	@Override
	void visit() {
		// TODO Auto-generated method stub
		Handler911 handler911 = new HandlerImplementation();
		handler911.handle(this);
		
	}
	
}

class DogLickException extends DogExceptions{
	String msg;
	public DogLickException(String msg) {
		// TODO Auto-generated constructor stub
		this.msg = msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.msg;
	}
	@Override
	void visit() {
		// TODO Auto-generated method stub
		Handler911 handler911 = new HandlerImplementation();
		handler911.handle(this);
		
	}
	
}