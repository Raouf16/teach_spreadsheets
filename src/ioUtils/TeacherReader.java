package ioUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


import teacherUtils.Teacher;


/***
 * 
 * @author Sonia ASSAM
 * Class that read a file of teacher's data
 *
 */
public class TeacherReader 
{
	
	
	@SuppressWarnings("resource")
	/***
	 * 
	 * @param fileName : name or path of the file
	 * @return list of the read teachers
	 * @throws FileNotFoundException
	 */
	public static ArrayList <Teacher> readTeacher(String fileName) throws FileNotFoundException
	{
		File file = new File(fileName);
		ArrayList <Teacher> teachers = new ArrayList<Teacher>();
		Scanner scn = new Scanner(new File(file.getAbsolutePath()));
		while (scn.hasNext()) teachers.add(new Teacher(scn.nextLine().split(",")));
		return teachers;
			
	}
	
	public static void main (String [] args)
	{
		try {
			ArrayList<Teacher> teachers = readTeacher("test.txt");
			for (Teacher tech : teachers) System.out.println(tech);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
