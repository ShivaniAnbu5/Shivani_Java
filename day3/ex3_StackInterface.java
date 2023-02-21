package exercises;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ex3_StackInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1.Fixed stack");
		System.out.println("2.Dynamic Stack");
		System.out.println("Enter your option:");
		int option = scan.nextInt();
		
		if(option==1) {
			
			System.out.println("Enter the size of the fixed stack: ");
			int size = scan.nextInt();
			int arr[] = new int[size];
			FixedStack s = new FixedStack(arr, size);
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
		
			else if(option==2) {
				
				LinkedList<Integer> dynamicStack = new LinkedList<Integer>();
				DynamicStack s = new DynamicStack(dynamicStack);
				while(true) {
					System.out.println("1.Push values into dynamic stack");
					System.out.println("2.Pop values from dynamic stack");
					System.out.println("3.Display dynamic stack");
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
						s.displayStack();
						break;
					case 4:
						System.exit(1);
						break;
					}
				}
				

			}
		
	
	}

}

interface Stack{
	void push(int val);
	void pop();
}

class FixedStack implements Stack{
	
	int arr[];
	int size,top=-1;
	

	public FixedStack(int[] arr, int size) {
		this.arr = arr;
		this.size = size;
	}

	@Override
	public void push(int val) {
		if(!isFull()) {
			arr[++top] = val;
			System.out.println("Pushed value");
		}
		else System.out.println("Stack full");
		
	}

	@Override
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

class DynamicStack implements Stack{
	
	LinkedList<Integer> list = new LinkedList<>();
	int listSize=0;
	
	public DynamicStack(LinkedList<Integer> list) {
		this.list = list;
	}
	
	@Override
	public void push(int val) {
		// TODO Auto-generated method stub
		list.add(val);
		listSize++;
		System.out.println("Pushed value");
		
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		if(listSize!=0) {
		System.out.println("Popped element is "+list.remove(listSize-1));
		listSize--;
		}
		else System.out.println("Stack is empty!!!");
		
	}

	public void displayStack() {
		// TODO Auto-generated method stub
		System.out.println(list);
		
	}

	
}