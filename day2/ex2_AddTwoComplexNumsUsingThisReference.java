package exercises;

public class ex2_AddTwoComplexNumsUsingThisReference {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexNum cn1 = new ComplexNum(4,5);
		ComplexNum cn2 = new ComplexNum(7,89);
		
		
		
		AddComplexNumbers addComplexNumbers = new AddComplexNumbers();
		addComplexNumbers.add(cn1,cn2);
	}

}

class ComplexNum{
	int realNum,imaginaryNum;

	public ComplexNum(int realNum, int imaginaryNum) {
		super();
		this.realNum = realNum;
		this.imaginaryNum = imaginaryNum;
	}
	

}

abstract class Addition{
	abstract void add(ComplexNum addObj1,ComplexNum addObj2);
}

class AddComplexNumbers extends Addition{

	@Override
	void add(ComplexNum addObj1,ComplexNum addObj2) {
		// TODO Auto-generated method stub
		int realResult= addObj1.realNum + addObj2.realNum;
		int imgResult = addObj1.imaginaryNum + addObj2.imaginaryNum;
		System.out.println(realResult+" +i"+imgResult);
		
		
	}
}

