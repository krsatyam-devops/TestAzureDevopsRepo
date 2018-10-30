package com.java.reflectionexample;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMembers {

	public static void main(String[] args) {
		
		try {
		
			PrivateMember privateObject = new PrivateMember("Private Sample");
			
			//Access public members			
			Method publicSetTestStringMethod = privateObject.getClass()
					.getDeclaredMethod("setTestPublicString", String.class);
			
			publicSetTestStringMethod.invoke(privateObject, "Public Sample Test");
			
			Field publicTestStringField = PrivateMember.class.
		            getDeclaredField("testPublicString");
			
			System.out.println("testPublicString value = " + (String) publicTestStringField.get(privateObject));

			// Access private variables
			Field privateStringField = PrivateMember.class.
			            getDeclaredField("testPrivateString");

			privateStringField.setAccessible(true);

			String fieldValue = (String) privateStringField.get(privateObject);
			
			System.out.println("testPrivateString value = " + fieldValue);
			
			//Access private methods
			Method privateVoidMethod = PrivateMember.class
					.getDeclaredMethod("sayHello", null);

			privateVoidMethod.setAccessible(true);

			privateVoidMethod.invoke(privateObject, null);			
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}