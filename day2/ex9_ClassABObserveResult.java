package exercises;

public class ex9_ClassABObserveResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		classB b = new classB();
		b.accessPubMember();
		b.accessProMember();
		b.accessPvtMember();
	}

}

class classA{
	public int pubInt=5;
	private int pvtInt=6;
	protected int proInt=7;
	
	public void printPubInt() {
		System.out.println(pubInt);
	}
	
	protected void printProInt() {
		System.out.println(proInt);
		}
	
	private void printPvtInt() {
		System.out.println(pvtInt);
	}
}

class classB extends classA{
	void accessPvtMember() {
		//Private members can't be accessible.So it will throw an error
		printPvtInt();
	}
	void accessPubMember() {
		printPubInt();
	}
	void accessProMember() {
		printProInt();
	}
	
}