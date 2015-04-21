package com.imarkofu.designpatterns.n;

/**
 * 模版方法模式
 * 		一个抽象类中，有一个祝方法，在定义1...n个方法，可以是抽象的，也可以是实际的方法，定义一个类，继承该抽象类，
 * 		重写抽象方法，通过调用抽象类，实现对子类的调用。
 * 		就是在AbstractCalculator类中定义一个祝方法calculate，calculate()调用split()等，
 * 		Plus和Minus分别集成AbstractCalculator类，通过对AbstractCalculator的调用实现对子类的调用，
 * 
 * @author Administrator
 *
 */
public class TemplateMethodPatterns {

	public static void main(String[] args) {
		String exp = "2+8";
		AbstractCalculator calculator = new Plus();
		System.out.println(calculator.calculator(exp, "\\+"));
	}
}
abstract class AbstractCalculator {
	public final int calculator(String exp, String opt) {
		int[] intArr = split(exp, opt);
		return calculator(intArr[0], intArr[1]);
	}
	abstract int calculator(int num1, int num2);
	public int[] split(String exp, String opt) {
		String[] arr = exp.split(opt);
		int[] intArr = new int[2];
		intArr[0] = Integer.parseInt(arr[0]);
		intArr[1] = Integer.parseInt(arr[1]);
		return intArr;
	}
}
class Plus extends AbstractCalculator {
	@Override
	public int calculator(int num1, int num2) {
		return num1+num2;
	}
}