package com.github.Raouf16.model.spreadsheet.write;

import java.io.File;

import org.odftoolkit.simple.SpreadsheetDocument;

/**
 * This class generate an empty spreadsheet of the teacher preferences ODS
 * @author Raouf HADDAD
 */
public class GenerateEmptyFile {
	
	public static void generate() throws Exception {

		try{
			// Load the file.
			File file = new File("src/main/resources/com/github/Raouf16/Lire_saisie_voeux.ods");
			// Open the file
			final SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(file);
			// Save to file 
			 File outputFile = new File("src/main/resources/com/github/Raouf16/Fichier_voeux_vide.ods");
			 spreadSheet.save(outputFile);
			 
		}catch(NullPointerException e){
			System.out.println("Fichier source introuvable");
		} 
		 
	}
}
