package com.github.Raouf16.model.utils.io.csv.read;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.github.Raouf16.model.main.Main;
import com.github.Raouf16.model.utils.preference.Preference;
import com.github.Raouf16.model.utils.teacher.Teacher;
import com.opencsv.CSVReader;

/***
 * This class will be used in case of searching a specific line in the csv files
 *
 */
public class CsvReader 
{
	/***
	 * This method is used to get teacher by it's numen
	 * @param fileName : Teacher's csv file path
	 * @param numen : The teacher's numen
	 * @return the teacher object if the numen exists, else null
	 * @throws Exception 
	 */
	public Teacher getTeacherByNumEn(String fileName, String numen) throws IOException, IllegalArgumentException
	{
		if (fileName == null) throw new IllegalArgumentException();
		for (Teacher t : getTeachers(fileName))
		{
			if (t!=null && t.getNumEn().equals(numen)) return t;
		}
		return null;
	}
	
	/***
	 * This method is used to read all the csv file input
	 * @param fileName : csv file path
	 * @return
	 * @throws IOException, NullPointerException
	 */
	public static ArrayList <Teacher> getTeachers(String filePath) throws IOException, NullPointerException
	{
		try(FileReader reader = new FileReader(filePath)){
		ArrayList <Teacher> teachers = new ArrayList <>();
		
		@SuppressWarnings("resource")
		CSVReader csv = new CSVReader(reader, ',');
		for (String [] teach : csv.readAll()) teachers.add(new Teacher(teach)) ;
		
		return teachers;
		}
	}
	
	
	/**
	 * This method can read the teacher with his numen in the csv file "filename" about a teacher.
	 * It returns the Teacher in which all information is stored.
	 * @param fileName
	 * @param Numen
	 * @throws IOException
	 */
	public static Teacher ReadTeacher (String fileName, String Num) throws IOException{
		Teacher t= new Teacher();
		try (CSVReader reader= new CSVReader(new FileReader(fileName))){
		
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
		}
	    return t;
	}
	
	/**
	 * This method can read all preference of a teacher.
	 * @param fileName
	 * @param t
	 * @return
	 * @throws IOException
	 */
	public Teacher ReadPreference (String fileName, Teacher t) throws IOException{
		String numEn=t.getNumEn();
		try(CSVReader reader2 = new CSVReader(new FileReader(fileName))){
	     String [] nextLine;
	     while ((nextLine = reader2.readNext()) != null) {
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
		}
		return t;
		
	}

}
