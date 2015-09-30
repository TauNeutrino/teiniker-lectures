package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CourseTest
{
	private Course course;
	
	@Before
	public void setup()
	{
		course = new Course(3, "Software Design", 2, 3, CourseType.INTEGRATED_COURSE, "WS2012/13");
		
		Lecturer teini = new Lecturer(7, "Egon", "Teiniker", "egon.teiniker@fhj.at");
		teini.addCourse(course);
		course.setLecturer(teini);
		
		Student s1 = new Student(100, "Bart", "Simpson", "bart.simpson@fhj.at");
		s1.addCourse(course);
		course.addStudent(s1);
		
		Student s2 = new Student(101, "Lisa", "Simpson", "lisa.simpson@fhj.at");
		s2.addCourse(course);
		course.addStudent(s2);
	}
	
	
	@Test
	public void testCourse()
	{
		Assert.assertNotNull(course);
		
		Assert.assertEquals(3, course.getId());
		Assert.assertEquals("Software Design", course.getTitle());
		Assert.assertEquals(2, course.getSws());
		Assert.assertEquals(3, course.getEcts());
		Assert.assertEquals(CourseType.INTEGRATED_COURSE, course.getType());
		Assert.assertEquals("WS2012/13", course.getSemester());
		
		Assert.assertNotNull(course.getLecturer());
		Assert.assertEquals(2, course.getStudents().size());
	}
	
	@Test
	public void testLecturer()
	{
		Lecturer l = course.getLecturer();
		
		Assert.assertEquals(7, l.getId());
		Assert.assertEquals("Egon", l.getFirstName());
		Assert.assertEquals("Teiniker", l.getLastName());
		Assert.assertEquals("egon.teiniker@fhj.at", l.getEmail());
		
		Assert.assertEquals("7,Egon,Teiniker,egon.teiniker@fhj.at", l.toString())
		;
		Assert.assertEquals("Software Design", l.getCourses().get(0).getTitle());
	}
	
	@Test
	public void testStudent1()
	{
		Student s = course.getStudents().get(0);
		Assert.assertNotNull(s);
		
		Assert.assertEquals("100,Bart,Simpson,bart.simpson@fhj.at", s.toString());
		
		Assert.assertEquals("Software Design", s.getCourses().get(0).getTitle());
	}

	@Test
	public void testStudent2()
	{
		Student s = course.getStudents().get(1);
		Assert.assertNotNull(s);
		
		Assert.assertEquals("101,Lisa,Simpson,lisa.simpson@fhj.at", s.toString());
		
		Assert.assertEquals("Software Design", s.getCourses().get(0).getTitle());
	}
}
