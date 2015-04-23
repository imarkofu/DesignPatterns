package com.imarkofu.designpatterns.u;

/**
 * 访问者模式
 * 		访问者模式把数据结构和作用与结构上的操作解耦合，是的操作集合可相对自由的眼花。访问这模式适用于数据结构相对稳定算法又易变化的系统。
 * 		因为访问者模式使得算法操作增加变得容易。若系统数据结构对象易于变化，经常有新的数据对象增加进行，则不适合使用访问者模式。
 * 		访问者模式的有点是增加操作很容易，因为增加操作意味着增加新的访问者。访问者模式将有关行为集中到一个访问者对象中，
 * 		其改变不影响系统数据结构。其缺点就是增加新的数据结构很困难。—— From 百科
 * 		
 * 		简单来说，访问者模式就是一种分离对象数据结构与行为的方法，通过这种分离，可达到为一个被访问者动态添加新的操作而无需做其他的修改的效果。
 * 
 * 说明
 * 		Visitor类，存放要访问的数据
 * 		Subject类，accpet方法，接受将要访问他的对象，getSubject获取将要被访问的属性
 * 
 * 使用场景
 * 		如果我们想为一个先有的类增加新功能，不得不考虑几个事情：
 * 			1、新功能会不会与先有功能出现兼容性问题？
 * 			2、以后会不会在需要添加？
 * 			3、如果类不允许修改代码怎么办？
 * 		面对这些问题，最好的解决办法就是使用访问者模式，访问者模式适用于数据结构相对稳定的系统，把数据结构和算法结构，
 * @author Administrator
 *
 */
public class VisitorPatterns {
	public static void main(String[] args) {
		Visitor visitor = new MyVisitor();
		Subject subject = new MySubject();
		subject.accept(visitor);
	}
}
interface Visitor {
	public void visit(Subject subject);
}
class MyVisitor implements Visitor {
	@Override
	public void visit(Subject subject) {
		System.out.println("visit the subject:" + subject.getSubject());
	}
}
interface Subject {
	public void accept(Visitor visitor);
	public String getSubject();
}
class MySubject implements Subject {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	public String getSubject() {
		return "clovec";
	}
}