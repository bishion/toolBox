package com.bizi.core;

import org.junit.Test;

import java.io.*;

public class MakeObject {
	@Test
	public void testNew(){
		User user = new User();
		System.out.println(user.getUsername());

	}
	@Test
	public void testReflect() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Class clazz = Class.forName(User.class.getName());

		Object object = clazz.newInstance();
		if(object instanceof User){
			User user = (User)object;
			System.out.println(user.getPassword());
		}
	}
	@Test
	public void testClone() throws CloneNotSupportedException {
		User user1 = new User();
		User user2 = (User) user1.clone();
		user1.setPassword("new password");
		System.out.println(user2.getPassword());
	}
	@Test
	public void testSerializable() throws IOException, ClassNotFoundException {
		User user = new User();
		String file = "C:/User.txt";
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File(file)));
		oo.writeObject(user);

		oo.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(file)));
		User newUser = (User) ois.readObject();
		ois.close();
		System.out.println(newUser == user);
		System.out.println(newUser.getPassword());
	}
}
