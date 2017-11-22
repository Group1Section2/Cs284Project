package Test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Sprint2.emailManager;
import Sprint2.studentGrade;

public class emailTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readEmailTest() {
		emailManager e = new emailManager();
		boolean b = e.readEmail(new File("email.txt"));
		assertTrue("can't read email", b == true);
	}
	@Test
	public void GradesentTest() {
		emailManager e = new emailManager();
		char grade = e.Gradesent(e.get(0));
		assertTrue("can't read email", grade != 0);
	}

}
