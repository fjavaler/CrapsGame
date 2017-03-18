package craps;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

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
		logoLabel.setBounds(54, 0, 340, 100);
		logoLabel.setIcon(new ImageIcon(AboutWindow.class.getResource("/slccLogo.png")));
		frame.getContentPane().add(logoLabel);
		
		JLabel txtLabel = new JLabel("");
		txtLabel.setBackground(Color.WHITE);
		txtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		txtLabel.setBounds(8, 106, 434, 116);
		frame.getContentPane().add(txtLabel);
	}
}
