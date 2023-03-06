package Patterns;

//The Factory Method pattern is a creational design pattern used to define a runtime interface for creating an object. It's called a factory because it creates various types of objects without necessarily knowing what kind of object it creates or how to create it
//Define an interface for creating an object, but let subclasses decide which class to instantiate
	public class FactoryPattern {
		public static void main(String[] args)throws Exception {
			
			FurnitureShop shop=SpringFramework.getShop();
			System.out.println(shop.sellFurniture(new Customer()));
			
			
		}
	}
	class SpringFramework{
		public static FurnitureShop getShop()throws Exception {
			
			String factoryclassname="Patterns.BataFurnitureFactory";
			String shopclassname="Patterns.AbdulFurnitureShop";
			
			FurnitureFactory factory=(FurnitureFactory)Class.forName(factoryclassname).newInstance();
			FurnitureShop shop=(FurnitureShop)Class.forName(shopclassname).newInstance();
			
			shop.setFactory(factory);
			
			//shop is dependent on factory to get shoes...so factory knowledge should be given to shop
			
			return shop;
		}
	}
	
	
	interface FurnitureManufacturer{
		public Furniture makeFurniture();
	}
	
	abstract class Furniture{
		
	}
	class Table extends Furniture{
		
	}
	class Chair extends Furniture{
		
	}
	
	interface FurnitureSeller{
		public Furniture sellFurniture(Customer customer);
	}
	
	class Customer{
		
	}
	
	
	abstract class FurnitureFactory implements FurnitureManufacturer{
		public abstract Furniture makeFurniture();
	}
	
	
	class BataFurnitureFactory extends FurnitureFactory{
		public BataFurnitureFactory() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public Furniture makeFurniture() {
			// TODO Auto-generated method stub
			return new Table();
		}
	}
	
	class LakhaniFurnitureFactory extends FurnitureFactory{  
		public LakhaniFurnitureFactory() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public Furniture makeFurniture() {
			// TODO Auto-generated method stub
			return new Chair();
		}
	}
	
	
	abstract class FurnitureShop implements FurnitureSeller{
		private FurnitureFactory factory; // factory knowledge given
		public void setFactory(FurnitureFactory factory) {
			this.factory=factory;
		}
		public FurnitureFactory getFactory() {
			return this.factory;
		}
		public abstract Furniture sellFurniture(Customer customer);
	}

	
	class AbdulFurnitureShop extends FurnitureShop{ 
		public AbdulFurnitureShop() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public Furniture sellFurniture(Customer customer) {
			// TODO Auto-generated method stub
			return getFactory().makeFurniture();
		}
	}
	
	class NavinFurnitureShop extends FurnitureShop{
		public NavinFurnitureShop() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public Furniture sellFurniture(Customer customer) {
			// TODO Auto-generated method stub
			return getFactory().makeFurniture();
		}
	}
	