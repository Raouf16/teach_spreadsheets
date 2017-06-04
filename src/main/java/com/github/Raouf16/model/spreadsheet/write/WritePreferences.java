package com.github.Raouf16.model.spreadsheet.write;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import com.github.Raouf16.model.utils.teacher.*;
import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.preference.*;


/**
 * This class write the preferences of a teacher 
 * @author Raouf HADDAD
 */
public class WritePreferences {
	
	public static void write(Teacher t, File f, List<Preference> list) throws Exception{
			 
			 File outputFile = f;
			 
			 int sem;
			 // Load the sheet
			 final SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(outputFile);
		     // We browse all the Preference list
			 for (Preference s : list) {
				 
				 // For each preference, it might be a different Year, so we have 
				 // to open the right sheet everytime
				 final Table sheet = spreadSheet.getSheetByName(s.getYear());
				 
				 try {sem = (int)Integer.parseInt(s.getSemester());}
					catch (NumberFormatException e){return;}
				 
				// For semesters 1, 3 or 5
				 if(sem % 2 != 0){
					 writeS1(s, sheet);
				 }
				// For semesters 2, 4 or 6
				 else{
					writeS2(s, sheet);
				 }
			 }
			 
			 save(t,spreadSheet);
	}
	
	/***
	 * This static method is to write the preferences for the semestre1
	 * @param you have to set the preference and the sheet
	 * @return
	 * @author Raouf HADDAD
	 * @throws IOException
	 */
	public static void writeS1(Preference s, Table sheet){
		int y = 2;
		 //We look for the right cell
		do{
			 //If we found a cell that have the same subject as the preference
			y += 1;
				 
			 
		 }while(sheet.getCellByPosition(1,y).getDisplayText().equals(s.getSubject()) == false);
		//We verify that this cell is empty and that we don't want to write a NULL
		 if (s.getChoiceCourse() != null){
			 // And here we write the course choice (A,B or C)
			 sheet.getCellByPosition(9,y).setDisplayText(s.getChoiceCourse());
		 }
		  // Now we put de TD choice
		 if (s.getChoiceTD() != null){
			 sheet.getCellByPosition(10,y).setDisplayText(s.getChoiceTD());
		 }
		 // Now we put the TP choice
		 if (s.getChoiceTP() != null){
			 sheet.getCellByPosition(11,y).setDisplayText(s.getChoiceTP());
		 }
	}
	
	/***
	 * This static method is to write the preferences for the semestre2
	 * @param you have to set the preference and the sheet
	 * @return
	 * @author Raouf HADDAD
	 * @throws IOException
	 */
	public static void writeS2(Preference s, Table sheet){
		
		int y = 2;
		 //We look for the right cell
		do{
			 //If we found a cell that have the same subject as the preference
			y += 1;
				 	 
		 }while(sheet.getCellByPosition(15,y).getDisplayText().equals(s.getSubject()) == false);
		//We verify that this cell is empty and that we don't want to write a NULL
		 if (s.getChoiceCourse() != null){
			 // And here we write the course choice (A,B or C)
			 sheet.getCellByPosition(23,y).setDisplayText(s.getChoiceCourse());
		 }
		  // Now we put de TD choice
		 if (s.getChoiceTD() != null){
			 sheet.getCellByPosition(24,y).setDisplayText(s.getChoiceTD());
		 }
		 // Now we put the TP choice
		 if (s.getChoiceTP() != null){
			 sheet.getCellByPosition(25,y).setDisplayText(s.getChoiceTP());
		 }
	}
				 
	/***
	 * This static method is to save the ODS File with preferences filled 
	 * @param the teacher and the spreadsheet
	 * @return
	 * @author Raouf HADDAD
	 * @throws IOException
	 */		 
	 
	public static void save(Teacher t, SpreadsheetDocument spreadSheet) throws Exception{	 
		 	// Save the file
			String newFileName = t.firstName+"_"+t.lastName+"_"+"pref.ods";
		 	try {
				spreadSheet.save(Main.canevasFolderPath+newFileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
	}
}