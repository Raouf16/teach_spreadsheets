package com.github.Raouf16.model.excelWrite;

import java.io.File;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;


import com.github.Raouf16.model.teacherUtils.Teacher;

/**
 * This class write general informations about the teacher 
 *
 */

public class WriteInformations {

	public static void write(Teacher t) throws Exception{
		 
		 try{
			 
			 File outputFile = new File("src/main/resources/com/github/Raouf16/Ecrire_saisie_voeux.ods");
			 // Load the sheet
			 final SpreadSheet spreadSheet = SpreadSheet.createFromFile(outputFile);
		 
			 final Sheet sheet = spreadSheet.getSheet("Coordonnées");
			 //Change the name
			 sheet.getCellAt("B2").setValue(t.getLastName());
			 // Change the firstname
			 sheet.getCellAt("F2").setValue(t.getFirstName());
		 
			 // Load the second sheet
			 final Sheet secondSheet = spreadSheet.getSheet("Emplois_du_temps");
			 // set the name
			 secondSheet.getCellAt("B2").setValue(t.getLastName());
			 // set the firstname
			 secondSheet.getCellAt("F2").setValue(t.getFirstName());	
			 // set the adress
			 secondSheet.getCellAt("B4").setValue(t.getAdress());
			 // set the phone number
			 secondSheet.getCellAt("E6").setValue(t.getMobilePhone());	
			 // set City
			 secondSheet.getCellAt("D5").setValue(t.getCity());	
			 // set Postal Code
			 secondSheet.getCellAt("B5").setValue(t.getPostalCode());	
			 // set Personal Email
			 secondSheet.getCellAt("B8").setValue(t.getPersonalEmail());
			 // set Dauphine Email
			 secondSheet.getCellAt("B9").setValue(t.getDauphineEmail());	
			 // set Teacher Status
			 secondSheet.getCellAt("B11").setValue(t.getStatus());	
			 // set Dauphine Phone
		 	secondSheet.getCellAt("E11").setValue(t.getDauphinePhone());	
		 	// set Office number
		 	secondSheet.getCellAt("H11").setValue(t.getOffice());	
		 
		 	// Save the file
		 	File endFile = new File("src/main/resources/com/github/Raouf16/Voeuxtestinformation.ods");
		 	spreadSheet.saveAs(endFile);
		 }catch(NullPointerException e){
			 System.out.println("Fichier source introuvable !");
		 } 
		 
		 
	}
}


