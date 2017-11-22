package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Sprint2.ScoreManager;

public class setScore1Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setScoreTest1() {
		ScoreManager s = new ScoreManager();
		double test = 90;
		double check = s.setStandar(test);
		assertTrue("SetScore is not true", check == test);
	}
	@Test
	public void setScoreTest2() {
		ScoreManager s = new ScoreManager();
		double test = -5;
		double check = s.setStandar(test);
		assertTrue("SetScore is not true", check >=0);
	}
	@Test
	public void saveScore1() {
		ScoreManager s = new ScoreManager();
		boolean b = s.saveScore(true);
		assertTrue("Can't save score ", b == true);
	}
	@Test
	public void saveScore2() {
		ScoreManager s = new ScoreManager();
		boolean b = s.saveScore(false);
		assertTrue("Can't save score ", b == false);
	}
	@Test
	public void calculateMean() {
		ScoreManager s = new ScoreManager();
		s.calculateMean(true);
		assertTrue("Can't calculateMean", s.getMean()>=0 && s.getMean()<=100);
	}
	@Test
	public void studentGrade1() {
		ScoreManager s = new ScoreManager();
		char a = s.studentGrade(0);
		assertTrue("student grade is not true ", a == 'F');
	}
	@Test
	public void studentGrade2() {
		ScoreManager s = new ScoreManager();
		char a = s.studentGrade(100);
		assertTrue("student grade is not true ", a == 'A');
	}
	@Test
	public void sd() {//waiting
		ScoreManager s = new ScoreManager();
		assertTrue("Can't save score ", true);
	}
}
