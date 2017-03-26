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
			 if(t.getLastName() != null) secondSheet.getCellAt("B2").setValue(t.getLastName());
			 // set the firstname
			 if(t.getFirstName() != null) secondSheet.getCellAt("F2").setValue(t.getFirstName());	
			 // set the adress
			 if(t.getAdress() != null) secondSheet.getCellAt("B4").setValue(t.getAdress());
			 // set the phone number
			 if(t.getMobilePhone() != null) secondSheet.getCellAt("E6").setValue(t.getMobilePhone());	
			 // set City
			 if(t.getCity() != null) secondSheet.getCellAt("D5").setValue(t.getCity());	
			 // set Postal Code
			 if(t.getPostalCode() != null) secondSheet.getCellAt("B5").setValue(t.getPostalCode());	
			 // set Personal Email
			 if(t.getPersonalEmail() != null) secondSheet.getCellAt("B8").setValue(t.getPersonalEmail());
			 // set Dauphine Email
			 if(t.getDauphineEmail() != null) secondSheet.getCellAt("B9").setValue(t.getDauphineEmail());	
			 // set Teacher Status
			 if(t.getStatus() != null) secondSheet.getCellAt("B11").setValue(t.getStatus());	
			 // set Dauphine Phone
			 if(t.getDauphinePhone() != null) secondSheet.getCellAt("E11").setValue(t.getDauphinePhone());	
		 	// set Office number
			 if(t.getOffice() != null) secondSheet.getCellAt("H11").setValue(t.getOffice());	
		 
		 	// Save the file
		 	File endFile = new File("src/main/resources/com/github/Raouf16/Voeuxtestinformation.ods");
		 	spreadSheet.saveAs(endFile);
		}catch(NullPointerException e){
			 System.out.println("Fichier source introuvable !");
		} 
		 
		 
	}
}


