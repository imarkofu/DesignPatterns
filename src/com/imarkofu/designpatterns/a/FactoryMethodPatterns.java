package com.imarkofu.designpatterns.a;

/**
 * 工厂方法模式
 * 		普通工厂模式：就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * 		多工厂方法模式：是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
 * 		静态工厂方法模式：将多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 * 
 * 总结：
 * 		凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方式模式进行创建。
 * 		在以上的三种模式中，第一种如果传入的字符串有误，就不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，
 * 		所以，在大多数情况下，我们会选用第三种静态工厂方法模式
 * 
 * @author Administrator
 *
 */
public class FactoryMethodPatterns {

	public static void main(String[] args) {
		//测试
//		SendFactory sendFactory = new SendFactory();
//		Sender sender = sendFactory.produce("sms");
//		sender.Send();
		
//		SendFactory sendFactory = new SendFactory();
//		Sender sender = sendFactory.produceMail();
//		sender.Send();
		
		Sender sender = SendFactory.produceMail();
		sender.Send();
	}
}

interface Sender {  
    public void Send();  
}
class MailSender implements Sender {  
    @Override  
    public void Send() {  
        System.out.println("this is mailsender!");  
    }  
}
class SmsSender implements Sender {  
    @Override  
    public void Send() {  
        System.out.println("this is sms sender!");  
    }  
}
/**
 * 普通工厂模式
 */
//class SendFactory {
//    public Sender produce(String type) {  
//        if ("mail".equals(type)) {  
//            return new MailSender();  
//        } else if ("sms".equals(type)) {  
//            return new SmsSender();  
//        } else {  
//            System.out.println("请输入正确的类型!");  
//            return null;  
//        }  
//    }  
//}
/**
 * 多工厂方法模式
 * 是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象
 */
//class SendFactory {
//	public Sender produceMail(){  
//        return new MailSender();  
//    }
//    public Sender produceSms(){  
//        return new SmsSender();  
//    }
//}
/**
 * 静态工厂方法模式
 * 将多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 * @author Administrator
 *
 */
class SendFactory {
	public static Sender produceMail(){  
        return new MailSender();  
    }  
    public static Sender produceSms(){  
        return new SmsSender();  
    }
}