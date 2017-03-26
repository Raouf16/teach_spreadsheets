package com.github.Raouf16.model.excelWrite;

import java.io.File;

import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 * This class generate an empty spreadsheet of the teacher preferences ODS
 *
 */
public class GenerateEmptyFile {
	
	public void generate() throws Exception {

		try{
			// Load the file.
			File file = new File("src/main/resources/com/github/Raouf16/Lire_saisie_voeux.ods");
			// Open the file
			final SpreadSheet sheet = SpreadSheet.createFromFile(file);
			// Save to file 
			 File outputFile = new File("src/main/resources/com/github/Raouf16/Fichier_voeux_vide.ods");
			 sheet.saveAs(outputFile);
			 
		}catch(NullPointerException e){
			System.out.println("Fichier source introuvable");
		} 
		 
	}
}
