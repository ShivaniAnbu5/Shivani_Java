package RandDPatterns;



//Structural design pattern

//Instead of creating Usha 3- table,Usha 4- table, we are splitting everything and then giving the reference of the manufacturer interface directly to the furniture abstract class
//So usha can now create both types of table based on the input given at runtime
public class BridgePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Furniture ushaFurniture = new UshaFurniture(new ThreeLegTableFurnitureManufacturer(),3,"brown","wood");
		ushaFurniture.getManufacturedFurniture();
		
		System.out.println();
		
		Furniture abcFurniture = new ABCFurniture(new FourLegTableFurnitureManufacturer(),4,"pink","teak");
		abcFurniture.getManufacturedFurniture();
	}

}





interface FurnitureManufacturer{
	void makeFurniture(int legs,String colour,String material);
}

class ThreeLegTableFurnitureManufacturer implements FurnitureManufacturer{

	@Override
	public void makeFurniture(int legs, String colour, String material) {
		// TODO Auto-generated method stub
		System.out.println("A "+colour+" coloured table with "+legs+" legs has been made of "+material);
		
	}
	
}

class FourLegTableFurnitureManufacturer implements FurnitureManufacturer{

	@Override
	public void makeFurniture(int legs, String colour, String material) {
		// TODO Auto-generated method stub
		System.out.println("A "+colour+" coloured table with "+legs+" legs was made of "+material);
	}
	
}







abstract class Furniture{
	
	FurnitureManufacturer furnitureManufacturer;
	
	public Furniture(FurnitureManufacturer furnitureMakingAPI) {
		// TODO Auto-generated constructor stub
		this.furnitureManufacturer = furnitureMakingAPI;
	}
	
	abstract void getManufacturedFurniture();
}

class  UshaFurniture extends Furniture{
	
	private int legs;
	private String color,material;


	public UshaFurniture(FurnitureManufacturer furnitureMakingAPI, int legs, String color, String material) {
		super(furnitureMakingAPI);
		this.legs = legs;
		this.color = color;
		this.material = material;
	}


	@Override
	public String toString() {
		return "UshaFurniture ";
	}


	@Override
	void getManufacturedFurniture() {
		// TODO Auto-generated method stub
		System.out.println(this);
		furnitureManufacturer.makeFurniture(legs,color,material);
		
	}
	
}

class  ABCFurniture extends Furniture{
	
	private int legs;
	private String color,material;


	public ABCFurniture(FurnitureManufacturer furnitureMakingAPI, int legs, String color, String material) {
		super(furnitureMakingAPI);
		this.legs = legs;
		this.color = color;
		this.material = material;
	}
	
	@Override
	public String toString() {
		return "ABCFurniture ";
	}

	@Override
	void getManufacturedFurniture() {
		// TODO Auto-generated method stub
		System.out.println(this);
		furnitureManufacturer.makeFurniture(legs,color,material);
		
	}
	
}