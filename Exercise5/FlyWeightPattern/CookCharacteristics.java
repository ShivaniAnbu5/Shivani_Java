package FlyWeightPattern;

public class CookCharacteristics {
	private String task,kitchen,tools;
	
	public CookCharacteristics() {
		task = "cooked a dish";
		kitchen = "who has a kitchen";
		tools = "using a knife,etcc";
	}
	
	@Override
	public String toString() {
		return "A cook " +kitchen + ", " + task + " "+tools;
	}
}
