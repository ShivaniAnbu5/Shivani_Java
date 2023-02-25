package exercises;

public class ex15a_prime_no_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag=false;
		for(int i=2;i<=100;i++) {
			flag=false;
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) 
					{flag=true; 
//				System.out.println("divi is "+divi);
				 break;
					}
				
			}
			if(flag == false) System.out.print(i+" ");
		}
	}

}
