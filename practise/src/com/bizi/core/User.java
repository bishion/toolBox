package com.bizi.core;

import java.io.Serializable;

public class User implements Serializable,Cloneable{
	private String username = "bizi";
	private String password = "pass";

	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {

		return this==o;
	}

	@Override
	public int hashCode() {
		int result = username != null ? username.hashCode() : 0;
		result = 31 * result + (password != null ? password.hashCode() : 0);
		return result;
	}
}
