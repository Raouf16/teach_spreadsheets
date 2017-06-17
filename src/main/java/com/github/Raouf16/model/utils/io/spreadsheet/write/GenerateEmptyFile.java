package com.github.Raouf16.model.utils.io.spreadsheet.write;

import java.io.File;

import org.odftoolkit.simple.SpreadsheetDocument;

import com.github.Raouf16.model.main.Main;

/**
 * This class generate an empty spreadsheet of the teacher preferences ODS
 * @author Raouf HADDAD
 */
public class GenerateEmptyFile {
	
	private SpreadsheetDocument spreadSheet;

	public void generate() throws Exception {

		try{
			// Load the file.
			File file = Main.fileReadingData ;
			spreadSheet = SpreadsheetDocument.loadDocument(file);
			// Save to file 
			 File outputFile = new File(Main.outputsFolderPath+"excel/"+"Fichier_Saisie_Voeux_Vide.ods");
			 spreadSheet.save(outputFile);
			 
		}catch(NullPointerException e){
			System.out.println("Fichier source introuvable "+e);
		} 
		 
	}
}
