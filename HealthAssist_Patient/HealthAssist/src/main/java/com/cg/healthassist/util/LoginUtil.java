package com.cg.healthassist.util;
import java.util.*;

import com.cg.healthassist.exception.AuthenticationException;
import com.cg.healthassist.exception.InvalidException;

public class LoginUtil {
	public void loginUtil() throws InvalidException,AuthenticationException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Life Line Application");
		System.out.println("1.Sign Up\n2.Sign in");
		System.out.println("Please enter your choice");
		String choice = sc.nextLine();
		AuthenticationUtil verify = new AuthenticationUtil();
		if(choice.equalsIgnoreCase("Sign up"))
		{
			System.out.println("Enter your name : ");
			String name = sc.nextLine();
			System.out.println("Enter your age : ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your phone number : ");
			long phoneNumber = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter your address : ");
			String address = sc.nextLine();
			boolean verificationProcess=false;
			while(verificationProcess==false) {
				try{
					System.out.println("Enter unique username : ");
					String userName = sc.nextLine();
					System.out.println("Enter password : ");
					String password = sc.nextLine();
					if(userName.isBlank() && password.isBlank()) {
						throw new InvalidException("userName and password should not be empty");
					}
					else if(userName.isBlank()) {
						throw new InvalidException("userName should not be empty");
					}
					else if(password.isBlank()) {
						throw new InvalidException("Password should not be empty");
					}
					verificationProcess=verify.authenticateUserName(userName);
					if(!verificationProcess)
						throw new AuthenticationException("Username should be unique");
				}catch(InvalidException e) {
					throw e;
				}
				
			}
		}
		else {
			boolean loginValidation = false;
			System.out.println("Enter the username : ");
			String username = sc.nextLine();
			System.out.println("Enter the password : ");
			String password = sc.nextLine();
			loginValidation = verify.signInValidationOfUserNameAndPassword(username, password);
		}
	}
}