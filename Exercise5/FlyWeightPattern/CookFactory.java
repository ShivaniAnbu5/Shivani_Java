package FlyWeightPattern;

import java.util.HashMap;

public class CookFactory {
	private static HashMap<String, Cook> hashMap = new HashMap<>();

	public static Cook getCook(String type) {
		Cook cook;
		if (hashMap.containsKey(type)) {
			cook = hashMap.get(type);
		} else {
				cook = new VegCook();
				System.out.println("Veg cook created");
		
			}
		hashMap.put(type, cook);

		return cook;
	}
}
