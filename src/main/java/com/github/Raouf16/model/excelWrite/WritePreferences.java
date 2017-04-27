package com.github.Raouf16.model.excelWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import com.github.Raouf16.model.teacherUtils.Teacher;
import com.github.Raouf16.model.preferenceUtils.Preference;
/**
 * This class write the preferences of a teacher 
 * @author Raouf HADDAD
 */
public class WritePreferences {
	
	public static void write(Teacher t, File f, ArrayList<Preference> p) throws IOException{
			 
			 File outputFile = f;
			 // Load the sheet
			 final SpreadSheet spreadSheet = SpreadSheet.createFromFile(outputFile);
		     // We browse all the Preference list
			 for (Preference s : p) {
				 // For each preference, it might be a different Year, so we have 
				 // to open the right sheet everytime
				 final Sheet sheet = spreadSheet.getSheet(s.getYear());
				 
				 
				// For semesters 1, 3 or 5
				 if(Integer.parseInt(s.getSemester()) == 1 || Integer.parseInt(s.getSemester()) == 3 || Integer.parseInt(s.getSemester()) == 5){
					 writeS1(s, sheet);
				 }
				// For semesters 2, 4 or 6
				 else if(Integer.parseInt(s.getSemester()) == 2 || Integer.parseInt(s.getSemester()) == 4 || Integer.parseInt(s.getSemester()) == 6){
					writeS2(s, sheet);
				 }
			 }
			 
			 save(t,spreadSheet);
	}
	
	public static void writeS1(Preference s, Sheet sheet){
		int y = 2;
		 //We look for the right cell
		do{
			 //If we found a cell that have the same subject as the preference
			y += 1;
				 
			 
		 }while(sheet.getCellAt(1,y).getTextValue().equals(s.getSubject()) == false);
		//We verify that this cell is empty and that we don't want to write a NULL
		 if (s.getChoiceCourse() != null){
			 // And here we write the course choice (A,B or C)
			 sheet.getCellAt(9,y).setValue(s.getChoiceCourse());
		 }
		  // Now we put de TD choice
		 if (s.getChoiceTD() != null){
			 sheet.getCellAt(10,y).setValue(s.getChoiceTD());
		 }
		 // Now we put the TP choice
		 if (s.getChoiceTP() != null){
			 sheet.getCellAt(11,y).setValue(s.getChoiceTP());
		 }
	}
				 
	public static void writeS2(Preference s, Sheet sheet){
		
		int y = 2;
		 //We look for the right cell
		do{
			 //If we found a cell that have the same subject as the preference
			y += 1;
				 	 
		 }while(sheet.getCellAt(15,y).getTextValue().equals(s.getSubject()) == false);
		//We verify that this cell is empty and that we don't want to write a NULL
		 if (s.getChoiceCourse() != null){
			 // And here we write the course choice (A,B or C)
			 sheet.getCellAt(23,y).setValue(s.getChoiceCourse());
		 }
		  // Now we put de TD choice
		 if (s.getChoiceTD() != null){
			 sheet.getCellAt(24,y).setValue(s.getChoiceTD());
		 }
		 // Now we put the TP choice
		 if (s.getChoiceTP() != null){
			 sheet.getCellAt(25,y).setValue(s.getChoiceTP());
		 }
	}
				 
				 
	//Save the ODS file		 
	public static void save(Teacher t, SpreadSheet spreadSheet) throws IOException{	 
		 	// Save the file
			 String newFileName = t.firstName+"_"+t.lastName+"_"+"pref.ods";
		 	File endFile = new File(newFileName);
		 	try {
				spreadSheet.saveAs(endFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
	}
}