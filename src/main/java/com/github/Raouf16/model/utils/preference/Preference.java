package com.github.Raouf16.model.utils.preference;


/**
 * This class contains information about a preference for a teacher.
 *@author haya
 *
 */
public class Preference 
{

    private String year; // example DE1
    private String semester;
    private String subject; // the title of the course
    private String choiceCourse; // between A and C
    private String choiceTD; // between A and C	
    private String choiceTP; // between A and C
    private int nbrTD;  // the number of td you want
    private int nbrYear; // the number of year of experience

    //Constructor

    public Preference() {}
    

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getChoiceCourse() {
        return choiceCourse;
    }
    public void setChoiceCourse(String choiceCourse) {
        this.choiceCourse = choiceCourse;
    }
    public String getChoiceTD() {
        return choiceTD;
    }
    public void setChoiceTD(String choiceTD) {
        this.choiceTD = choiceTD;
    }
    public String getChoiceTP() {
        return choiceTP;
    }
    public void setChoiceTP(String choiceTP) {
        this.choiceTP = choiceTP;
    }
    public int getNbrTD() {
        return nbrTD;
    }
    public void setNbrTD(int nbrTD) {
        this.nbrTD = nbrTD;
    }
    
    public void setNbrTD(String nbrTD) {
        this.nbrTD = Integer.parseInt(nbrTD);
    }
    public int getNbrYear() {
        return nbrYear;
    }
    
    public void setNbrYear(int nbrYear) {
        this.nbrYear = nbrYear;
    }
    
    public void setNbrYear(String nbrYear) {
        this.nbrYear = Integer.parseInt(nbrYear);
    }

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String toString()
	{
		String s = "";
		if (year != null) s += "Year : "+year+"\n";
		if (semester != null)s += "Semester : "+semester+"\n";
		if (subject != null)s += "Subject : "+subject+"\n";
		if (choiceCourse != null) s += "Choice course : "+choiceCourse+"\n";
		if (choiceTD != null) s += "Choice TD : "+choiceTD+"\n";
		if (choiceTP != null) s += "Choice TP : "+choiceTP+"\n";
		s += "Nbr TD : "+nbrTD+"\n";
		s += "Nbr year : "+nbrYear+"\n";
		return s;
	}


}
