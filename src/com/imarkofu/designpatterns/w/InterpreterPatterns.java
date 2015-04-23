package com.imarkofu.designpatterns.w;

/**
 * 解释器模式
 * @author Administrator
 *
 */
public class InterpreterPatterns {
	public static void main(String[] args) {
		int result = new Minus().interpret(
				(new Context(new Plus().interpret(new Context(9, 2)), 8))); 
		System.out.println(result);
	}
}
interface Expression {
	public int interpret(Context context);
}
class Minus implements Expression {
	@Override
	public int interpret(Context context) {
		return context.getNum1() - context.getNum2();
	}
}
class Plus implements Expression {
	@Override
	public int interpret(Context context) {
		return context.getNum1() + context.getNum2();
	}
}
class Context {
	private int num1;
	private int num2;
	public Context(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
}