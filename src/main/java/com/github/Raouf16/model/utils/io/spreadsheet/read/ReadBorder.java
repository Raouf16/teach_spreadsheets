package com.github.Raouf16.model.utils.io.spreadsheet.read;

import java.io.IOException;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.style.StyleTypeDefinitions.CellBordersType;
import org.odftoolkit.simple.table.Table;

/***
 * This class is to verify if there is a Diagonal Border for a special choice 
 * @author Raouf HADDAD
 */
public class ReadBorder {
	/***
	 * This static method is to verify if there is a Course Choice for the course in param
	 * @param the spreadsheet, formation, semester, course
	 * @return true if there is a diagonal border, false if not
	 * @throws IOException
	 * @author Raouf HADDAD
	 */
	public boolean isCourseDiagonalBorder(SpreadsheetDocument spreadSheetReadingData, String formation, String sem, String course)
	{
		//There is no course choice for Apprentissage & LSO
		if (formation == null) return true;
		if(formation.equals("APPRENTISSAGE")){
			return true;
		}
		else if(formation.equals("LSO")){
			return true;
		}
		else{
			int semester;
			try {semester = Integer.parseInt(sem);}
			catch (NumberFormatException e) {return false;}
			String range1, range2;
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			if (semester % 2 != 0){
				range1 = "B";
				range2 = "J" ;
			}
			else{
				range1 = "P";
				range2 = "X";
			}
			int countRows = sheet.getRowCount();
			String subject;
			for (int i=4; i<countRows; i++)
			{
				subject = sheet.getCellByPosition(range1+i).getDisplayText();
				if (subject.equals(course)){
					/* There is a problem with ODFTookit, their function getBorder return NULL
					 * if the border doesn't exists, but if there is a border, It doesn't return
					 * the description but a NumberFormatException, so the catch fix it
					 */
					 try
					 {
						 sheet.getCellByPosition(range2+i).getBorder(CellBordersType.DIAGONALBLTR);
					 }catch(NullPointerException e){return false;}
					 catch(NumberFormatException z){return true;}
				}
			}
			return false;
		}
	}
		
	
	/***
	 * This static method is to verify if there is a TD Choice for the course in param
	 * @param the spreadsheet, formation, semester, course
	 * @return true if there is a diagonal border, false if not
	 * @throws IOException
	 * @author Raouf HADDAD
	 */
	public boolean isTdDiagonalBorder(SpreadsheetDocument spreadSheetReadingData, String formation, String sem, String course)
	{
		//There is only TD choices for Apprentissage so always return false (no border)
		if (formation == null) return true;
		if(formation.equals("APPRENTISSAGE")){
			return false;
		}
		//There is no TD choice for LSO, only groupe number choice
		else if(formation.equals("LSO")){
			return true;
		}
		int semester;
		try {semester = Integer.parseInt(sem);}
		catch (NumberFormatException e) {return false;}
		String range1, range2;
		Table sheet = spreadSheetReadingData.getSheetByName(formation);
		if (semester % 2 != 0){
			range1 = "B";
			range2 = "K" ;
		}
		else{
			range1 = "P";
			range2 = "Y";
		}
		int countRows = sheet.getRowCount();
		String subject;
		for (int i=4; i<countRows; i++)
		{
			subject = sheet.getCellByPosition(range1+i).getDisplayText();
			if (subject.equals(course)){
				/* There is a problem with ODFTookit, their function getBorder return NULL
				 * if the border doesn't exists, but if there is a border, It doesn't return
				 * the description but a NumberFormatException, so the catch fix it
				 */
				 try
				 {
					 sheet.getCellByPosition(range2+i).getBorder(CellBordersType.DIAGONALBLTR);
				 }catch(NullPointerException e){return false;}
				 catch(NumberFormatException z){return true;}
			}
		}
		return false;
	}
	
	/***
	 * This static method is to verify if there is a TP Choice for the course in param
	 * @param the spreadsheet, formation, semester, course
	 * @return true if there is a diagonal border, false if not
	 * @throws IOException
	 * @author Raouf HADDAD
	 */
	public boolean isTpDiagonalBorder(SpreadsheetDocument spreadSheetReadingData, String formation, String sem, String course)
	{
		//There is no TP choice for Apprentissage & LSO
		if (formation == null) return true;
		if(formation.equals("APPRENTISSAGE")){
			return true;
		}
		else if(formation.equals("LSO")){
			return true;
		}
		else{
			int semester;
			try {semester = Integer.parseInt(sem);}
			catch (NumberFormatException e) {return false;}
			String range1, range2;
			Table sheet = spreadSheetReadingData.getSheetByName(formation);
			if (semester % 2 != 0){
				range1 = "B";
				range2 = "L" ;
			}
			else{
				range1 = "P";
				range2 = "Z";
			}
			int countRows = sheet.getRowCount();
			String subject;
			for (int i=4; i<countRows; i++)
			{
				subject = sheet.getCellByPosition(range1+i).getDisplayText();
				if (subject.equals(course)){
					/* There is a problem with ODFTookit, their function getBorder return NULL
					 * if the border doesn't exists, but if there is a border, It doesn't return
					 * the description but a NumberFormatException, so the catch fix it
					 */
					 try
					 {
						 sheet.getCellByPosition(range2+i).getBorder(CellBordersType.DIAGONALBLTR);
					 }catch(NullPointerException e){return false;}
					 catch(NumberFormatException z){return true;}
				}
			}
			return false;
		}
		
	}
}
