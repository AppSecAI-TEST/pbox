package com.ldroid.pbox.entities.in;

import com.google.gson.annotations.Expose;
import com.ldroid.pbox.common.entities.InputEntity;

public class LoginInEntity extends InputEntity {

	
	@Expose
	public String utel ;
	@Expose public String upwd ;
	


	public LoginInEntity(String utel, String upwd) {
		super();
		this.utel = utel;
		this.upwd = upwd;
	}

	
	
}
