package com.java.reflectionexample;

import java.lang.reflect.Method;

public class ReflectionSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrivateMember privateMember = new PrivateMember("Private Member Sample");
		
		Method[] method = privateMember.getClass().getDeclaredMethods();
		for(Method methods : method){
			System.out.println(methods.getName());
		}

	}

}
