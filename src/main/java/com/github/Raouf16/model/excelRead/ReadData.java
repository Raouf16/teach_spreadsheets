package com.github.Raouf16.model.excelRead;


import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import com.github.Raouf16.model.Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



/**
 * This class is a test about reading courses from excel file
 * @author Raouf HADDAD & Sonia ASSAM
 *
 */
public class ReadData 
{
	
	public static void main(String[] args) throws Exception
	{
		// Test with DE2 course program
		new ReadData().readCourses("DE2");	
	}
	
	//This method takes the name of the course program and returns the ID and Name of all courses by semester
	public void readCourses(String filiere) throws IOException
	{
		 //Getting sheet of the special year
        Sheet sheet = SpreadSheet.createFromFile(Main.fileReadingData).getSheet(filiere);
         //ArrayList that will contain the courses of the semestre 1
        ArrayList<Object> coursesS1 = new ArrayList<Object>();
        //ArrayList that will contain the courses of the semestre 2
        ArrayList<Object> coursesS2 = new ArrayList<Object>();
        
        // Print the name of the semester 1
        Object semestre1 = sheet.getValueAt("B2");
        System.out.println(semestre1+" : \n");
         
        // read the courses (ID,name) of the semestre1
        for (int rowIndex = 3 ; rowIndex < 13 ; rowIndex++)
        {
        	Object course = sheet.getValueAt(1, rowIndex);
        	Object courseID = sheet.getValueAt(2, rowIndex);
             // if the course has no ID, put "NOCOURSEID"
        	 if(courseID == ""){
             	coursesS1.add("NOCOURSEID");
             }
             else{
             	coursesS1.add(courseID);
             }
        	 coursesS1.add(course);
        }
        //Print the result
        for (int i = 1; i < coursesS1.size(); i+=2) 
        {
			System.out.println(coursesS1.get(i-1)+" : "+coursesS1.get(i));
		}

        // Print the name of the semester 2
        Object semestre2 = sheet.getValueAt("P2");
        System.out.println("\n"+semestre2+" : \n");
        
     // read the courses (ID,name) of the semestre2
        for (int rowIndex = 3 ; rowIndex < 15 ; rowIndex++)
        {
        	Object course = sheet.getValueAt(15, rowIndex);
        	Object courseID = sheet.getValueAt(16, rowIndex);
        	// if the course has no ID, put "NOCOURSEID"
            if(courseID == "") coursesS2.add("NOCOURSEID");
            else  	coursesS2.add(courseID);
        	coursesS2.add(course);
        }
        
        //Print the results
        for (int i = 1; i < coursesS2.size(); i+=2) 
        {
			System.out.println(coursesS2.get(i-1)+" : "+coursesS2.get(i));
		}

	}
	
	/***
	 * This static method is to get fillieres in a the spreadsheet in parameters
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String> getFilieres(SpreadSheet spreadSheetReadingData) throws IOException 
	{
		ArrayList <String> filieres = new ArrayList<String>();
		
		int countSheets = spreadSheetReadingData.getSheetCount();
		for (int i=2; i<countSheets; i++) filieres.add(spreadSheetReadingData.getSheet(i).getName());
		return filieres;
	}

	public static ArrayList<String> getSemesters(SpreadSheet spreadSheetReadingData, String formation) throws IOException 
	{
		ArrayList<String> semesters = new ArrayList<String>();
		Sheet sheet = spreadSheetReadingData.getSheet(formation);
		String semester = (String) sheet.getValueAt("B2");
		semester = semester.trim();
		semesters.add(""+semester.charAt(semester.length()-1));
		semester = (String) sheet.getValueAt("P2");
		semester = semester.trim();
		semesters.add(""+semester.charAt(semester.length()-1));
		return semesters;
	}
	
	public static ArrayList<String> getCourses(SpreadSheet spreadSheetReadingData, String formation, String semester)
	{
		ArrayList<String> courses = new ArrayList<String>();
		int sem;
		try {sem = (int)Integer.parseInt(semester);}
		catch (NumberFormatException e) {return courses;}
		String range ;
		Sheet sheet = spreadSheetReadingData.getSheet(formation);
		if (sem % 2 != 0) range = "B" ;
		else range = "P";
		int countRows = sheet.getRowCount();
		String course ;
		for (int i=4; i<countRows; i++)
		{
			course = (String) sheet.getValueAt(range+i);
			if (course.length() == 0) break;
			else courses.add(course);
		}
		return courses;
	}

}