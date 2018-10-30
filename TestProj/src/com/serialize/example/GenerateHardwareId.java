package com.serialize.example;

import java.io.Serializable;

public class GenerateHardwareId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4642602678426036448L;
	
	private String name ;//="Mac Address";
	private String macAddress;//= null;//jscc.getSystemMac();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	@Override
	public String toString() {
		return "GenerateHardwareId [name=" + name + ", macAddress=" + macAddress + "]";
	}
	
	

}
