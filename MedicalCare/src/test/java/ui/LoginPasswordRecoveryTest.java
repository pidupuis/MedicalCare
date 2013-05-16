package ui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ui.loginframe.LoginFrame;

public class LoginPasswordRecoveryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		LoginFrame l =new LoginFrame();
		l.changeToPasswordRecovery();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
