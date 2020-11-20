package com.cg.healthassist.util;

import java.util.List;

import com.cg.healthassist.daoimpl.PatientDAOImpl;
import com.cg.healthassist.model.Patient;

public class AuthenticationUtil {
	/**
	 * Patient username
	 */
	private String userName;
	/**
	 * Patient Password
	 */
	private String password;
	/**
	 * @return userName of patient
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * Set username of patient
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return password of patient
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Set password of the patient
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Method to validate patient username and password to avoid providing duplicates
	 * @param userName
	 * @param password
	 * @return true if unique details provided
	 */
	public boolean signUpVerifyUserNamePassword(String userName, String password) {
		boolean check=false;
		PatientDAOImpl patientDAOImpl = new PatientDAOImpl();
		List<Patient> patientDetails = patientDAOImpl.findAll();
		for(Patient patients: patientDetails) {
			if(patients.getPatientUserName().equals(userName)){
				if(patients.getPatientPassword().equals(password)){
					System.out.println("Please enter unique username and password");
					check = false;
					break;
				}
				else
				{
					System.out.println("Please enter unique username");
					check = false;
					break;
				}
			}
			else if(patients.getPatientPassword().equals(password)) {
				System.out.println("Please enter unique password");
				check =false;
				break;
			}
			else
			{
				System.out.println("You successfully registered. You can sign in");
				check = true;
				break;
			}
		}
		return check;
		
	}
	/**
	 * Method to check the provided username and password matching with the patient in database or not
	 * @param userName
	 * @param password
	 * @return true if username and password matched
	 */
	public boolean signInValidationOfUserNameAndPassword(String userName, String password) {
		boolean check=false;
		PatientDAOImpl patientDAOImpl = new PatientDAOImpl();
		List<Patient> patientDetails = patientDAOImpl.findAll();
		for(Patient patients: patientDetails) {
			if(!(patients.getPatientUserName().equals(userName)) && !(patients.getPatientPassword().equals(password))) {
				System.out.println("Incorrect UserName and Password");
				check = false;
				break;
			}
			else if(!(patients.getPatientPassword().equals(password))) {
					System.out.println("Incorrect Password");
					check = false;
					break;
				}	
			else if(!(patients.getPatientUserName().equals(userName))) {
				System.out.println("Incorrect UserName");
				check = false;
				break;
			}
			else {
				System.out.println("Sign in Successfully");
				check = true;
				break;
			}
		}
		return check;
	}
}
