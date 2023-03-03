package Patterns;

//Allows a finer control over the construction process.
//This pattern allows the construction of a complex object by specifying only its type and content.This way the construction process can be used to create different representations. This can be used again to create a different object from the same set of simple objects as the first one.

public class BuilderPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Meal meal = new Meal.BuildMeal().salad("Veg salad").dessert("Chocolate Icecream").mainDish("Biriyani").build();
		
		System.out.println(meal);
	}

}

class Meal{
	String salad, dessert, drink,mainDish;
	
	public Meal(BuildMeal buildMeal) {
		super();
		this.salad = buildMeal.salad;
		this.dessert = buildMeal.dessert;
		this.drink = buildMeal.drink;
		this.mainDish = buildMeal.mainDish;
	}
	
	
	@Override
	public String toString() {
		return "Meal [salad=" + salad + ", dessert=" + dessert + ", drink=" + drink + ", mainDish=" + mainDish + "]";
	}


	static class BuildMeal{
		String salad, dessert, drink,mainDish;
		public BuildMeal salad(String salad) {
			this.salad = salad;
			return this;
		}
		public BuildMeal dessert(String dessert) {
			this.dessert = dessert;
			return this;
		}
		public BuildMeal drink(String drink) {
			this.drink = drink;
			return this;
		}
		public BuildMeal mainDish(String mainDish) {
			this.mainDish = mainDish;
			return this;
		}
		
		public Meal build() {
			return new Meal(this);
		}
	}
	
	
	
}