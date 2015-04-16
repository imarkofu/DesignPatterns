package com.imarkofu.designpatterns.g;

/**
 * 装饰模式
 * 		顾名思义，它是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 * 
 * 总结
 * 		应用场景：
 * 			1、需要扩展一个类的功能
 * 			2、动态的为一个对象增加功能，而且还能动态撤销（继承不能做到这一点，继承的功能是静态的，不能动态增删）
 * 		缺点：
 * 			产生过多相似的对象，不易排错！
 * @author Administrator
 *
 */
public class DecoratorPatterns {

	public static void main(String[] args) {
		Sourceable source = new Source();
		Sourceable decorator = new Decorator(source);
		decorator.method();
	}
}
interface Sourceable {
	public void method();
}
class Source implements Sourceable {
	@Override
	public void method() {
		System.out.println("this is a original method!");
	}
}
class Decorator implements Sourceable {
	private Sourceable source;
	public Decorator(Sourceable source) {
		this.source = source;
	}
	@Override
	public void method() {
		System.out.println("before decorator!");
		this.source.method();
		System.out.println("after decorator!");
	}
}