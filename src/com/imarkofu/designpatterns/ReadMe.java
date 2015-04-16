package com.imarkofu.designpatterns;

/**
 * 设计模式
 * 一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结；
 * 设计模式总共可以分为三大类
 * 		创建型模式：工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式
 * 		结构型模式：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式
 * 		行为型模式：策略模式、模版方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式
 * 其实还有两类：并发模式和线程池模式
 * http://dl2.iteye.com/upload/attachment/0083/1179/57a92d42-4d84-3aa9-a8b9-63a0b02c2c36.jpg
 * 
 * 
 * 设计模式的六大原则
 * 		1、开闭原则
 * 			对扩展开放，对修改关闭：对程序就行扩展时，不能修改原始代码，实现一个热拔插的效果
 * 			为了使程序的扩展性好，易于维护和升级
 * 			想要达到这样的效果，我们需要使用接口和抽象类
 * 		2、里氏代理原则
 * 			它是面向对象的基本原则之一
 * 			任何基类可以出现的地方，子类一定可以出现
 * 				它是继承复用的基石，只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，
 * 				而衍生类也能够在基类的基础上增加新的行为。里氏代换原则是对“开-闭”原则的补充。
 * 				实现“开-闭”原则的关键步骤就是抽象化。而基类与子类的继承关系就是抽象化的具体实现，
 * 				所以里氏代换原则是对实现抽象化的具体步骤的规范。—— From Baidu 百科
 * 		3、依赖倒转原则
 * 			它是开闭原则的基础，具体内容：真对接口编程，依赖于抽象而不依赖于具体
 * 		4、接口隔离原则
 * 			使用多个隔离的接口，比使用单个接口要好。还是一个降低类之间的耦合度的意思，
 * 			从这儿我们看出，其实设计模式就是一个软件的设计思想，从大型软件架构出发，为了升级和维护方便。
 * 			降低依赖，降低耦合。
 * 		5、迪米特法则（最少知道原则）
 * 			一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。
 * 		6、合成复用原则
 * 			尽量使用合成/聚合的方式，而不是使用继承。
 * 
 * 1、工厂方法模式（Factory Method）
 * 		详见FactoryMethodPatterns.java
 * 2、抽象工厂模式（AbstractFactory）
 * 		详见AbstractFactoryPatterns.java
 * 3、单例模式（Singleton）
 * 		详见SingletonPatterns.java
 * 4、建造者模式（Builder）
 * 		详见BuilderPatterns.java
 * 5、原型模式（Prototype）
 * 		详见PrototypePatterns.java
 * 
 * 至此五种创建型模式就告一段落了，下面接着是七种结构型模式
 * 6、适配器模式（Adapter）
 * 		详见AdapterPatterns.java
 * 
 * @author Administrator
 *
 */
public class ReadMe {

}
