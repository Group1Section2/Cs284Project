package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import UuploadFileAndFillScore.Calculate;

public class calculateTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOverScore() {
		Calculate c = new Calculate();
		c.setScore(80);
		assertTrue("Score is over", c.getScore()==50);
	}
	@Test
	public void testNegativeScore() {
		Calculate c = new Calculate();
		c.setScore(-45);
		assertTrue("Score is negative", c.getScore()==0);
	}
	@Test
	public void testTrueScore() {
		Calculate c = new Calculate();
		c.setScore(45);
		assertTrue("Score is true", c.getScore()==45);
	}
	@Test
	public void testOverCalculate() {
		Calculate c = new Calculate();
		c.setScore(80);
		System.out.println(c.getScore());
		System.out.println(c.calculateScore());
		assertTrue("Calculate is over", c.calculateScore()>=0&&c.calculateScore()<=100);
	}
	@Test
	public void testNegativeCalculate() {
		Calculate c = new Calculate();
		c.setScore(-45);
		assertTrue("Calculate is negative", c.calculateScore()>=0&&c.calculateScore()<=100);
	}
	@Test
	public void testTrueCalculate() {
		Calculate c = new Calculate();
		c.setScore(45);
		assertTrue("Calculate is over", c.calculateScore() == c.getScore()*2);
	}
}
