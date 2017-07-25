package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;

public class LoginBean{
	private String email;

	private String password;

	public String getPassword(){
			return this.password;
	}

	public String getEmail(){
			return this.email;
	}

	public void setEmail(String email){
			this.email = email;
	}

	public void setPassword(String password){
			this.password = password;
	}


}

