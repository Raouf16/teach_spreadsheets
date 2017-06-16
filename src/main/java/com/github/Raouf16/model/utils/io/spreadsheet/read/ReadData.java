package com.github.Raouf16.model.utils.io.spreadsheet.read;


import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



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
	 */
	public List<String> getFilieres(SpreadsheetDocument spreadSheetReadingData) 
	{
		List <String> filieres = new ArrayList<>();
		
		int countSheets = spreadSheetReadingData.getSheetCount();
		for (int i=2; i<countSheets; i++) filieres.add(spreadSheetReadingData.getSheetByIndex(i).getTableName());
		return filieres;
	}
	
	/***
	 * This static method is to get Semesters from the spreadsheet
	 * @param year
	 * @return
	 */
	public List<String> getSemesters(SpreadsheetDocument spreadSheetReadingData, String formation) 
	{
		
		if (formation == null) return new ArrayList<>();
		if(formation.equals("APPRENTISSAGE"))
		{
			List<String> semesters = new ArrayList<>();
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			String semester = sheet.getCellByPosition("A3").getDisplayText();
			System.out.println("Semestre APP:"+semester);
			semester = semester.trim();
			semesters.add(""+semester.charAt(semester.length()-1));
			semester = sheet.getCellByPosition("G3").getDisplayText();
			semester = semester.trim();
			semesters.add(""+semester.charAt(semester.length()-1));
			return semesters;
		}
		else if(formation.equals("LSO"))
		{
			List<String> semesters = new ArrayList<>();
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			String semester = sheet.getCellByPosition("A2").getDisplayText();
			System.out.println("Semestre LSO:"+semester);
			System.out.println(semester);
			semester = semester.trim();
			System.out.println(semester);
			semesters.add(""+semester.charAt(semester.length()-1));
			semester = sheet.getCellByPosition("A12").getDisplayText();
			semester = semester.trim();
			semesters.add(""+semester.charAt(semester.length()-1));
			return semesters;
		}
		else
		{
			List<String> semesters = new ArrayList<>();
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			String semester = sheet.getCellByPosition("B2").getDisplayText();
			System.out.println("Semestre OTHER:"+semester);
			semester = semester.trim();
			semesters.add(""+semester.charAt(semester.length()-1));
			semester = sheet.getCellByPosition("P2").getDisplayText();
			semester = semester.trim();
			semesters.add(""+semester.charAt(semester.length()-1));
			return semesters;
		}
	}
	
	/***
	 * This static method is to get the courses from a spreadsheet 
	 * @param year and semester
	 * @return List of courses
	 * @throws IOException
	 */
	public List<String> getCourses(SpreadsheetDocument spreadSheetReadingData, String formation, String semester)
	{
		if (formation == null) return new ArrayList<>();
		if(formation.equals("APPRENTISSAGE"))
		{
			List<String> courses = new ArrayList<>();
			int sem;
			try {sem = Integer.parseInt(semester);}
			catch (NumberFormatException e) {
				System.out.println(e);
				return courses;}
			String range ;
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			if (sem % 2 != 0) range = "A" ;
			else range = "G";
			String course ;
			for (int i=5; i<15; i++)
			{
				course = sheet.getCellByPosition(range+i).getDisplayText();
				if (course.length() == 0) break;
				courses.add(course);
			}
			return courses;
		}
		else if(formation.equals("LSO"))
		{
			List<String> coursesLSO = new ArrayList<>();
			int sem;
			try {sem = Integer.parseInt(semester);}
			catch (NumberFormatException e) {
				System.out.println(e);
				return coursesLSO;}
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
				course = sheet.getCellByPosition(range+i).getDisplayText();
				if (course.length() == 0) break;
				coursesLSO.add(course);
			}
			return coursesLSO;
		}
		else
		{
			List<String> courses = new ArrayList<>();
			int sem;
			try {sem = Integer.parseInt(semester);}
			catch (NumberFormatException e){
				System.out.println(e);
				return courses;}
			String range ;
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			if (sem % 2 != 0) range = "B" ;
			else range = "P";
			int countRows = sheet.getRowCount();
			String course ;
			for (int i=4; i<countRows; i++)
			{
				course = sheet.getCellByPosition(range+i).getDisplayText();
				if (course.length() == 0) break;
				courses.add(course);
			}
			return courses;
		}
			
		
		
		
	}

}