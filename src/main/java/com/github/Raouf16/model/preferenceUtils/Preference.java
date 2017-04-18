package com.github.Raouf16.model.preferenceUtils;


/**
 * This class contains information about a preference for a teacher.
 *@author haya
 *
 */
public class Preference 
{

    private String year;
    private String semester;
    private String subject;
    private String choiceCourse;
    private String choiceTD;
    private String choiceTP;
    private String nbrTD;
    private String nbrYear;


    //Constructor

    public Preference() {}

    public Preference (String [] infos) throws IllegalArgumentException
    {
        if (infos == null) throw new IllegalArgumentException("Erreur ! entrée incorrecte");
        year = infos[0].equals("") ? null : infos[0] ;
        setSemester(infos[1].equals("") ? null : infos[1]) ;
        subject = infos[2].equals("") ? null : infos[2] ;
        choiceCourse = infos[3] == null || infos[3].equals("") ? null : infos[3] ;
        choiceTD = infos[4] == null || infos[4].equals("") ? null : infos[4] ;
        choiceTP = infos[5] == null || infos[5].equals("") ? null : infos[5] ;
        nbrTD = infos[6] == null || infos[6].equals("") ? null : infos[6] ;
        nbrYear = infos[7] == null || infos[7].equals("") ? null : infos[7] ;
    }


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
    public String getNbrTD() {
        return nbrTD;
    }
    public void setNbrTD(String nbrTD) {
        this.nbrTD = nbrTD;
    }
    public String getNbrYear() {
        return nbrYear;
    }
    public void setNbrYear(String nbrYear) {
        this.nbrYear = nbrYear;
    }

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}



}
