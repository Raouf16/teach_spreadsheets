package com.github.Raouf16.model.preferenceUtils;


/**
 * This class contains information about a preference for a teacher.
 *
 */
public class Preference {

    public String numEn;
    private String year;
    private String subject;
    private String choiceCourse;
    private String choiceTD;
    private String choiceTP;
    private int nbrTD;
    private int nbrYear;
    
/**
 * Constructor by default
 */
    public Preference() {
    	this.numEn="";
    	this.year="";
    	this.subject="";
    	this.choiceCourse= "";
    	this.choiceTD="";
    	this.choiceTP="";
    	this.nbrTD=0;
    	this.nbrYear=0;
    }

   
    public String getNumEn() {
        return numEn;
    }

    public void setNumEn(String numEn) {
    	if (numEn==null || numEn== "") throw new IllegalArgumentException();
        this.numEn =  numEn; // we should convert null into "" with guava 
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
    	if (year==null || year=="") throw new IllegalArgumentException();
        this.year = year;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
    	if (subject==null || subject=="") throw new IllegalArgumentException();
        this.subject = subject;
    }
    public String getChoiceCourse() {
        return choiceCourse;
    }
    public void setChoiceCourse(String choiceCourse) {
    	if (choiceCourse==null || choiceCourse=="") throw new IllegalArgumentException();
        this.choiceCourse = choiceCourse;
    }
    public String getChoiceTD() {
        return choiceTD;
    }
    public void setChoiceTD(String choiceTD) {
    	if (choiceTD==null || choiceTD=="") throw new IllegalArgumentException();
        this.choiceTD = choiceTD;
    }
    public String getChoiceTP() {
        return choiceTP;
    }
    public void setChoiceTP(String choiceTP) {
    	if (choiceTP==null || choiceTP=="") throw new IllegalArgumentException();
        this.choiceTP = choiceTP;
    }
    public int getNbrTD() {
        return nbrTD;
    }
    public void setNbrTD(int nbrTD) {
        this.nbrTD = nbrTD;
    }
    public int getNbrYear() {
        return nbrYear;
    }
    public void setNbrYear(int nbrYear) {
        this.nbrYear = nbrYear;
    }



}
