package BridgePattern;

public class ThreeLegTableFurnitureManufacturer implements FurnitureManufacturer{
	@Override
	public void makeFurniture(int legs, String colour, String material) {
		// TODO Auto-generated method stub
		System.out.println("A "+colour+" coloured table with "+legs+" legs has been made of "+material);
		
	}
}
