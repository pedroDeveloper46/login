package br.com.pedro.login.util;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class StringUtils {
	
	private static boolean isEmpty(String string) {
		
		if (string == null) {
			return true;
		}
		
		return string.trim().length() == 0;
	}
	
	public static String encrypt(String password) {
		
		if (isEmpty(password)) {
			return null;
		}
	   
	   PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
       return encoder.encode(password);
		
			
	}
	

}
