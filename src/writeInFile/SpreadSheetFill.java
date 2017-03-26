/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 2008 jOpenDocument, by ILM Informatique. All rights reserved.
 * 
 * The contents of this file are subject to the terms of the GNU General Public License Version 3
 * only ("GPL"). You may not use this file except in compliance with the License. You can obtain a
 * copy of the License at http://www.gnu.org/licenses/gpl-3.0.html See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each file.
 */

package writeInFile;

import java.io.File;


import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import teacherUtils.Teacher;

public class SpreadSheetFill {
	public void GenerateFS(Teacher t){
		
		try {
            // Load the file.
            File file = new File("./Fservice.ods");
            final Sheet sheet = SpreadSheet.createFromFile(file).getSheet("Feuille1");
            // Change date.  
            
           
            //sheet.getCellAt("I10").setValue(new Date());
            // Change strings.
            //sheet.setValueAt("Filling test", 0, 0);
            sheet.getCellAt("A3").setValue(t.CIV);
            sheet.getCellAt("B3").setValue(t.getFirstName());
            sheet.getCellAt("C3").setValue(t.getLastName());
            sheet.getCellAt("B4").setValue(t.getStatus());
            
            // Save to file and open it.
            File outputFile = new File("test.ods");
            OOUtils.open(sheet.getSpreadSheet().saveAs(outputFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    public static void main(String[] args) throws Exception {
    	SpreadSheetFill s= new SpreadSheetFill();
    	Teacher t=new Teacher(args);
    	s.GenerateFS(t);
        /*try {
            // Load the file.
            File file = new File("./Fservice.ods");
            final Sheet sheet = SpreadSheet.createFromFile(file).getSheet("Feuille1");
            // Change date.  
            //sheet.setRowCount(30);
           
            //sheet.getCellAt("I10").setValue(new Date());
            // Change strings.
            //sheet.setValueAt("Filling test", 0, 0);
            sheet.getCellAt("B27").setValue("On site support");
            // Change number.
            //sheet.getCellAt("F24").setValue(3);
            // Or better yet use a named range
            // (relative to the first cell of the range, wherever it might be).
            //sheet.getSpreadSheet().getTableModel("Products").setValueAt(1, 5, 4);
            // Save to file and open it.
            File outputFile = new File("test.ods");
            OOUtils.open(sheet.getSpreadSheet().saveAs(outputFile));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}