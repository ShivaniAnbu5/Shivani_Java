package BridgePattern;


public class ABCFurniture extends Furniture {
	
	private int legs;
	private String color,material;


	public ABCFurniture(FurnitureManufacturer furnitureManufacturer, int legs, String color, String material) {
		super(furnitureManufacturer);
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