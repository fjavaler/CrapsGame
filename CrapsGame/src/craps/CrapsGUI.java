/********************************************************
 * TODO:
 *  Project :  <Name of project|assignment>
 *  File    :  <Name of source code file>
 *  Name    :  <Name of programmer>
 *  Date    :  <Date created (project due date)>
 *
 *  Description : (Narrative description, not code)
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
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Frederick Javalera
 */
public class CrapsGUI
{

	private Craps craps = new Craps();
	private JFrame frmCrapsAGame;
	private JLabel lblDie;
	private JLabel lblDie2;
	private JLabel lblSum;
	private JLabel die1ImageLbl;
	private JLabel die2ImageLbl;
	private JLabel sumImageLbl;
	private JLabel shooterNameLbl;
	private JLabel gameStatusTxt;
	private JButton btnComeOutRoll;

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
		frmCrapsAGame.getContentPane().setFont(new Font("Noto Sans UI", Font.PLAIN, 15));
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

		lblDie = new JLabel("Die 1");
		lblDie.setFont(new Font("Noto Sans UI", Font.BOLD, 15));
		lblDie.setBounds(63, 169, 61, 16);
		frmCrapsAGame.getContentPane().add(lblDie);

		lblDie2 = new JLabel("Die 2");
		lblDie2.setFont(new Font("Noto Sans UI", Font.BOLD, 15));
		lblDie2.setBounds(136, 169, 61, 16);
		frmCrapsAGame.getContentPane().add(lblDie2);

		lblSum = new JLabel("Sum");
		lblSum.setFont(new Font("Noto Sans UI", Font.BOLD, 15));
		lblSum.setBounds(209, 169, 61, 16);
		frmCrapsAGame.getContentPane().add(lblSum);

		die1ImageLbl = new JLabel("");
		die1ImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
		die1ImageLbl.setBounds(50, 197, 60, 60);
		frmCrapsAGame.getContentPane().add(die1ImageLbl);

		die2ImageLbl = new JLabel("");
		die2ImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
		die2ImageLbl.setBounds(123, 197, 60, 60);
		frmCrapsAGame.getContentPane().add(die2ImageLbl);

		sumImageLbl = new JLabel("");
		sumImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
		sumImageLbl.setBounds(196, 197, 60, 60);
		frmCrapsAGame.getContentPane().add(sumImageLbl);

		// DO NOT DELETE - TEMPORARILY COMMENTED OUT
		// String name = JOptionPane.showInputDialog(frmCrapsAGame, "Please
		// enter your name:",
		// "Shooter's Name", JOptionPane.QUESTION_MESSAGE);
		//
		// JLabel lblNewLabel_1 = new JLabel(name);
		shooterNameLbl = new JLabel("Shooter"); // temp
		shooterNameLbl.setForeground(Color.BLUE);
		shooterNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		shooterNameLbl.setFont(new Font("Noto Sans UI", Font.BOLD, 54));
		shooterNameLbl.setBounds(336, 38, 362, 110);
		frmCrapsAGame.getContentPane().add(shooterNameLbl);

		btnComeOutRoll = new JButton("Come Out Roll");
		btnComeOutRoll.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				craps.play();
			}
		});
		btnComeOutRoll.setFont(new Font("Noto Sans UI", Font.BOLD, 15));
		btnComeOutRoll.setBounds(445, 156, 150, 44);
		frmCrapsAGame.getContentPane().add(btnComeOutRoll);

		JLabel lblGameStatus = new JLabel("Game Status:");
		lblGameStatus.setFont(new Font("Noto Sans UI", Font.PLAIN, 13));
		lblGameStatus.setBounds(50, 299, 89, 16);
		frmCrapsAGame.getContentPane().add(lblGameStatus);

		gameStatusTxt = new JLabel("Continue");
		gameStatusTxt.setForeground(Color.RED);
		gameStatusTxt.setHorizontalAlignment(SwingConstants.CENTER);
		gameStatusTxt.setFont(new Font("Noto Sans UI", Font.PLAIN, 18));
		gameStatusTxt.setBackground(Color.WHITE);
		gameStatusTxt.setBounds(136, 293, 78, 24);
		frmCrapsAGame.getContentPane().add(gameStatusTxt);
	}

	public JLabel getLblDie()
	{
		return lblDie;
	}

	public void setLblDie(JLabel lblDie)
	{
		this.lblDie = lblDie;
	}

	public JLabel getLblDie2()
	{
		return lblDie2;
	}

	public void setLblDie2(JLabel lblDie2)
	{
		this.lblDie2 = lblDie2;
	}

	public JLabel getLblSum()
	{
		return lblSum;
	}

	public void setLblSum(JLabel lblSum)
	{
		this.lblSum = lblSum;
	}

	public JLabel getDie1ImageLbl()
	{
		return die1ImageLbl;
	}

	public void setDie1ImageLbl(JLabel die1ImageLbl)
	{
		this.die1ImageLbl = die1ImageLbl;
	}

	public JLabel getDie2ImageLbl()
	{
		return die2ImageLbl;
	}

	public void setDie2ImageLbl(JLabel die2ImageLbl)
	{
		this.die2ImageLbl = die2ImageLbl;
	}

	public JLabel getSumImageLbl()
	{
		return sumImageLbl;
	}

	public void setSumImageLbl(JLabel sumImageLbl)
	{
		this.sumImageLbl = sumImageLbl;
	}

	public JLabel getShooterNameLbl()
	{
		return shooterNameLbl;
	}

	public void setShooterNameLbl(JLabel shooterNameLbl)
	{
		this.shooterNameLbl = shooterNameLbl;
	}

	public JButton getBtnComeOutRoll()
	{
		return btnComeOutRoll;
	}

	public void setBtnComeOutRoll(JButton btnComeOutRoll)
	{
		this.btnComeOutRoll = btnComeOutRoll;
	}

	public JLabel getGameStatusTxt()
	{
		return gameStatusTxt;
	}

	public void setGameStatusTxt(JLabel gameStatusTxt)
	{
		this.gameStatusTxt = gameStatusTxt;
	}

	public void setFrmCrapsAGame(JFrame frmCrapsAGame)
	{
		this.frmCrapsAGame = frmCrapsAGame;
	}

	public JFrame getFrmCrapsAGame()
	{
		return frmCrapsAGame;
	}
	
}
