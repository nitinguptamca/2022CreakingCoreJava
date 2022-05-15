package com.designpatterns.adapter.ducks;

public class MallardDuck implements Duck {
	public void quack() {
		System.out.println("MallardDuck Quack");
	}
 
	public void fly() {
		System.out.println("MallardDuck I'm flying");
	}
}
