package com.github.Raouf16.model.utils.teacher;





import org.junit.Test;

import com.github.Raouf16.model.utils.teacher.Teacher;

public class TeacherTest {
	private static final String[] NULL = null;

	//we test if the constructor throws exception if the parameter of the constructor is null
	@Test(expected = NullPointerException.class)
	public void test_the_exception() throws Exception {
		Teacher t =new Teacher(NULL);
		
		
	}
	//if the test failed the error message is : java.lang.AssertionError: "Expected exception: java.lang.NullPointerException"
}