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
		ArrayList<String> semesters = new ArrayList<String>();
		Table sheet = spreadSheetReadingData.getSheetByName(formation);
		String semester = (String) sheet.getCellByPosition("B2").getDisplayText();
		semester = semester.trim();
		semesters.add(""+semester.charAt(semester.length()-1));
		semester = (String) sheet.getCellByPosition("P2").getDisplayText();
		semester = semester.trim();
		semesters.add(""+semester.charAt(semester.length()-1));
		return semesters;
	}
	
	/***
	 * This static method is to get the courses in a the spreadsheet in parameters
	 * @param year and semester
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String> getCourses(SpreadsheetDocument spreadSheetReadingData, String formation, String semester)
	{
		if(formation != "LSO" && formation != "APPRENTISSAGE")
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
		//the else is for LSO, but we have to do another if for APPRENTISSAGE
		else 
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
				row2 = 11;
			}
			else{
				row1 = 14;
				row2 = 18;
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
			
		
		
		
	}

}