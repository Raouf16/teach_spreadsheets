package com.github.Raouf16.model.teacherUtils;

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
	
	
	
	
	/**
	 * Constructor by default
	 */
	public Teacher() {
		firstName="";
		lastName="";
		numEn="";
		adress="";
		postalCode="";
		city="";
		status=""; 
		dauphineEmail="";
		personalEmail="";
		personalPhone="";
		mobilePhone="";
		dauphinePhone="";
		office="";
	}

	//Constructor we will remove soon but we have to do some modifications before
	
		public Teacher (String [] infos) 
		{
			if (infos == null) throw new IllegalArgumentException("Erreur ! entrée incorrecte");
			if (infos[0] == "") throw new IllegalArgumentException("Nom pas renseigné");
			else firstName = infos[0];
			if (infos[1] == "") throw new IllegalArgumentException("Nom pas renseigné");
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
		if (adress==null || adress=="") throw new IllegalArgumentException();
		this.adress = adress;
	}

	public String getPostalCode() {
		return postalCode;
	}
	

	public void setPostalCode(String postalCode) {
		if (postalCode==null || postalCode=="") throw new IllegalArgumentException();
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		if (city==null || city=="") throw new IllegalArgumentException();
		this.city = city;
	}

	public String getDauphineEmail() {
		return dauphineEmail;
	}

	public void setDauphineEmail(String dauphineEmail) {
		if (dauphineEmail==null || dauphineEmail=="") throw new IllegalArgumentException();
		this.dauphineEmail = dauphineEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		if (personalEmail==null || personalEmail=="") throw new IllegalArgumentException();
		this.personalEmail = personalEmail;
	}

	public String getPersonalPhone() {
		return personalPhone;
	}

	public void setPersonalPhone(String personalPhone) {
		if (personalPhone==null || personalPhone=="") throw new IllegalArgumentException();
		this.personalPhone = personalPhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		if (mobilePhone==null || mobilePhone=="") throw new IllegalArgumentException();
		this.mobilePhone = mobilePhone;
	}

	public String getDauphinePhone() {
		return dauphinePhone;
	}

	public void setDauphinePhone(String dauphinePhone) {
		if (dauphinePhone==null || dauphinePhone=="") throw new IllegalArgumentException();
		this.dauphinePhone = dauphinePhone;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		if (office==null || office=="") throw new IllegalArgumentException();
		this.office = office;
	}

	public void setStatus(String status) {
		if (status==null || status=="") throw new IllegalArgumentException();
		this.status = status;
	}


	
	@Override 
	public String toString()
	{
		String s = "";
		if (firstName != null) s += "Fist name : "+firstName+"\n";
		if (lastName != null)s += "Last name : "+lastName+"\n";
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
		return s;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getNumEn() {
		return numEn;
	}

	public void setFirstName(String text) {
		if (text==null || text=="") throw new IllegalArgumentException();
		firstName = text;
		
	}

	public void setNumEn(String text) {
		if (text==null || text=="") throw new IllegalArgumentException();
		numEn = text;
		
	}

	public void setLastName(String text) {
		if (text==null || text=="") throw new IllegalArgumentException();
		lastName = text;
		
	}
	

}
