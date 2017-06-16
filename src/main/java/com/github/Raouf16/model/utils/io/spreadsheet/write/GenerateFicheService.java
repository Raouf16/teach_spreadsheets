package com.github.Raouf16.model.utils.io.spreadsheet.write;

import java.io.File;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.io.pdf.GeneratePDF;
import com.github.Raouf16.model.utils.teacher.*;

/**
 * This class is to generate the "Fiche de service"
 * @author Raouf HADDAD
 */
public class GenerateFicheService {
	
	private SpreadsheetDocument spreadSheet;
	private SpreadsheetDocument spreadSheet2;

	public void generateEmptyFS(Teacher t) throws Exception{
			
		try{
            spreadSheet = SpreadsheetDocument.loadDocument(Main.fileFicheService);
		 	final Table sheet = spreadSheet.getSheetByName("FService");
			 
	        
	        // Fill the Sheet
		 	
	        if(t.getFirstName() != null) sheet.getCellByPosition("H6").setDisplayText(t.getFirstName());
	        if(t.getLastName() != null) sheet.getCellByPosition("E6").setDisplayText(t.getLastName());
	        if(t.getStatus() != null) sheet.getCellByPosition("C10").setDisplayText(t.getStatus());
	        if(t.getMobilePhone() != null) sheet.getCellByPosition("E13").setDisplayText(t.getMobilePhone());
	        
	        
            // Save
	        String newFileName = t.getFirstName()+"_"+t.getLastName()+"_FicheServiceVide.ods";
            File outputFile = new File(Main.outputsFolderPath+"excel/"+newFileName);
            spreadSheet.save(outputFile);
            
            // Convert as PDF
            GeneratePDF.generateEmptyFS(t);
            	}catch(NullPointerException e){
			System.out.println("Fichier source introuvable"+e);
		} 
	}
	
	public void generateFullFS(Teacher t) throws Exception
	{
		try{
			spreadSheet2 = SpreadsheetDocument.loadDocument(Main.fileFicheService);
		 	final Table sheet = spreadSheet2.getSheetByName("FService");
		 
	        
	        // Fill the Sheet
		 	System.out.println("MAIL : "+t.getDauphineEmail()+" /");
	        if(t.getCivility() != null) sheet.getCellByPosition("C6").setDisplayText(t.getCivility());
	        if(t.getFirstName() != null) sheet.getCellByPosition("H6").setDisplayText(t.getFirstName());
	        if(t.getLastName() != null) sheet.getCellByPosition("E6").setDisplayText(t.getLastName());
	        if(t.getStatus() != null) sheet.getCellByPosition("C10").setDisplayText(t.getStatus());
	        if(t.getMobilePhone() != null) sheet.getCellByPosition("E13").setDisplayText(t.getMobilePhone());
	        if(t.getOffice() != null) sheet.getCellByPosition("F18").setDisplayText(t.getOffice());
	        if(t.getStatus() != null) sheet.getCellByPosition("C18").setDisplayText(t.getStatus());
	        if(t.getDauphinePhone() != null) sheet.getCellByPosition("H18").setDisplayText(t.getDauphinePhone());
	        if(t.getDiscipline() != null) sheet.getCellByPosition("F10").setDisplayText(t.getDiscipline());
	        
	        // Save 
	        String newFileName = t.getFirstName()+"_"+t.getLastName()+"_FicheServiceRemplie.ods";
	        File outputFile = new File(Main.outputsFolderPath+"excel/"+newFileName);
	        spreadSheet2.save(outputFile);
	        
	        // Convert as PDF
	        GeneratePDF.generateFullFS(t);
		}catch(NullPointerException e){
			System.out.println("Fichier source introuvable"+e);
		} 
	}

}