package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ULogin.CheckLogin;

public class loginTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIncorrectAccount() {
		//ใส่รหัสที่ผิดและพาสเวิรฺสที่ผิด  จะคืนค่า false
		CheckLogin login = new CheckLogin();
		String userName = "abcdef15";
		String password = "dsfsf4165";
		boolean check = false;
		check = login.isUserNameAndPassWord(userName, password);
		assertTrue("UserName and password Incorrect", check == false);
	}
	
	@Test
	public void testCorrectAccount() {
		//ใส่รหัสที่ถูกและพาสเวิร์สที่ถูก
		CheckLogin login = new CheckLogin();
		String userName = "user1";
		String password = "1234";
		boolean check = false;
		check = login.isUserNameAndPassWord(userName, password);
		assertTrue("UserName and password correct", check == true);
	}

}
