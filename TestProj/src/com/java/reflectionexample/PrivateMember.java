package com.java.reflectionexample;

public class PrivateMember {
	private String testPrivateString = null;
	public String testPublicString = null;
	
	public PrivateMember(String privateString) {
			this.testPrivateString = privateString;
		//	System.setSecurityManager(new SecurityManager());
	}

	public void setTestPublicString(String testPublicString) {
		this.testPublicString = testPublicString;
	}
	
	private void sayHello(){
		System.out.println("Hello"+testPrivateString);
	}
	
	public void sampleMethod(){
		System.out.println("Sample Method");
	}
}
