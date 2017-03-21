package com.github.Raouf16.model.excelWrite;

import java.io.File;


import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import com.github.Raouf16.model.teacherUtils.Teacher;
/**
 * This class is a test about writing the teacher informations on the ODS file 
 * and can also generate a empty spreadSheet of the preference ODS.
 *
 */

public class TestWrite {

	public void generateEmptySpreadsheet() throws Exception {
		
		// Load the file.
		 File file = new File("Saisie_voeux.ods");
		 final SpreadSheet sheet = SpreadSheet.createFromFile(file);
		 
		 // Save to file and open it.
		 File outputFile = new File("Voeuxtest.ods");
		 OOUtils.open(sheet.saveAs(outputFile));

	}
	
	public static void writeInformations(Teacher t) throws Exception{
		 
		
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
		//Change the name
		 secondSheet.getCellAt("B2").setValue(t.getLastName());
		 // Change the firstname
		 secondSheet.getCellAt("F2").setValue(t.getFirstName());	
		//Change the adress
		 secondSheet.getCellAt("B4").setValue(t.getAdress());
		 // Change the phone number
		 secondSheet.getCellAt("E6").setValue(t.getMobilePhone());	
		 
		 // Save to file and open it.
		 File endFile = new File("src/main/resources/com/github/Raouf16/Voeuxtestinformation.ods");
		 OOUtils.open(spreadSheet.saveAs(endFile));
		 
		 
	}
}


