package com.github.Raouf16.model.spreadsheet.write;

import java.io.File;

import org.odftoolkit.simple.SpreadsheetDocument;

import com.github.Raouf16.model.main.Main;

/**
 * This class generate an empty spreadsheet of the teacher preferences ODS
 * @author Raouf HADDAD
 */
public class GenerateEmptyFile {
	
	public static void generate() throws Exception {

		try{
			// Load the file.
			File file = Main.fileReadingData ;
			// Open the file
			final SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(file);
			// Save to file 
			 File outputFile = Main.emptyFileChoice ;
			 spreadSheet.save(outputFile);
			 
		}catch(NullPointerException e){
			System.out.println("Fichier source introuvable");
		} 
		 
	}
}
