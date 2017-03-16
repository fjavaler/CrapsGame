/*
 * TODO: documentation
 */
package craps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JLabel;

public class CrapsGUI
{

	private JFrame frmCrapsAGame;

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
					CrapsGUI window = new CrapsGUI();
					window.frmCrapsAGame.setVisible(true);
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
	public CrapsGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmCrapsAGame = new JFrame();
		frmCrapsAGame.setTitle("Craps - A Game of Chance and Skill!");
		frmCrapsAGame.setBounds(100, 100, 750, 400);
		frmCrapsAGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Noto Sans UI", Font.PLAIN, 14));
		frmCrapsAGame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnGameStats = new JMenu("Game Stats");
		menuBar.add(mnGameStats);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		frmCrapsAGame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(18, 6, 223, 129);
		frmCrapsAGame.getContentPane().add(lblNewLabel);
	}
}
