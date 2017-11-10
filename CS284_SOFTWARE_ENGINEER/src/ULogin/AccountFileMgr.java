package ULogin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AccountFileMgr {
	private ArrayList<Account> account;


	public AccountFileMgr() {
		account = new ArrayList<>();
      
        
	}
	public void readFile() {
		 try {
	        	String line;
	        	StringTokenizer stk ;
				BufferedReader bf = new BufferedReader(new FileReader(new File("Account.txt")));
				while (!(line =bf.readLine()).equals("***")) {
					stk =  new StringTokenizer(line," ");
					account.add(new Account(stk.nextToken(), stk.nextToken()));
				}
				bf.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public ArrayList<Account> getAccount() {
		return account;
	}
	public int  size() {
		return account.size();
	}
	public Account get(int index) {
		return account.get(index);
	}
}
