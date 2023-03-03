package Patterns;

import java.util.Scanner;

//Open for extension and closed for modification
//There might be a lot of of color paints..So when we want to add a new color to this code, and if we use if-else method,we have to change the main code.But instead of that if we remove if-else and introduce them as classes separately, whenever we want a new color we can just add that new class and we don't have to change the main code at all
//So we can actually change the code or behaviour of an algorithm at runtime and it will still work
public class StrategyPattern {
	public static void main(String[] args) {

		
		GoodPaintBrush gbrush=new GoodPaintBrush();

		Scanner s = new Scanner(System.in);
		String c = s.nextLine();
		c = "Patterns." + c;
		try {
			gbrush.paint=(Paint) Class.forName(c).newInstance();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		gbrush.doPaint();
	}
}

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