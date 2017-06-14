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
	/**
	 * This method can write a line in the csv file "filename" about a teacher.
	 * @param fileName
	 * @param t
	 * @throws Exception
	 */
	public void writeTeacher (String fileName, Teacher t) throws Exception{
			CSVWriter writer = new CSVWriter(new FileWriter(fileName, true));
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
	 * This method can read the teacher with his numen in the csv file "filename" about a teacher.
	 * It returns the Teacher in which all information is stored.
	 * @param fileName
	 * @param Numen
	 * @throws Exception
	 */
	public static Teacher ReadTeacher (String fileName, String Num) throws Exception{
		Teacher t= new Teacher();
		CSVReader reader = new CSVReader(new FileReader(fileName));
	     String [] nextLine;
	     while ((nextLine = reader.readNext()) != null) 
	     {
	        if (nextLine[2].compareTo(Num)==0)
	        {
	        	t.setFirstName(nextLine[0]);
	        	t.setLastName(nextLine[1]);
	        	t.setNumEn(nextLine[2]);
	        	t.setCivility(nextLine[3]);
	        	t.setAdress(nextLine[4]);
	        	t.setPostalCode(nextLine[5]);
	        	t.setCity(nextLine[6]);
	        	t.setStatus(nextLine[7]);
	        	t.setDauphineEmail(nextLine[8]);
	        	t.setPersonalEmail(nextLine[9]);
	        	t.setPersonalPhone(nextLine[10]);
	        	t.setMobilePhone(nextLine[11]);
	        	t.setDauphinePhone(nextLine[12]);
	        	t.setOffice(nextLine[13]);
	        	t.setDiscipline(nextLine[14]);
	        }
	     }
	     //System.out.println(t);
	    reader.close();
		return t;
	}
	/**
	 * This method can write all preferences of the teacher in "fileName".
	 * @param fileName
	 * @param t
	 * @throws Exception
	 */
	public void writePreference (String fileName, Teacher t) throws Exception{
		CSVWriter writer = new CSVWriter(new FileWriter(fileName, true));
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
			
			writer.writeNext(line);
		}
			writer.close();
	}
	/**
	 * This method can read all preference of a teacher.
	 * @param fileName
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public Teacher ReadPreference (String fileName, Teacher t) throws Exception{
		String numEn=t.getNumEn();
		CSVReader reader = new CSVReader(new FileReader(fileName));
	     String [] nextLine;
	     while ((nextLine = reader.readNext()) != null) {
	        if (nextLine[0].compareTo(numEn)==0){
	        	Preference p= new Preference();
	        	
	        	p.setYear(nextLine[1]);
	        	p.setSemester(nextLine[2]);
	        	p.setSubject(nextLine[3]);
	        	p.setChoiceCourse(nextLine[4]);
	        	p.setChoiceTD(nextLine[5]);
	        	p.setChoiceTP(nextLine[6]);
	        	p.setNbrTD(Integer.parseInt(nextLine[7]));
	        	p.setNbrYear(Integer.parseInt(nextLine[8]));
	        	t.addPreference(p);
	        	
	        }
	     }
	     System.out.println(t);
	    reader.close();
		return t;
	}
	
	public static void main (String [] args) throws Exception{
		Teacher t= new Teacher();
		t.setNumEn("1234");
		//WriteTeacher("test.txt",t);
		
		t = ReadTeacher("src/main/resources/com/github/Raouf16/CSVteacher","1234");
		System.out.println(t);
		
		//ReadPreference("src/main/resources/com/github/Raouf16/CSVpref",t);
	}
}
