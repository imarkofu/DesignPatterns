package com.imarkofu.designpatterns.p;

/**
 * 迭代子模式
 * 		迭代器模式就是顺序访问聚集中的对象，一般来说，集合中非常常见，如果对集合类比较熟悉的话，理解本模式会十分轻松。
 * 		这句话包含两层意思：一是需要遍历的对象，即聚集对象，二十迭代器对象，用于对聚集对象进行遍历访问。
 * 
 * 思路
 * 		MyCollection中定义了集合的一些操作，MyIterator中定义了一系列迭代操作，且持有Collection实例
 * 	
 * 总结
 * 		此处我们模拟了一个集合类的过程，其实JDK中的各个类也都是这些基本的东西，加一些设计模式，在加一些优化放到一起，只要我们把这些东西学会了，掌握好了，我们也可以写出自己的集合类，甚至框架！
 * 
 * @author Administrator
 *
 */
public class IteratorPatterns {

	public static void main(String[] args) {
		Collection collection = new MyCollection();
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
		}
	}
}
interface Collection {
	public Iterator iterator();
	/*获取集合元素*/
	public Object get(int i);
	/*取得集合大小*/
	public int size();
}
interface Iterator {
	/*前移*/
	public Object previous();
	/*后移*/
	public Object next();
	public boolean hasNext();
	public Object first();
}
class MyCollection implements Collection {
	public String[] arr = {"A", "B", "C", "D", "E"};
	@Override
	public Iterator iterator() {
		return new MyIterator(this);
	}
	@Override
	public Object get(int i) {
		return arr[i];
	}
	@Override
	public int size() {
		return arr.length;
	}
}
class MyIterator implements Iterator {
	private Collection collection;
	private int pos = -1;
	public MyIterator(Collection collection) {
		this.collection = collection;
	}
	@Override
	public Object previous() {
		if (pos > 0) {
			pos --;
		}
		return collection.get(pos);
	}
	@Override
	public Object next() {
		if (pos < collection.size()-1) {
			pos ++;
		}
		return collection.get(pos);
	}
	@Override
	public boolean hasNext() {
		if (pos < collection.size()-1) {
			return true;
		} else {
			return false;
		}
	}
	public Object first() {
		pos = 0;
		return collection.get(pos);
	}
}
