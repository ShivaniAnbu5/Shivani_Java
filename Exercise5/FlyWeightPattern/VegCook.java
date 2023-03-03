package FlyWeightPattern;


public class VegCook implements Cook {

	
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
	public void ingredients(String ingredient) {
		// TODO Auto-generated method stub
		this.ingredients = ingredient;
	}
	
	public String getIngredient() {
		return ingredients;
	}

	@Override
	public void job() {
		// TODO Auto-generated method stub
		System.out.println("VegCook cooked it with ingredient " + ingredients);
	}

	

}