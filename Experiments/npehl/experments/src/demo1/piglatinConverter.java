package demo1;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FontsandStuffTest extends JComponent
{
	private static drawingComponent dc;
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		dc = new drawingComponent();
		
		frame.add(dc);
	}
	public static class drawingComponent extends JComponent
	{
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			g2.setFont(new Font("serif", Font.BOLD, 42));
			
			g2.drawString("This is a test! :)", 40, 40);
			
			g2.setFont(new Font("Monospaced", Font.ITALIC, 21));
			
			g2.drawString("This is also a test;)", 40, 90);
			
		}
	}
}

