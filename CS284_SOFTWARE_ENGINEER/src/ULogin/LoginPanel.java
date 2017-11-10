package ULogin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import MainProgram.MainProgram;

public class LoginPanel extends JPanel implements ActionListener {
	private JTextField userField;
	private JPasswordField  passwordField;
	private ImageIcon tuIcon;
	private JButton loginBtn;
	private boolean check1,check2;
    private CheckLogin cl;
    private JLabel wrongLabel ;
    
	public LoginPanel() {
		
		cl = new CheckLogin();
		check1 = true;
		check2 = true;
		
		JPanel userWrongPanel  = new JPanel();
		JPanel userAndPass = new JPanel();
		JPanel loginPanel = new JPanel();
		JPanel main = new JPanel();
		JPanel contentPane = new JPanel();
		
		tuIcon = new ImageIcon("tu.png");
		loginBtn = new JButton(new ImageIcon("logins.jpg"));
		loginBtn.setPreferredSize(new Dimension(100, 100));
		loginBtn.addActionListener(this);
		loginPanel.add(loginBtn);

		JLabel loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));

		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel(tuIcon));
       
		
		// username box
		userField = new JTextField(8);
		userField.setPreferredSize(new Dimension(200, 40));
		userField.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));
		userField.setBorder(new LineBorder(Color.lightGray, 2));
		userField.setText("Username");
		userField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (check1) {
					userField.setText("");
					check1 = false;
				} 
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		//password box
		passwordField = new JPasswordField(8);
		passwordField.setPreferredSize(new Dimension(200, 40));
		passwordField.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 18));
		passwordField.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		passwordField.setText("Password");
		passwordField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				if (check2) {
					passwordField.setText("");
					check2 = false;
				} 
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});

		loginBtn.addActionListener(this);
		GridLayout g = new GridLayout(2, 0);
		g.setVgap(9);

		userAndPass.setLayout(new BorderLayout());
		userAndPass.setLayout(g);
		userAndPass.add(userField);
		userAndPass.add(passwordField);
		userAndPass.setPreferredSize(new Dimension(180, 100));

		main.setLayout(new FlowLayout());
		main.add(userAndPass, FlowLayout.LEFT);
		main.add(loginPanel);

		wrongLabel = new JLabel("");

		userWrongPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		userWrongPanel.add(wrongLabel);
		userWrongPanel.setPreferredSize(new Dimension(30, 20));

		this.setLayout(new BorderLayout());
		this.add(contentPane, BorderLayout.NORTH);
		this.add(main);
		this.add(userWrongPanel,BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		MainProgram m = new MainProgram();
		if(cl.isUserNameAndPassWord(userField.getText(),passwordField.getText())) {
			loginBtn.setIcon(new ImageIcon("logout.jpg"));
			wrongLabel.setText("");
			m.getLoginFrame().dispose();
			m.getFillPointFrame().setVisible(true);
			
		}else {
			loginBtn.setIcon(new ImageIcon("logins.jpg"));
			wrongLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 10));
			wrongLabel.setForeground(Color.RED);
			wrongLabel.setText("Wrong username and password");
		}
		
	}

}
