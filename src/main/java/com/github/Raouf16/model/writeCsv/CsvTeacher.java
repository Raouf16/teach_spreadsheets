package com.github.Raouf16.model.writeCsv;

import java.io.*;

import com.github.Raouf16.model.teacherUtils.Teacher;

/**
 * This class is able to write information about a teacher in a csv file which called test.txt
 * @author haya
 *
 */
public class CsvTeacher {

	public static void WriteTeacher (String fileName, Teacher t) throws Exception{
			FileWriter fichier = new FileWriter(fileName, true);
			String line="";
			
			line+= t.getFirstName();
			line+=",";
			line+= t.getLastName();
			line+=",";
			line+= t.getNumEn();
			line+=",";
			line+= t.getPostalCode();
			line+=",";
			line+= t.getCity();
			line+=",";
			line+= t.getStatus();
			line+=",";
			line+= t.getDauphineEmail();
			line+=",";
			line+= t.getPersonalEmail();
			line+=",";
			line+= t.getMobilePhone();
			line+=",";
			line+= t.getDauphinePhone();
			line+=",";
			line+= t.getOffice();
			
			fichier.write (line);
			fichier.close();
	}
	
	
	public static void main (String [] args) throws Exception{
		Teacher t= new Teacher();
		WriteTeacher("test.txt",t);
	}
}
