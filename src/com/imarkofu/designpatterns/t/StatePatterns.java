package com.imarkofu.designpatterns.t;

/**
 * 状态模式
 * 		当对象的状态改变时，同时改变其行为，很好理解！就拿QQ来说，有几种状态，在线、隐身、忙碌等，没个状态对应不同的操作，
 * 		而且你的好友也能看到你的状态，所以，状态模式就两点：1、可以通过改变状态来获得不同的行为。2、你的好友能同时看到你的变化。
 * 
 * 说明
 * 		State类是个状态类，Context类可以实现切换
 * 
 * @author Administrator
 *
 */
public class StatePatterns {
	public static void main(String[] args) {
		State state = new State();
		Context context = new Context(state);
		state.setValue("state1");
		context.method();
		state.setValue("state2");
		context.method();
	}
}
class State {
	private String value;
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void method1() {
		System.out.println("execute the first opt!");
	}
	public void method2() {
		System.out.println("execute the second opt!");
	}
}
class Context {
	private State state;
	public Context(State state) {
		this.state = state;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public void method() {
		if (state.getValue().equals("state1")) {
			state.method1();
		} else if (state.getValue().equals("state2")) {
			state.method2();
		}
	}
	
}