package demo1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
public class Counter extends JFrame implements ActionListener
{
	private JButton button;
	private int count;
	public static void main(String[] args)
	{
		Counter countMe = new Counter();
	}
	public Counter()
	{
		count = 0;
		
		button = new JButton();
		button.setBounds(200, 100, 100, 50);
		button.addActionListener(this);
		button.setText("Count!");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 500);
		this.setVisible(true);
		this.add(button);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		count++;
		System.out.println(count);
	}
}
