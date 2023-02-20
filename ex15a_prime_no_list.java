package exercises;

public class ex15a_prime_no_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=100;i++) {
			int divi=0;
			for(int j=1;j<=i/2;j++) {
				if(i%j==0) divi++; 
//				System.out.println("divi is "+divi);
				if(divi>1) break;
				
			}
			if(divi == 1) System.out.print(i+" ");
		}
	}

}
