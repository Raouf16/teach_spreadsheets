package com.github.Raouf16.model.excelWrite;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import com.github.Raouf16.model.teacherUtils.Teacher;
import com.github.Raouf16.model.preferenceUtils.Preference;

public class WritePreferences {
	public static void write(File f, Preference p) throws IOException{
		/*try{
			 
			 File outputFile = f;
			 // Load the sheet
			 final SpreadSheet spreadSheet = SpreadSheet.createFromFile(outputFile);
		 
			 final Sheet sheet = spreadSheet.getSheet(p.getSubject());
			 //Change the name
		 
			 if((p.getSubject() != "LSO") && p.getSubject() != "APPRENTISSAGE"){
				 // set the name
				 if(t.getLastName() != null) secondSheet.getCellAt("B2").setValue(t.getLastName());
				 // set the firstname
				 if(t.getFirstName() != null) secondSheet.getCellAt("F2").setValue(t.getFirstName());	
	
		 
		 	// Save the file
		 	File endFile = new File("src/main/resources/com/github/Raouf16/Voeuxtestinformation.ods");
		 	spreadSheet.saveAs(endFile);
		}catch(NullPointerException e){
			 System.out.println("Fichier source introuvable !");
		} */
	}
}
