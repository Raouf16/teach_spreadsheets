package com.github.Raouf16.model.utils.teacher;

import java.util.ArrayList;
import java.util.List;

import com.github.Raouf16.model.utils.preference.*;

public class Teacher 
{
	
	/**
	 * Class Teacher which contains attributes of teachers  
	 */
	
	public String firstName;
	public String lastName;
	public String numEn;
	private String adress;
	private String postalCode;
	private String city;
	private String status; 
	private String dauphineEmail;
	private String personalEmail;
	private String personalPhone;
	private String mobilePhone;
	private String dauphinePhone;
	private String office;
	private String civility;
	private String discipline;
	private List<Preference> preferences = new ArrayList<Preference>();
	
	
	//Constructor
	
	public Teacher (String [] infos) throws IllegalArgumentException
	{
		if (infos == null) throw new IllegalArgumentException("Erreur ! entrée incorrecte");
		firstName = infos[0];
		lastName = infos[1];
		numEn = infos[2].equals("") ? null : infos[2] ;
		civility = infos[3].equals("") ? null : infos[3] ;
		adress = infos[4].equals("") ? null : infos[4] ;
		postalCode = infos[5].equals("") ? null : infos[5] ;
		city = infos[6].equals("") ? null : infos[6] ;
		personalPhone = infos[7].equals("") ? null : infos[7] ;
		mobilePhone = infos[8].equals("") ? null : infos[8] ;
		personalEmail = infos[9].equals("") ? null : infos[9] ;
		dauphineEmail = infos[10].equals("") ? null : infos[10] ;
		status = infos[11].equals("") ? null : infos[11] ;
		dauphinePhone = infos[12].equals("") ? null : infos[12] ;
		office = infos[13].equals("") ? null : infos[13] ;
		discipline = infos[14].equals("") ? null : infos[14] ;
	}
	
	public Teacher() {}

	
	
	public String getStatus()
	{
		return status;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPostalCode() {
		return postalCode;
	}
	

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDauphineEmail() {
		return dauphineEmail;
	}

	public void setDauphineEmail(String dauphineEmail) {
		this.dauphineEmail = dauphineEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getPersonalPhone() {
		return personalPhone;
	}

	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getDauphinePhone() {
		return dauphinePhone;
	}

	public void setDauphinePhone(String dauphinePhone) {
		this.dauphinePhone = dauphinePhone;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
	@Override 
	public String toString()
	{
		String s = "";
		if (firstName != null) s += "Fist name : "+firstName+"\n";
		if (lastName != null)s += "Last name : "+lastName+"\n";
		if (numEn != null)s += "Numen : "+numEn+"\n";
		if (status != null) s += "Status : "+status+"\n";
		if (adress != null) s += "Adress : "+adress+"\n";
		if (postalCode != null) s += "Postal Code : "+postalCode+"\n";
		if (city != null) s += "City : "+city+"\n";
		if (dauphineEmail != null) s += "Dauphine email : "+dauphineEmail+"\n";
		if (personalEmail != null) s += "Personal email : "+personalEmail+"\n";
		if (personalPhone != null) s += "Personal phone : "+personalPhone+"\n";
		if (mobilePhone != null) s += "Mobile phone : "+mobilePhone+"\n";
		if (dauphinePhone != null) s += "Dauphine phone : "+personalPhone+"\n";
		if (office != null) s += "Office : "+office+"\n";
		s+="Preference:\n";
		for (int i=0; i<preferences.size(); i++){
			s+="numero "+Integer.toString(i+1)+'\n';
			s+=preferences.get(i).toString();
		}
		return s;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getNumEn() {
		return numEn;
	}

	public void setFirstName(String text) {
		firstName = text;
		
	}

	public void setNumEn(String text) {
		numEn = text;
		
	}

	public void setLastName(String text) {
		lastName = text;
		
	}

	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> tmpPref) {
		this.preferences = tmpPref;
	}
	
	public void addPreference(Preference pref)
	{
		if (pref != null) preferences.add(pref);
	}

	public boolean equals(Teacher t) {
		return numEn.equals(t);
	}

	public String getCivility() {
		return civility;
	}

	public void setCivility(String civility) {
		this.civility = civility;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	

}
