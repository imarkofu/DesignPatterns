package com.imarkofu.designpatterns.c;

/**
 * 单例模式
 * 		它是一种比较常用的设计模式，他能保证在一个JVM当中，该对象只有一个实例对象存在
 * 		
 * 优点：
 * 		1、某些类创建比较繁琐，对于一些大型的对象，这是一笔很大的系统开销
 * 		2、省去了new操作符，降低了系统内存的使用频率，减轻GC压力
 * 		3、有些类，如交易所的核心交易引擎，控制着交易流程，如果该类可以创建多个，系统就完全乱了（好比一个军队出现了多个司令员同时指挥一样）
 * 
 * 总结：
 *	1、单例模式理解起来简单，但是具体实现起来还是有一定的难度。
 *	2、synchronized关键字锁定的是对象，在用的时候，一定要在恰当的地方使用（注意需要使用锁的对象和过程，可能有的时候并不是整个对象及整个过程都需要锁）。
 *	
 *	突然想到另一个问题，就是采用类的静态方法，实现单例模式的效果，也是可行的，此处二者有什么不同？
 *	首先，静态类不能实现接口。（从类的角度说是可以的，但是那样就破坏了静态了。因为接口中不允许有static修饰的方法，所以即使实现了也是非静态的）
 *	其次，单例可以被延迟初始化，静态类一般在第一次加载时初始化。之所以延迟加载，是因为有些类比较庞大，所以延迟加载有助于提升性能。
 *	再次，单例类可以被集成，他的方法可以被覆盖。但是静态类内部方法都是static，无法被覆写。
 *	最后一点，单例类比较灵活，毕竟从实现上只是一个普通的Java类，只要满足单例的基本需求，你可以在里面随心所欲的实现一些其他功能，但是静态类不行。
 *	从上面这些概括中，基本可以看出二者的区别，但是，从另一方面讲，我们上面最后实现的那个单例模式，内部就是用一个静态类来实现的，所以，二者有很大的关联，
 *	只是我们考虑问题的层面不同罢了。两种思想的结合，才能造就出完美的解决方案，就像HashMap采用数组+链表来实现一样，其实生活中很多事情都是这样，
 *	但用不同的方法来处理问题，总是有有点也有缺点，最完美的方法是，结合各个方法的有点，才能最好的解决问题！
 *	
 * @author Administrator
 *
 */
public class SingletonPatterns {

}

class Singleton {
	private static Singleton instance = null;
	/**
	 * 私有化构造方法，防止被实例化
	 */
	private Singleton() { }
	
	/**
	 * 静态工程方法，创建实例
	 * 仔细想会发现，它毫无线程安全可言
	 * 第一时间想到方法上加synchronized关键字如后面
	 * @return
	 */
//	public static Singleton getInstance() {
//		if (instance == null) 
//			instance = new Singleton();
//		return instance;
//	}
	/**
	 * 这样每次调用该方法时都会对该方法进行加锁，这样相当的影响性能，理论上我们只需要在对象创建时加锁
	 * 这样有了后面的方法
	 * @return
	 */
//	public static synchronized Singleton getInstance() {
//		if (instance == null) 
//			instance = new Singleton();
//		return instance;
//	}
	
	/**
	 * 感觉似乎解决了我们遇到的问题，synchronized关键字加在了内部，只有在instance为null时，才会加锁，性能得到了提升
	 * 但是这种情况还是可能会有问题的
	 * 在Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();语句是分两步执行的。
	 * 但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton示例分配空间，然后直接赋值给instance成员，
	 * 然后再去初始化这个Singleton实例，这样就有可能出错了
	 * 示例：
	 * 	有A、B两个线程同时进入第一个if判断
	 * 	A首先进入synchronized块，由于instance为null,所以它执行instance = new Singleton();
	 * 	由于JVM内部的优化机制，JVM先画出了一些分配给Singleton示例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个示例），然后A离开了synchronized块。
	 * 	B进入synchronized块，由于instance此时不是null,因此它马上离开了synchronized块并将接口返回给调用该方法的程序。
	 * 	此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。
	 * 	所以程序还是有可能发生错误的，其实程序的运行过程是比较复杂的，从这一点我们可以看出，尤其是在写多线程环境下的程序，就更有难度和挑战性了
	 * 	因此我们对程序有了后面的优化
	 * @return
	 */
//	public static Singleton getInstance() {
//		if (instance == null) {
//			synchronized (instance) {
//				if (instance == null) {
//					instance = new Singleton();
//				}
//			}
//		}
//		return instance;
//	}
	/**
	 * 单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
	 * 这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕
	 * 这样我们就不用担心上面的问题。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能的问题。
	 * 这样我们暂时总结一个完美的单例模式就是这样的了
	 * 
	 * @author Administrator
	 *
	 */
	private static class SingletonFactory {
		private static Singleton instance = new Singleton();
	}
	public static Singleton getInstance() {
		return SingletonFactory.instance;
	}
	
	/*
	 * 其实说它完美，也不一定，如果在构造函数中抛出异常，实例将永远得不到创建，也会出错。
	 * 所以说，十分完美的东西是没有的，我们只能根据实际情况，选择最适合自己应用场景的实现方法。也有人这样实现：
	 * 因为我们只需要在创建类的时候进行同步，所以只要将创建和getInstance()分开，单独为创建加synchronized关键字，也是可以的：
	 * 考虑性能的话，整个程序只需创建一次实例，所以性能也不会有什么影响
	 * 代码就不写了
	 */
	
	/**
	 * 如果该对象被用于序列化，可以保证对象在序列化前后保持一致
	 * @return
	 */
	public Object readResolve() {
		return instance;
	}
}