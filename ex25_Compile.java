package exercises;

public class ex25_Compile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex25_Compile.derived obj = new ex25_Compile().new derived();
		obj.useD();
		 
	}

	//Will return an error since class cannot be protected
	//As there's no use then, since it cannot be accessed
	protected class base{
		String Method() {
			return "Wow";
		}
	}

	class derived{
		public void useD() {
			base z = new base();
			System.out.println("base says, "+z.Method());
		}
	}
}

