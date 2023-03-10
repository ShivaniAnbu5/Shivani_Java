package BridgePattern;


public abstract class Furniture {
	
	FurnitureManufacturer furnitureManufacturer;
	
	public Furniture(FurnitureManufacturer furnitureManufacturer) {
		// TODO Auto-generated constructor stub
		this.furnitureManufacturer = furnitureManufacturer;
	}
	
	abstract void getManufacturedFurniture();
}