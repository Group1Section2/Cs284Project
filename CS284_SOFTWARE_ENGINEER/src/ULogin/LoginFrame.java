package ULogin;
import javax.swing.JFrame;
import javax.swing.JMenuBar;


public class LoginFrame extends JFrame {
	private JMenuBar menuBar;
	private LoginPanel inter;

	public LoginFrame() {
		menuBar = new JMenuBar();
		inter = new LoginPanel();

		this.setJMenuBar(menuBar);

		this.setTitle("Log in");
		this.add(inter);
		this.setResizable(false);
	
		this.pack();

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}



}
