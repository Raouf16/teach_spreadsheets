package com.github.Raouf16.model.utils.io.csv.write;

import java.io.*;

import com.github.Raouf16.model.utils.preference.*;
import com.github.Raouf16.model.utils.teacher.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * This class is able to write information about a teacher and preference in a csv file which called test.txt
 * @author haya
 *
 */
public class CsvWriter {
	private CSVWriter writer;
	private CSVWriter writer2;
	private FileWriter writer3;

	/**
	 * This method can write a line in the csv file "filename" about a teacher.
	 * @param fileName
	 * @param t
	 * @throws IOException 
	 * @throws Exception
	 */
	public void writeTeacher (String fileName, Teacher t) throws IOException {
			writer3 = new FileWriter(fileName, true);
			writer = new CSVWriter(writer3);
			String [] line=new String[15];
			
			line[0] = t.getFirstName();
			line[1] = t.getLastName();
			line[2] = t.getNumEn();
			line[3] = t.getCivility();
			line[4] = t.getAdress();
			line[5] = t.getPostalCode();
			line[6] = t.getCity();
			line[7] = t.getStatus();
			line[8] = t.getDauphineEmail();
			line[9] = t.getPersonalEmail();
			line[10] = t.getPersonalPhone();
			line[11] = t.getMobilePhone();
			line[12] = t.getDauphinePhone();
			line[13] = t.getOffice();
			line[14] = t.getDiscipline();
			
			writer.writeNext(line);
		     
			writer.close();
	}
	
	/**
	 * This method can write all preferences of the teacher in "fileName".
	 * @param fileName
	 * @param t
	 * @throws IOException
	 */
	public void writePreference (String fileName, Teacher t) throws IOException{
		try(FileWriter writer4 = new FileWriter(fileName, true)){
			writer2 = new CSVWriter(writer4);
			Preference p;
			String [] line=new String[9];
			for (int i=0; i<t.getPreferences().size();i++){
				p=t.getPreferences().get(i);
				
				line[0]= "\n"+t.getNumEn();
				line[1]= p.getYear();
				line[2]= p.getSemester();
				line[3]= p.getSubject();
				line[4]=p.getChoiceCourse();
				line[5]= p.getChoiceTD();
				line[6]= p.getChoiceTP();
				line[7]= Integer.toString(p.getNbrTD());
				line[8]= Integer.toString(p.getNbrYear());
				
				writer2.writeNext(line);
			}
		}
	}
	
}
