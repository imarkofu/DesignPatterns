package com.imarkofu.designpatterns.b;

/**
 * 抽象工厂模式
 * 		工厂方法模式有一个问题就是，类的创建依赖于工厂类，也就是说，如果要拓展程序，就必须对工厂类就行修改，
 * 		这违背了闭包原则，所以，从设计角度烤炉，它是有一定的问题的，如何来解决这个问题呢？
 * 		就要用到抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，而不需要修改之前的代码
 * 
 * 总结
 * 		这个模式的好处：如果你想增加一个功能发及时信息，则只需要做一个实现类，实现Sender接口，同时做一个工厂类，实现Provider接口，就Ok了
 * 		而无需去改动先有的代码，这样做拓展性较好
 * @author Administrator
 *
 */
public class AbstractFactoryPatterns {

	public static void main(String[] args) {
		Provider provider = new MailSenderFactory();
		Sender sender = provider.produce();
		sender.Send();
	}
}

interface Sender {
	void Send();
}
class MailSender implements Sender {
	@Override
	public void Send() {
		System.out.println("this is a mail sender");
	}
}
class SmsSender implements Sender {
	@Override
	public void Send() {
		System.out.println("this is a sms sender");
	}
}
interface Provider {
	Sender produce();
}
class MailSenderFactory implements Provider {
	@Override
	public Sender produce() {
		return new MailSender();
	}
}
class SmsSenderFactory implements Provider {
	@Override
	public Sender produce() {
		return new SmsSender();
	}
}