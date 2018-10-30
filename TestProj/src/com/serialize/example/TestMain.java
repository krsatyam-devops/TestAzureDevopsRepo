package com.serialize.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenerateHardwareId genObj = new GenerateHardwareId();
		genObj.setMacAddress("MAC ADD");;
		genObj.setName("name");
		
		try {
			FileOutputStream fos = new FileOutputStream("C:/Users/Public/HW-id.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(genObj);
			
			// closing resources
			oos.close();
			fos.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileInputStream is;
		try {
			is = new FileInputStream("C:/Users/Public/HW-id.txt");
			ObjectInputStream ois = new ObjectInputStream(is);
			genObj = (GenerateHardwareId) ois.readObject();

			ois.close();
			is.close();
			System.out.println(genObj.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
