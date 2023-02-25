package exercises;

public class ex27_investment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double investment = 14000;
		
		double increasedValue = investment * (0.4);
		investment += increasedValue;
		System.out.println("After one year it will be "+investment);

		investment -= 1500;
		System.out.println("After two years it will be "+investment);
		
		
		increasedValue = investment * (12/100d);
		investment += increasedValue;
		System.out.println("After three years it will be "+investment);
	}

}
