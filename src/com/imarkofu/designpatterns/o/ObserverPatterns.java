package com.imarkofu.designpatterns.o;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 观察者模式
 * 		观察者模式很好理解，类似于邮件订阅和RSS订阅，当我们浏览一些博客或wiki时，经常会看到RSS图表，这个的意思是，
 * 		当你订阅了该文章，如果后续有更新，会及时通知你，其实，简单来讲就一句话：当一份对象变化时，其他依赖该对象的对象都会收到通知，
 * 		并且随着变化！对象之间是一种一对多的关系。
 * 
 * 解释
 * 		MySubject类就是我们的主对象，Observer1和Observer2是依赖于MySubject的对象，当MySubject变化时，
 * 		Observer1和Observer2必然变化。AbstractSubject类中定义着需要监控的对象列表，可以对其进行修改：
 * 		增加或删除被监控对象，且当MySubject变化时，负责通知在列表内存在的对象。
 * 
 * 
 * @author Administrator
 *
 */
public class ObserverPatterns {

	public static void main(String[] args) {
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());
		
		sub.operation();
	}
}
interface Observer {
	public void update();
}
class Observer1 implements Observer {
	@Override
	public void update() {
		System.out.println("observer1 has received!");
	}
}
class Observer2 implements Observer {
	@Override
	public void update() {
		System.out.println("observer2 has received!");
	}
}
interface Subject {
	/*增加观察者*/
	public void add(Observer observer);
	/*删除观察者*/
	public void del(Observer observer);
	/*通知所有观察者*/
	public void notifyObservers();
	/*自身的操作*/
	public void operation();
}
abstract class AbstractSubject implements Subject {
	private Vector<Observer> vector = new Vector<Observer>();
	@Override
	public void add(Observer observer) {
		vector.add(observer);
	}
	@Override
	public void del(Observer observer) {
		vector.remove(observer);
	}
	@Override
	public void notifyObservers() {
		Enumeration<Observer> emnmo =  vector.elements();
		while (emnmo.hasMoreElements()) {
			emnmo.nextElement().update();
		}
	}
}
class MySubject extends AbstractSubject {
	@Override
	public void operation() {
		System.out.println("update self!");
		notifyObservers();
	}
}