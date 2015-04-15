package com.imarkofu.designpatterns.d;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 * 		工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品几种起来进行管理，用来创建符合对象，
 * 		所谓符合对象就是值某个类具有不同的属性，其实建造者模式就是前面抽象工厂模式和最后的Test结合起来得到的
 * 
 * 总结
 * 		建造者模式将很多功能集成到一个类里，这个类可以创建出比较负责的东西。所以与工厂模式的区别就是：
 * 		工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象，多个部分。因此，是选择工厂模式还是建造者模式，以实际情况而定。
 * 
 * @author Administrator
 *
 */
public class BuilderPatterns {

	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceSmsSender(10);
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
class Builder {
	List<Sender> senders = new ArrayList<Sender>();
	public void produceMailSender(int count) {
		for (int i = 0; i < count; i ++) {
			senders.add(new MailSender());
		}
	}
	public void produceSmsSender(int count) {
		for (int i = 0; i < count; i ++) {
			senders.add(new SmsSender());
		}
	}
}
