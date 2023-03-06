package BridgePattern;


public class UshaFurniture extends Furniture {
	
	private int legs;
	private String color,material;


	public UshaFurniture(FurnitureManufacturer furnitureManufacturer, int legs, String color, String material) {
		super(furnitureManufacturer);
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