package BridgePattern;

public class FourLegTableFurnitureManufacturer implements FurnitureManufacturer{
	@Override
	public void makeFurniture(int legs, String colour, String material) {
		// TODO Auto-generated method stub
		System.out.println("A "+colour+" coloured table with "+legs+" legs was made of "+material);
	}
}
