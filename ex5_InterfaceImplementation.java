package exercises;

import Interfaces.ex5_Interface;

public class ex5_InterfaceImplementation implements ex5_Interface{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex5_InterfaceImplementation obj = new ex5_InterfaceImplementation();
		obj.artist();
		obj.doc();
		obj.singer();
	}

	@Override
	public void doc() {
		// TODO Auto-generated method stub
		System.out.println("Doctor implemented");
		
	}

	@Override
	public void artist() {
		// TODO Auto-generated method stub
		System.out.println("Artist implemented");
		
	}

	@Override
	public void singer() {
		// TODO Auto-generated method stub
		System.out.println("Singer implemented");
		
	}

}
