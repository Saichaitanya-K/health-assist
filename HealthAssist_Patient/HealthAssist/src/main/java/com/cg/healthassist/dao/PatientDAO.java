package com.cg.healthassist.dao;

import com.cg.healthassist.model.Patient;
import java.util.List;

public interface PatientDAO {
	/**
	 * This method will save the data of the patient in database.
	 * @param patient, Instance of patient to persist.
	 */
	public void persist(Patient patient);
	
	/**
	 * Search the patient with given id in the database.
	 * @param id of the patient to search.
	 * @return the instance of patient if present else return null.
	 */
	public Patient findByPatientId(long id);
	
	/**
	 * Remove the given instance of patient from the database if present. 
	 * @param patient to remove.
	 */
	public void removePatient(Patient patient);
	
	/**
	 * Give all the instances of patients present inside database.
	 * @return the list of patient instances.
	 */
	public List<Patient> findAll();
	
	/**
	 * Update the given patient address inside the database if present.
	 * @param patient.
	 * @param patientAddress to update.
	 * @return true if successfully updated else return false.
	 */
	public boolean update(Patient patient,String patientAddress);
	
	/**
	 * Update the given patient phone number inside the database if present.
	 * @param patient.
	 * @param patientPhoneNumber to update.
	 * @return true if successfully updated else return false.
	 */
	public boolean update(Patient patient, long patientPhoneNumber);
}
