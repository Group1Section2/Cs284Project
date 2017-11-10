package ULogin;
public class CheckLogin {
	private AccountFileMgr acm;

	public CheckLogin() {
		acm = new AccountFileMgr();
		acm.readFile();
	}

	public boolean isUserNameAndPassWord(String userName, String password) {
		boolean check = false;
		for (int i = 0; i < acm.size(); i++) {
			if ((userName.equals(acm.get(i).getUserName()) && password.equals(acm.get(i).getPassWord()))) {
				check = true;
			}
		}
		return check;
	}


}
