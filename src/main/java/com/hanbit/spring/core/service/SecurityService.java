package com.hanbit.spring.core.service;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
	
	private static PasswordEncoder encoder = new StandardPasswordEncoder();
	
// 방법1	
//	private static PasswordEncoder encoder;
//	static{
//		encoder = new StandardPasswordEncoder();
//	}

//	방법2
//	@PostConstruct // 스프링이 new한 후에 실행..?
//	public void initEncoder(){
//		encoder = new StandardPasswordEncoder();
//	}
	
	
	public static String encryptPassword(String rawPassword){
	
		String encryptPassword = encoder.encode(rawPassword);
		
		return encryptPassword;
	}
	
	
	public boolean matchPassword(String rawPassword, 
			String encryptPassword) {
		
		return encoder.matches(rawPassword, encryptPassword);
	}
	
//	public static void main(String[] args) {
//	//	System.out.println(matchPassword("abc", encryptPassword("abcd"));
//	}
	
}
