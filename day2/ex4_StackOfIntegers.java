package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ex4_StackOfIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the size of the stack: ");
		int size = scan.nextInt();
		int arr[] = new int[size];
		Stack s = new Stack(arr, size);
		while(true) {
			System.out.println("1.Push values into fixed stack");
			System.out.println("2.Pop values from fixed stack");
			System.out.println("3.Display fixed stack");
			System.out.println("4.Exit");
			System.out.println("Enter your option:");
			int op1=scan.nextInt();
			switch(op1) {
				case 1:
					System.out.println("Enter a value to insert: ");
					s.push(scan.nextInt());
					break;
				case 2:
					s.pop();
					break;
				case 3:
					System.out.println(Arrays.toString(arr));
					break;
				case 4:
					System.exit(1);
					break;
				}
			}
	}

}

class Stack{
	
	int arr[];
	int size,top=-1;
	

	public Stack(int[] arr, int size) {
		this.arr = arr;
		this.size = size;
	}

	public void push(int val) {
		if(!isFull()) {
			arr[++top] = val;
			System.out.println("Pushed value");
		}
		else System.out.println("Stack full");
		
	}
	
	public void pop() {
		int poppedElt=0;
		if(top!=-1) {
			poppedElt= arr[top];
			arr[top--] = 0;
			System.out.println("Popped element is "+poppedElt);
		}
		else System.out.println("Stack is empty!!!");
		
		
	}

	public boolean isFull() {
		if(top == size-1)
			return true;
		return false;
	}
	
}