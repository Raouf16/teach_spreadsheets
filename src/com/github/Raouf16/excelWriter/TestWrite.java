package com.github.Raouf16.excelWriter;

import java.io.File;


import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 * This class is a test about writing the teacher informations on the ODS file 
 * and can also generate a empty spreadSheet of the preference ODS.
 *
 */

public class TestWrite {
	public static void main(String[] args) throws Exception{
		new TestWrite().generateEmptySpreadsheet();
		
		File outputFile = new File("Saisie_voeux.ods");
		new TestWrite().writeInformations(outputFile, "HADDAD", "Raouf", "99 Avenue Jean Jaurès", "0673302525");
	}

	public void generateEmptySpreadsheet() throws Exception {
		
		// Load the file.
		 File file = new File("Saisie_voeux.ods");
		 final SpreadSheet sheet = SpreadSheet.createFromFile(file);
		 
		 // Save to file and open it.
		 File outputFile = new File("Voeuxtest.ods");
		 OOUtils.open(sheet.saveAs(outputFile));

	}
	
	public void writeInformations(File outputFile, String name, String firstname, String adress, String tel) throws Exception{
		
		// Load the sheet
		 final SpreadSheet spreadSheet = SpreadSheet.createFromFile(outputFile);
		 
		 final Sheet sheet = spreadSheet.getSheet("Coordonnées");
		//Change the name
		 sheet.getCellAt("B2").setValue(name);
		 // Change the firstname
		 sheet.getCellAt("F2").setValue(firstname);
		 
		// Load the second sheet
		 final Sheet secondSheet = spreadSheet.getSheet("Emplois_du_temps");
		//Change the name
		 secondSheet.getCellAt("B2").setValue(name);
		 // Change the firstname
		 secondSheet.getCellAt("F2").setValue(firstname);	
		//Change the adress
		 secondSheet.getCellAt("B4").setValue(adress);
		 // Change the phone number
		 secondSheet.getCellAt("E6").setValue(tel);	
		 
		 // Save to file and open it.
		 File endFile = new File("Voeuxtestpreference.ods");
		 OOUtils.open(spreadSheet.saveAs(endFile));
		 
		 
	}
}


