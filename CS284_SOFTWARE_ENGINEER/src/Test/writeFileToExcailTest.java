package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Sprint2.writeFileToExcail;
import UuploadFileAndFillScore.StudentFileMgr;

public class writeFileToExcailTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readDataBaseTest() {
		writeFileToExcail w = new writeFileToExcail();
		StudentFileMgr mgr = new StudentFileMgr();
		boolean check = w.readDataBase(mgr);
		assertTrue("Can't read DataBase", check == true);
	}
	@Test
	public void writeFileBaseTest1() {
		writeFileToExcail w = new writeFileToExcail();
		String test = "exam";
		boolean check = w.writeFile(test);
		assertTrue("Can't read DataBase", check == true);
	}
	public void writeFileBaseTest2() {
		writeFileToExcail w = new writeFileToExcail();
		String test = "fszdg";
		boolean check = w.writeFile(test);
		assertTrue("Can't read DataBase", check == false);
	}
}
