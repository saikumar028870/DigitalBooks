package com.digitalbooks.demo.service;

import com.digitalbooks.demo.dto.AurthorDto;
import com.digitalbooks.demo.dto.AurthorSignUpDto;

public interface AurthorService {
	
	void registerAurthor(AurthorSignUpDto AurthorSignUpDto) throws Exception;
	
	boolean checkIfUserExist(String emailId);
	
	String aurthorLoggedIn(AurthorDto aurthorDto);
	
	String aurthorLoggedOut(AurthorDto aurthorDto);

}
