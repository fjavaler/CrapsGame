/********************************************************
 * TODO:
 *  Project :  <Name of project|assignment>
 *  File    :  <Name of source code file>
 *  Name    :  <Name of programmer>
 *  Date    :  <Date created (project due date)>
 *
 *  Description : (Narrative desciption, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *
 *    2) What data-structures are used.
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *
 *    4) What methods are implemented (optional).
 *
 *  Changes :  <Description|date of modifications>
 *
 ********************************************************/
package craps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;

/**
 * 
 * @author Frederick Javalera
 */
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
		frmCrapsAGame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmCrapsAGame.setBackground(Color.WHITE);
		frmCrapsAGame.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frmCrapsAGame.setTitle("Craps - A Game of Chance and Skill!");
		frmCrapsAGame.setBounds(100, 100, 750, 400);
		frmCrapsAGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrapsAGame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Noto Sans UI", Font.PLAIN, 14));
		frmCrapsAGame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("New Shooter");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnGameStats = new JMenu("Game Stats");
		menuBar.add(mnGameStats);
		
		JMenuItem mntmTotalGames = new JMenuItem("Total Games");
		mnGameStats.add(mntmTotalGames);
		
		JMenuItem mntmTotalWins = new JMenuItem("Total Wins");
		mnGameStats.add(mntmTotalWins);
		
		JMenuItem mntmAvgRollsgame = new JMenuItem("Avg Rolls/Game");
		mnGameStats.add(mntmAvgRollsgame);
		
		JMenuItem mntmSummary = new JMenuItem("Summary");
		mnGameStats.add(mntmSummary);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmInstructions = new JMenuItem("Instructions");
		mnHelp.add(mntmInstructions);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		frmCrapsAGame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CrapsGUI.class.getResource("/dice.png")));
		lblNewLabel.setBounds(6, 6, 240, 142);
		frmCrapsAGame.getContentPane().add(lblNewLabel);
		
		JLabel lblDie = new JLabel("Die 1");
		lblDie.setFont(new Font("Noto Sans UI", Font.BOLD, 15));
		lblDie.setBounds(63, 169, 61, 16);
		frmCrapsAGame.getContentPane().add(lblDie);
		
		JLabel lblDie_1 = new JLabel("Die 2");
		lblDie_1.setFont(new Font("Noto Sans UI", Font.BOLD, 15));
		lblDie_1.setBounds(136, 169, 61, 16);
		frmCrapsAGame.getContentPane().add(lblDie_1);
		
		JLabel lblSum = new JLabel("Sum");
		lblSum.setFont(new Font("Noto Sans UI", Font.BOLD, 15));
		lblSum.setBounds(209, 169, 61, 16);
		frmCrapsAGame.getContentPane().add(lblSum);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
		label.setBounds(50, 197, 60, 60);
		frmCrapsAGame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
		label_1.setBounds(123, 197, 60, 60);
		frmCrapsAGame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
		label_2.setBounds(196, 197, 60, 60);
		frmCrapsAGame.getContentPane().add(label_2);
		
		String name = JOptionPane.showInputDialog(frmCrapsAGame, "Please enter your name:",
				"Shooter's Name", JOptionPane.QUESTION_MESSAGE);
		
		JLabel lblNewLabel_1 = new JLabel(name);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Noto Sans UI", Font.BOLD, 54));
		lblNewLabel_1.setBounds(336, 38, 362, 110);
		frmCrapsAGame.getContentPane().add(lblNewLabel_1);
	}
}
