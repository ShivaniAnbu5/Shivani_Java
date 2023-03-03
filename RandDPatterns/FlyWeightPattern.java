package RandDPatterns;

import java.util.HashMap;
import java.util.Random;

//Structural design pattern

//Used to optimize the ram usage coz the objects share some immutable state
//The shared data is extracted out and saved as another object ...so this can be used again by many objects without having to create them again and again for each and every single object
public class FlyWeightPattern {

	private static String[] ingredients = { "onion", "garlic", "tomato" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Cook c = CookFactory.getCook("Vegcook");
			c.Ingredients("onion");
			c.mission();
			
			System.out.println();
			
			Cook c1 = CookFactory.getCook("Vegcook");
			c1.Ingredients("garlic");
			c1.mission();

	}

	static String getRandomIngredients() {
		Random r = new Random();
		int randInt = r.nextInt(ingredients.length);
		return ingredients[randInt];
	}


}

class CookFactory {

	private static HashMap<String, Cook> hm = new HashMap<>();

	public static Cook getCook(String type) {
		Cook cook = null;
		if (hm.containsKey(type)) {
			cook = hm.get(type);
		} else {
				cook = new VegCook();
				System.out.println("Veg cook created");
		
			}
			hm.put(type, cook);

		return cook;
	}

}

interface Cook {
	void Ingredients(String weapon);

	void mission();

	String getIngredient();
}

class CookCharacteristics{
		private String task,kitchen,tools;
		
		public CookCharacteristics(){
			task = "cooked a dish";
			kitchen = "who has a kitchen";
			tools = "using a knife,etcc";
		}
		
		@Override
		public String toString() {
			return "CookCharacteristics [task=" + task + ", kitchen=" + kitchen + ", tools=" + tools + "]";
		}
		
      
	
}
class VegCook implements Cook {

	
	private CookCharacteristics cookCharacteristics;
	private String ingredients;
	 
	public VegCook() {
		// TODO Auto-generated constructor stub
		if(cookCharacteristics == null) {
			cookCharacteristics = new CookCharacteristics();
			System.out.println(cookCharacteristics);
		}
		else 
		System.out.println(cookCharacteristics);
	}


	@Override
	public void Ingredients(String ingredient) {
		// TODO Auto-generated method stub
		this.ingredients = ingredient;
	}
	
	public String getIngredient() {
		return ingredients;
	}

	@Override
	public void mission() {
		// TODO Auto-generated method stub
		System.out.println("VegCook cooked it with ingredient " + ingredients);
	}

	

}

