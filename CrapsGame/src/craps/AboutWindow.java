package craps;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class AboutWindow
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AboutWindow window = new AboutWindow();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AboutWindow()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setBounds(54, 0, 350, 100);
		logoLabel.setIcon(new ImageIcon(AboutWindow.class.getResource("/slccLogo.png")));
		frame.getContentPane().add(logoLabel);
		
		JLabel lblCsis = new JLabel("CSIS 1410: Object Oriented Programming");
		lblCsis.setHorizontalAlignment(SwingConstants.CENTER);
		lblCsis.setFont(new Font("Noto Sans UI", Font.BOLD, 15));
		lblCsis.setBounds(54, 112, 350, 20);
		frame.getContentPane().add(lblCsis);
		
		JLabel lblAssignment = new JLabel("Assignment: M4-A3 - GUI-based Craps");
		lblAssignment.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignment.setFont(new Font("Noto Sans UI", Font.PLAIN, 14));
		lblAssignment.setBounds(54, 142, 350, 16);
		frame.getContentPane().add(lblAssignment);
		
		JLabel lblCreatedByFred = new JLabel("Created by: Fred Javalera");
		lblCreatedByFred.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedByFred.setFont(new Font("Noto Sans UI", Font.ITALIC, 13));
		lblCreatedByFred.setBounds(135, 187, 200, 16);
		frame.getContentPane().add(lblCreatedByFred);
	}
}
