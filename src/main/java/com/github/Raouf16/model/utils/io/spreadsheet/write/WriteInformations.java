package com.github.Raouf16.model.utils.io.spreadsheet.write;

import java.io.File;


import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.teacher.*;


/**
 * This class write general informations about the teacher 
 * return a File 
 * @author Raouf HADDAD
 */
public class WriteInformations {

	public static File write(Teacher t) throws Exception
	{
		 
			 // Load the sheet
			 final SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(Main.fileReadingData);
			 final Table sheet = spreadSheet.getSheetByName("Coordonnées");
			 
			 
			 //Change the name
			 sheet.getCellByPosition("B2").setDisplayText(t.getLastName());
			 // Change the firstname
			 sheet.getCellByPosition("F2").setDisplayText(t.getFirstName());
		 
			 // Load the second sheet
			 final Table secondSheet = spreadSheet.getSheetByName("Emplois_du_temps");
			 // set the name
			 if(t.getLastName() != null) secondSheet.getCellByPosition("B2").setDisplayText(t.getLastName());
			 // set the firstname
			 if(t.getFirstName() != null) secondSheet.getCellByPosition("F2").setDisplayText(t.getFirstName());	
			 // set the adress
			 if(t.getAdress() != null) secondSheet.getCellByPosition("B4").setDisplayText(t.getAdress());
			 // set the phone number
			 if(t.getMobilePhone() != null) secondSheet.getCellByPosition("E6").setDisplayText(t.getMobilePhone());	
			 // set City
			 if(t.getCity() != null) secondSheet.getCellByPosition("D5").setDisplayText(t.getCity());	
			 // set Postal Code
			 if(t.getPostalCode() != null) secondSheet.getCellByPosition("B5").setDisplayText(t.getPostalCode());	
			 // set Personal Email
			 if(t.getPersonalEmail() != null) secondSheet.getCellByPosition("B8").setDisplayText(t.getPersonalEmail());
			 // set Dauphine Email
			 if(t.getDauphineEmail() != null) secondSheet.getCellByPosition("B9").setDisplayText(t.getDauphineEmail());	
			 // set Teacher Status
			 if(t.getStatus() != null) secondSheet.getCellByPosition("B11").setDisplayText(t.getStatus());	
			 // set Dauphine Phone
			 if(t.getDauphinePhone() != null) secondSheet.getCellByPosition("E11").setDisplayText(t.getDauphinePhone());	
		 	 // set Office number
			 if(t.getOffice() != null) secondSheet.getCellByPosition("H11").setDisplayText(t.getOffice());	
		    
		 	 // Save the file
			 String newFileName = t.getFirstName()+"_"+t.getLastName()+".ods";
		 	 File endFile = new File(Main.outputsFolderPath+"excel/"+newFileName);
		 	 spreadSheet.save(endFile);
		 	 return endFile;
		 
	}
}


