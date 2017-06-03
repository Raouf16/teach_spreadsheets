package com.github.Raouf16.model.spreadsheet.read;


import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;


import java.io.IOException;
import java.util.ArrayList;



/**
 * This class is a test about reading courses from excel file
 * @author Raouf HADDAD & Sonia ASSAM
 *
 */
public class ReadData 
{
	
	/***
	 * This static method is to get the years from the spreadsheet
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String> getFilieres(SpreadsheetDocument spreadSheetReadingData) throws IOException 
	{
		ArrayList <String> filieres = new ArrayList<String>();
		
		int countSheets = spreadSheetReadingData.getSheetCount();
		for (int i=2; i<countSheets; i++) filieres.add(spreadSheetReadingData.getSheetByIndex(i).getTableName());
		return filieres;
	}
	
	/***
	 * This static method is to get Semesters from the spreadsheet
	 * @param year
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String> getSemesters(SpreadsheetDocument spreadSheetReadingData, String formation) throws IOException 
	{
		
		if(formation.equals("APPRENTISSAGE"))
		{
			ArrayList<String> semesters = new ArrayList<String>();
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			String semester = (String) sheet.getCellByPosition("A3").getDisplayText();
			System.out.println("Semestre APP:"+semester);
			semester = semester.trim();
			semesters.add(""+semester.charAt(semester.length()-1));
			semester = (String) sheet.getCellByPosition("G3").getDisplayText();
			semester = semester.trim();
			semesters.add(""+semester.charAt(semester.length()-1));
			return semesters;
		}
		else if(formation.equals("LSO"))
		{
			ArrayList<String> semesters = new ArrayList<String>();
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			String semester = (String) sheet.getCellByPosition("A2").getDisplayText();
			System.out.println("Semestre LSO:"+semester);
			System.out.println(semester);
			semester = semester.trim();
			System.out.println(semester);
			semesters.add(""+semester.charAt(semester.length()-1));
			semester = (String) sheet.getCellByPosition("A12").getDisplayText();
			semester = semester.trim();
			semesters.add(""+semester.charAt(semester.length()-1));
			return semesters;
		}
		else
		{
			ArrayList<String> semesters = new ArrayList<String>();
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			String semester = (String) sheet.getCellByPosition("B2").getDisplayText();
			System.out.println("Semestre OTHER:"+semester);
			semester = semester.trim();
			semesters.add(""+semester.charAt(semester.length()-1));
			semester = (String) sheet.getCellByPosition("P2").getDisplayText();
			semester = semester.trim();
			semesters.add(""+semester.charAt(semester.length()-1));
			return semesters;
		}
	}
	
	/***
	 * This static method is to get the courses in a the spreadsheet in parameters
	 * @param year and semester
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String> getCourses(SpreadsheetDocument spreadSheetReadingData, String formation, String semester)
	{
		if(formation.equals("APPRENTISSAGE"))
		{
			ArrayList<String> courses = new ArrayList<String>();
			int sem;
			try {sem = (int)Integer.parseInt(semester);}
			catch (NumberFormatException e) {return courses;}
			String range ;
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			if (sem % 2 != 0) range = "A" ;
			else range = "G";
			String course ;
			for (int i=5; i<15; i++)
			{
				course = (String) sheet.getCellByPosition(range+i).getDisplayText();
				if (course.length() == 0) break;
				else courses.add(course);
			}
			return courses;
		}
		//the else is for LSO, but we have to do another if for APPRENTISSAGE
		else if(formation.equals("LSO"))
		{
			ArrayList<String> coursesLSO = new ArrayList<String>();
			int sem;
			try {sem = (int)Integer.parseInt(semester);}
			catch (NumberFormatException e) {return coursesLSO;}
			int row1;
			int row2;
			String range;
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			if (sem % 2 != 0)
			{
				row1 = 4;
				row2 = 12;
			}
			else{
				row1 = 14;
				row2 = 19;
			}
			range = "A";
			String course ;
			for (int i = row1; i<row2; i++)
			{
				course = (String) sheet.getCellByPosition(range+i).getDisplayText();
				if (course.length() == 0) break;
				else coursesLSO.add(course);
			}
			return coursesLSO;
		}
		else
		{
			ArrayList<String> courses = new ArrayList<String>();
			int sem;
			try {sem = (int)Integer.parseInt(semester);}
			catch (NumberFormatException e) {return courses;}
			String range ;
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			if (sem % 2 != 0) range = "B" ;
			else range = "P";
			int countRows = sheet.getRowCount();
			String course ;
			for (int i=4; i<countRows; i++)
			{
				course = (String) sheet.getCellByPosition(range+i).getDisplayText();
				if (course.length() == 0) break;
				else courses.add(course);
			}
			return courses;
		}
			
		
		
		
	}

}