package com.github.Raouf16.model.teacherUtils;

import java.util.ArrayList;

import com.github.Raouf16.model.preferenceUtils.Preference;

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
	private ArrayList<Preference> preferences = new ArrayList<Preference>();
	
	
	//Constructor
	
	public Teacher (String [] infos) throws Exception
	{
		if (infos == null) throw new IllegalArgumentException("Erreur ! entrée incorrecte");
		if (infos[0] == "") throw new Exception("Nom pas renseigné");
		else firstName = infos[0];
		if (infos[1] == "") throw new Exception("Nom pas renseigné");
		else lastName = infos[1];
		adress = infos[2].equals("") ? null : infos[2] ;
		postalCode = infos[3].equals("") ? null : infos[3] ;
		city = infos[4].equals("") ? null : infos[4] ;
		personalPhone = infos[5].equals("") ? null : infos[5] ;
		mobilePhone = infos[6].equals("") ? null : infos[6] ;
		personalEmail = infos[7].equals("") ? null : infos[7] ;
		dauphineEmail = infos[8].equals("") ? infos[8] : null ;
		status = infos[9].equals("") ? null : infos[9] ;
		dauphinePhone = infos[10].equals("") ? null : infos[10] ;
		office = infos[11].equals("") ? null : infos[11] ;
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

	public ArrayList<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(ArrayList<Preference> preferences) {
		this.preferences = preferences;
	}
	
	public void addPreference(Preference pref)
	{
		if (pref != null) preferences.add(pref);
	}

	public boolean equals(Teacher t) {
		return numEn.equals(t);
	}
	

}
