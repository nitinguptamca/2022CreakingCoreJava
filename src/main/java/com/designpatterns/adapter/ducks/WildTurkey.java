package com.designpatterns.adapter.ducks;

public class WildTurkey implements Turkey {
	public void gobble() {
		System.out.println(" WildTurkey Gobble gobble");
	}
 
	public void fly() {
		System.out.println("WildTurkey I'm flying a short distance");
	}
}
