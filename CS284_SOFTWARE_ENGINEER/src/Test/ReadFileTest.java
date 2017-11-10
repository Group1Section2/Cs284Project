package Test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import UuploadFileAndFillScore.StudentFileMgr;

public class ReadFileTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadFileTrue() {
		StudentFileMgr s = new StudentFileMgr();
		boolean check = s.readFile(new File("classlist.csv"));
		assertTrue("File name true", check == true);
	}
	@Test
	public void testReadFileFalse() {
		StudentFileMgr s = new StudentFileMgr();
		boolean check = s.readFile(new File("classlist.txt"));
		assertTrue("File name false", check == false);
	}
	@Test
	public void testNameFileFalse() {
		StudentFileMgr s = new StudentFileMgr();
		boolean check = s.readFile(new File("sdsgsdg.csv"));
		assertTrue("File name false", check == false);
	}

}
