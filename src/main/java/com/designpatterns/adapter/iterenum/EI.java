package com.designpatterns.adapter.iterenum;

import java.util.*;

public class EI {
	public static void main (String args[]) {
		Vector<String> v = new Vector<String>(Arrays.asList("nitin"," kumar ","gipps"));
		Enumeration<String> enumeration = v.elements();
		while (enumeration.hasMoreElements()) {
			System.out.print(" "+enumeration.nextElement());
		}
		System.out.println();
		Iterator<String> iterator = v.iterator();
		while (iterator.hasNext()) {
			System.out.print("  "+iterator.next());
		}
	}
}
