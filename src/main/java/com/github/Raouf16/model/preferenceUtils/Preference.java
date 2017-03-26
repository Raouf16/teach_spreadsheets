package com.github.Raouf16.model.preferenceUtils;


/**
 * This class contains information about a preference for a teacher.
 *@author haya
 *
 */
public class Preference {

    public String numEn;
    private String year;
    private String subject;
    private String choiceCourse;
    private String choiceTD;
    private String choiceTP;
    private String nbrTD;
    private String nbrYear;


    //Constructor

    public Preference() {}

    public Preference (String [] infos) throws Exception
    {
        if (infos == null) throw new IllegalArgumentException("Erreur ! entrée incorrecte");
        if (infos[0] == "") throw new Exception("Numen pas renseigné");
        else numEn = infos[0];
        year = infos[1].equals("") ? null : infos[1] ;;
        subject = infos[2].equals("") ? null : infos[2] ;
        choiceCourse = infos[3].equals("") ? null : infos[3] ;
        choiceTD = infos[4].equals("") ? null : infos[4] ;
        choiceTP = infos[5].equals("") ? null : infos[5] ;
        nbrTD = infos[6].equals("") ? null : infos[6] ;
        nbrYear = infos[7].equals("") ? null : infos[7] ;
    }


    public String getNumEn() {
        return numEn;
    }

    public void setNumEn(String numEn) {
        this.numEn = numEn;
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



}
