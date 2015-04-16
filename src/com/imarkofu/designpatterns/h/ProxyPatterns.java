package com.imarkofu.designpatterns.h;

/**
 * 代理模式
 * 		代理模式就是多一个代理类出来，替原对象进行一些操作，比如我们在租房子的时候会去找中介，为什么呢？
 * 		因为你对该地区房屋的信息掌握得不够全面，希望找一个更熟悉的人去帮你做，此处的代理就是这个意思。
 * 		再如我们有的时候打官司，我们需要请律师，因为律师在法律方面有专长，可以替我们进行操作，表达我们的想法。
 * 
 * 总结
 * 		应用场景：
 * 			1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。
 * 			2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制，这种方法就是代理模式。
 * 		使用代理模式，可以将功能划分得更加清晰，有助于后期维护！
 * 
 * @author Administrator
 *
 */
public class ProxyPatterns {

	public static void main(String[] args) {
		Sourceable source = new Proxy();
		source.method();
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
class Proxy implements Sourceable {
	private Sourceable source;
	public Proxy() {
		super();
		this.source = new Source();
	}
	@Override
	public void method() {
		before();
		this.source.method();
		after();
	}
	private void before() {
		System.out.println("before proxy");
	}
	private void after() {
		System.out.println("after proxy");
	}
}