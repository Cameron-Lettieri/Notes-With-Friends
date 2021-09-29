package demo1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginTest
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);
		
		panel.setLayout(null);
		
		JLabel label = new JLabel("Username");
		label.setBounds(10, 20, 80, 25);
		JLabel pass = new JLabel("Password");
		pass.setBounds(10, 65, 80, 25);
		
		panel.add(label);
		panel.add(pass);
		
		JTextField userText = new JTextField();
		userText.setBounds(75, 20, 165, 25);
		panel.add(userText);
		JTextField password = new JTextField();
		password.setBounds(75, 65, 165, 25);
		panel.add(password);
		
		frame.setVisible(true);
	}
}
