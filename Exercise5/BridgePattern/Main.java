package BridgePattern;

//Structural design pattern

//Instead of creating Usha 3- table,Usha 4- table, we are splitting everything and then giving the reference of the manufacturer interface directly to the furniture abstract class
//So usha can now create both types of table based on the input given at runtime

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Furniture ushaFurniture = new UshaFurniture(new ThreeLegTableFurnitureManufacturer(),3,"brown","wood");
		ushaFurniture.getManufacturedFurniture();
		
		System.out.println();
		
		Furniture abcFurniture = new ABCFurniture(new FourLegTableFurnitureManufacturer(),4,"pink","teak");
		abcFurniture.getManufacturedFurniture();
	}

}
