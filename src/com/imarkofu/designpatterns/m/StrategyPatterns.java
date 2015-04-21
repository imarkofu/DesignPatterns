package com.imarkofu.designpatterns.m;

/**
 * 策略模式
 * 		策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户。
 * 		需要设计一个接口，为一系列实现类提供统一的方法，多个实现类实现该接口，设计一个抽象类（可有可无，属于辅助类），提供辅助函数
 * 
 * 总结
 * 		策略模式的决定权在用户，系统本身提供不同算法的实现，新增或者删除算法，对各种算法做封装。
 * 		因此，策略模式多用在算法决策系统中，外部用户只需要决定用哪个算法即可。
 * 
 * @author Administrator
 *
 */
public class StrategyPatterns {

	public static void main(String[] args) {
		String exp = "2+8";
		ICalculator cal = new Plus();
		System.out.println(cal.calculator(exp));
	}
}
/**
 * 一个统一接口
 * @author Administrator
 *
 */
interface ICalculator {
	public int calculator(String exp);
}
/**
 * 一个辅助类
 * @author Administrator
 *
 */
abstract class AbstractCalculator {
	public int[] split(String exp, String opt) {
		String[] arr = exp.split(opt);
		int[] intArr = new int[2];
		intArr[0] = Integer.parseInt(arr[0]);
		intArr[1] = Integer.parseInt(arr[1]);
		return intArr;
	}
}
/**
 * 三个实现类
 * @author Administrator
 *
 */
class Plus extends AbstractCalculator implements ICalculator {
	@Override
	public int calculator(String exp) {
		int[] arrInt = split(exp, "\\+");
		return arrInt[0]+arrInt[1];
	}
}
class Minus extends AbstractCalculator implements ICalculator {
	@Override
	public int calculator(String exp) {
		int[] arrInt = split(exp, "-");
		return arrInt[0] - arrInt[1];
	}
}
class Multiply extends AbstractCalculator implements ICalculator {
	@Override
	public int calculator(String exp) {
		int[] arrInt = split(exp, "\\*");
		return arrInt[0]*arrInt[1];
	}
}