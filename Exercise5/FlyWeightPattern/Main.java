package FlyWeightPattern;
import java.util.Random;


//Structural design pattern

//Used to optimize the ram usage coz the objects share some immutable state
//The shared data is extracted out and saved as another object ...so this can be used again by many objects without having to create them again and again for each and every single object
public class Main {

	private static String[] ingredients = { "onion", "garlic", "tomato" };

	public static void main(String[] args) {

			Cook cook1 = CookFactory.getCook("Vegcook");
			cook1.ingredients("onion");
			cook1.job();
			
			System.out.println();
			
			Cook cook2 = CookFactory.getCook("Vegcook");
			cook2.ingredients("garlic");
			cook2.job();

	}

	static String getRandomIngredients() {
		Random randomObject = new Random();
		int randomInt = randomObject.nextInt(ingredients.length);
		return ingredients[randomInt];
	}


}
