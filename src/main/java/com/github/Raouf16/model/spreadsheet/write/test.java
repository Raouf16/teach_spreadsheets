package com.github.Raouf16.model.spreadsheet.write;


import java.io.File;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;
import org.odftoolkit.simple.style.StyleTypeDefinitions.CellBordersType;



public class test{
	
	public static void main(String[] args) throws Exception
	{
		// Load the sheet
		 File f = new File("src/main/resources/com/github/Raouf16/canevas/Lire_saisie_voeux.ods");
		 SpreadsheetDocument spreadSheet = SpreadsheetDocument.loadDocument(f);
		 Table sheet = spreadSheet.getSheetByName("DE1");
		 System.out.println(sheet.getCellByPosition("K4").getBorder(CellBordersType.TOP));
	}
}
