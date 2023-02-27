package exercises;

public class ex6_ProveOrderOfInitializationForStaticBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleClass sampleClass = new SampleClass();
	}

}

class SampleClass{
	static int a=5;
	static {
		a=100;
		System.out.println("This is the static block "+ a);
	}
	public SampleClass(){
		a = 1098;
		System.out.println("This is the default constructor of Sample class "+a);
	}
}