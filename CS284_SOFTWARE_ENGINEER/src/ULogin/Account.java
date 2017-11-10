package ULogin;

public class Account {
	private String userName,passWord;

	public Account(String userName,String passWord) {
		this.userName =userName;
		this.passWord= passWord;
	}
	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	
}
