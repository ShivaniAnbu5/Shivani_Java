package Patterns;

import java.util.Scanner;

public class StrategyPattern {
	public static void main(String[] args) {
//		BadPaintBrush bbrush=new BadPaintBrush();
//		bbrush.doPaint(1);
		
		GoodPaintBrush gbrush=new GoodPaintBrush();
//		gbrush.paint=new RedPaint();
		Scanner s = new Scanner(System.in);
		String c = s.nextLine();
		c = "Patterns." + c;
		try {
			gbrush.paint=(Paint) Class.forName(c).getConstructor().newInstance();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		gbrush.doPaint();
	}
}


//class BadPaintBrush{
//	public void doPaint(int i) {
//		if(i==1){
//			System.out.println("red colour...");
//		}
//		else if(i==2){
//			System.out.println("blue colour...");
//		}
//		else if(i==3) {
//			System.out.println("green colour...");
//		}
//	}
//}
/*
	steps to remove if-else-if
	1. delete the if-else-if ladder
	2. convert the condition to classes
	3. Group them under a hierarchy
	4. Create a association between the hierarchial class and the using class
*/
class GoodPaintBrush{
	Paint paint;
	public void doPaint() {
		paint.colour();
	}
}
abstract class Paint{
	public abstract void colour();
}
class RedPaint extends Paint{
	public RedPaint() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void colour() {
		System.out.println("red colour...");
	}
}
class BluePaint extends Paint{
	public BluePaint() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void colour() {
		System.out.println("blue colour...");
	}
}
class GreenPaint extends Paint{
	public GreenPaint() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void colour() {
		System.out.println("green colour..");
	}
}