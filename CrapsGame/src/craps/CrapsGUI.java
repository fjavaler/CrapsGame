/********************************************************
 *  
 *  Project :  Craps Game
 *  File    :  CrapGUI.java
 *  Name    :  Frederick Javalera
 *  Date    :  Created: 3/18/2017 (Due: 3/13/2017)
 *
 *  Description : (Narrative description, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *    This code is the interface, controller, and model that allows the user
 *    to play a game of craps.
 *
 *    2) What data-structures are used.
 *    A JFrame was used.
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *	  lots of anonymous classes and actionEvents were used for when the user clicks on
 *	  the game's buttons.
 *
 *    4) What methods are implemented (optional).
 *    A Main method, an initialize method, and several helper classes.
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
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

/**
 * This class represents the model, view, and controller for 
 * a game of Craps.
 * 
 * @author Frederick Javalera
 */
public class CrapsGUI
{

	//fields
	private JFrame frmCrapsAGame;
	private JLabel lblDie;
	private JLabel lblDie2;
	private JLabel lblSum;
	private JLabel die1ImageLbl;
	private JLabel die2ImageLbl;
	private JLabel sumImageLbl;
	private JLabel shooterNameLbl = new JLabel();
	private JLabel winLoseLbl;
	private JLabel gameStatusTxt;
	private JButton btnComeOutRoll;
	private Die die1 = new Die();
	private Die die2 = new Die();
	private int sum = 0;
	private int point = 0;
	private int isPointRoll = 0;
	private int totalRolls = 0;
	private String name;
	private int totalGames = 0;
	private int totalWins = 0;
	// avg rolls per session
	private double avgNumRollsForShooter = 0;

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
		frmCrapsAGame.setBounds(100, 100, 800, 425);
		frmCrapsAGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrapsAGame.setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Noto Sans UI", Font.PLAIN, 14));
		frmCrapsAGame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSave = new JMenuItem("New Shooter");
		mntmSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// displays game stats
				displayStats();
				// name prompt appears and gets current user name
				namePromptAndUpdate();
				// resets values
				reset();
			}

			/****************************************************
			 * Method     : displayStats
			 *
			 * Purpose    : The displayStats method displays the current
			 * users stats: totalGames, totalWins, and avgNumRollsForShooter
			 *
			 * Parameters : None
			 *
			 * Returns    : This method does not return a value.
			 *
			 ****************************************************/
			private void displayStats()
			{
				JOptionPane.showMessageDialog(frmCrapsAGame,
						"Here are your stats for this session: " + "\nTotal Games: " + totalGames + "\nTotal Wins: "
								+ totalWins + "\nAverage Rolls Per Game: " + avgNumRollsForShooter,
						"Game Stats", JOptionPane.INFORMATION_MESSAGE);
			}

			/****************************************************
			 * Method     : reset
			 *
			 * Purpose    : the reset method resets all of the game's initial
			 * values and images to their default values and images.
			 *
			 * Parameters : None.
			 *
			 * Returns    : This method does not return a value.
			 *
			 ****************************************************/
			private void reset()
			{
				// reset init values
				sum = 0;
				point = 0;
				isPointRoll = 0;
				btnComeOutRoll.setText("Come Out Roll");
				winLoseLbl.setText("");
				gameStatusTxt.setText("");
				isPointRoll = 0;
				totalGames = 0;
				totalWins = 0;
				
				// reset die image labels
				die1ImageLbl.setText("");
				die2ImageLbl.setText("");
				sumImageLbl.setText("");
				die1ImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
				die2ImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
				sumImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
			}
		});
		mnFile.add(mntmSave);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		mnFile.add(mntmExit);

		JMenu mnGameStats = new JMenu("Game Stats");
		menuBar.add(mnGameStats);

		JMenuItem mntmTotalGames = new JMenuItem("Total Games");
		mntmTotalGames.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(frmCrapsAGame, "Total Number of Games: " + totalGames, "Total Games",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnGameStats.add(mntmTotalGames);

		JMenuItem mntmTotalWins = new JMenuItem("Total Wins");
		mntmTotalWins.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(frmCrapsAGame, "Total Wins: " + totalWins, "Total Wins",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnGameStats.add(mntmTotalWins);

		JMenuItem mntmAvgRollsgame = new JMenuItem("Avg Rolls/Game");
		mntmAvgRollsgame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(frmCrapsAGame,
						"Average Number of Rolls per Game: " + avgNumRollsForShooter, "Average Rolls",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnGameStats.add(mntmAvgRollsgame);

		JMenuItem mntmSummary = new JMenuItem("Summary");
		mntmSummary.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(frmCrapsAGame,
						"Here are your stats for this session: " + "\nTotal Games: " + totalGames + "\nTotal Wins: "
								+ totalWins + "\nAverage Rolls Per Game: " + avgNumRollsForShooter,
						"Summary", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JSeparator separator = new JSeparator();
		mnGameStats.add(separator);
		mnGameStats.add(mntmSummary);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmInstructions = new JMenuItem("Instructions");
		mntmInstructions.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(frmCrapsAGame,
						"Set up\n    Select File | New Shooter\n        Enter player's name\n\nPlay\n    Click the Come-out Roll button\n        "
								+ "Win if you roll 7 or 11\n        Lose if you roll 2, 3, or 12\n        Otherwise set point value and continue\n    "
								+ "Point roll\n        Win if you roll your point value\n        Lose if you roll7\n        Otherwise continue until you "
								+ "win or lose",
						"How To Play Craps", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmInstructions);

		JSeparator separator_2 = new JSeparator();
		mnHelp.add(separator_2);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AboutWindow.main(null);
			}
		});
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
		die1ImageLbl.setBackground(Color.WHITE);
		die1ImageLbl.setFont(new Font("Noto Sans UI", Font.BOLD, 50));
		die1ImageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		die1ImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
		die1ImageLbl.setBounds(50, 197, 60, 60);
		frmCrapsAGame.getContentPane().add(die1ImageLbl);

		die2ImageLbl = new JLabel("");
		die2ImageLbl.setFont(new Font("Noto Sans UI", Font.BOLD, 50));
		die2ImageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		die2ImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
		die2ImageLbl.setBounds(123, 197, 60, 60);
		frmCrapsAGame.getContentPane().add(die2ImageLbl);

		sumImageLbl = new JLabel("");
		sumImageLbl.setFont(new Font("Noto Sans UI", Font.BOLD, 50));
		sumImageLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sumImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
		sumImageLbl.setBounds(196, 197, 60, 60);
		frmCrapsAGame.getContentPane().add(sumImageLbl);

		namePromptAndUpdate();
		shooterNameLbl.setForeground(Color.BLUE);
		shooterNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		shooterNameLbl.setFont(new Font("Noto Sans UI", Font.BOLD, 54));
		shooterNameLbl.setBounds(336, 38, 362, 110);
		frmCrapsAGame.getContentPane().add(shooterNameLbl);

		JLabel lblGameStatus = new JLabel("Game Status:");
		lblGameStatus.setFont(new Font("Noto Sans UI", Font.PLAIN, 13));
		lblGameStatus.setBounds(50, 299, 89, 16);
		frmCrapsAGame.getContentPane().add(lblGameStatus);

		gameStatusTxt = new JLabel("");
		gameStatusTxt.setForeground(Color.RED);
		gameStatusTxt.setHorizontalAlignment(SwingConstants.CENTER);
		gameStatusTxt.setFont(new Font("Noto Sans UI", Font.PLAIN, 18));
		gameStatusTxt.setBackground(Color.WHITE);
		gameStatusTxt.setBounds(136, 293, 78, 24);
		frmCrapsAGame.getContentPane().add(gameStatusTxt);

		winLoseLbl = new JLabel("");
		winLoseLbl.setHorizontalAlignment(SwingConstants.CENTER);
		winLoseLbl.setForeground(Color.GREEN);
		winLoseLbl.setFont(new Font("Noto Sans UI", Font.BOLD, 70));
		winLoseLbl.setBounds(347, 212, 351, 137);
		frmCrapsAGame.getContentPane().add(winLoseLbl);

		btnComeOutRoll = new JButton("Come Out Roll");
		btnComeOutRoll.addActionListener(new ActionListener()
		{
			/****************************************************
			 * Method     : rollDie
			 *
			 * Purpose    : The rollDie method simulates the rolling of
			 * a die.
			 *
			 * Parameters : die         - the "die" object to be rolled
			 *
			 * Returns    : This method returns the simulated die's int
			 * value (1-6).
			 *
			 ****************************************************/
			private int rollDie(Die die)
			{
				die.roll();
				return die.getValue();
			}

			/****************************************************
			 * Method     : updateDieOnGUI
			 *
			 * Purpose    : This method updates the icon on the die from
			 * an image to the numbers rolled by the shooter on a die.
			 *
			 * Parameters : dieLabel           - the JLabel to be updated
			 *              dieValue           - the value rolled on the die
			 *
			 * Returns    : This method does not return a value.
			 *
			 ****************************************************/
			private void updateDieOnGUI(JLabel dieLabel, int dieValue)
			{
				dieLabel.setIcon(null);
				dieLabel.setText("" + dieValue);
			}

			/****************************************************
			 * Method     : actionPerformed
			 *
			 * Purpose    : Detects when the die roll button is clicked.
			 *
			 * Parameters : e               - actionEvent to be detected.
			 *
			 * Returns    : This method does not return a value.
			 *
			 ****************************************************/
			public void actionPerformed(ActionEvent e)
			{

				// roll 'em
				int die1Value = rollDie(die1);
				int die2Value = rollDie(die2);
				totalRolls++;
				if(btnComeOutRoll.getText().equals("Come Out Roll"))
				{
					totalGames++;
				}
				avgNumRollsForShooter = totalRolls/totalGames;
				
				// update die roll value appear on GUI
				updateDieOnGUI(die1ImageLbl, die1Value);
				updateDieOnGUI(die2ImageLbl, die2Value);

				// make sum of both rolls appear on GUI
				sum = die1Value + die2Value;
				updateDieOnGUI(sumImageLbl, sum);

				// logic: isPointRoll = 0 is false, 1 is true.
				switch (isPointRoll)
				{
					case 0:
					{
						if (sum == 7 || sum == 11)
						{
							win(btnComeOutRoll, winLoseLbl, gameStatusTxt, isPointRoll);
							prompt();
							break;
						}
						else if (sum == 2 || sum == 3 || sum == 12)
						{
							lose(btnComeOutRoll, winLoseLbl, gameStatusTxt, isPointRoll);
							prompt();
							break;
						}
						else
						{
							keepPlaying(btnComeOutRoll, winLoseLbl, gameStatusTxt, isPointRoll);
							isPointRoll = 1;
							break;
						}
					}
					case 1:
					{
						if (sum == point)
						{
							win(btnComeOutRoll, winLoseLbl, gameStatusTxt, isPointRoll);
							prompt();
							break;
						}
						else if (sum == 7)
						{
							lose(btnComeOutRoll, winLoseLbl, gameStatusTxt, isPointRoll);
							prompt();
							break;
						}
					}
				}
			}

			/****************************************************
			 * Method     : prompt
			 *
			 * Purpose    : The prompt method prompts the user asking if
			 * they'd like to play again. If yes, resets values. If cancel 
			 * pressed, re-prompts user every 5 seconds. If no, it asks if
			 * there is a new shooter who would like to play. If so, starts
			 * a new game and resets values for new user.
			 *
			 * Parameters : None
			 *
			 * Returns    : This method does not return a value.
			 *
			 ****************************************************/
			private void prompt()
			{
				int reply = JOptionPane.showConfirmDialog(frmCrapsAGame, "Would you like to play again?");
				if (reply == JOptionPane.YES_OPTION)
				{
					reset();
				}
				else if (reply == JOptionPane.CANCEL_OPTION)
				{
					try
					{
						while (true)
						{
							Thread.sleep(Integer.parseInt("5000"));
							prompt();
						}
					}
					catch (InterruptedException ex)
					{
						Thread.currentThread().interrupt();
					}
				}
				else if (reply == JOptionPane.NO_OPTION)
				{
					int response = JOptionPane.showConfirmDialog(frmCrapsAGame,
							"Would you like to play as a new shooter?");
					if (response == JOptionPane.YES_OPTION)
					{
						totalWins = 0;
						mntmSave.doClick();
					}
					else
					{
						displayStats();
					}
				}
			}

			/****************************************************
			 * Method     : displayStats
			 *
			 * Purpose    : The displayStats method displays the current users
			 * stats.
			 *
			 * Parameters : None.
			 *
			 * Returns    : This method does not return a value.
			 *
			 ****************************************************/
			private void displayStats()
			{
				JOptionPane.showMessageDialog(frmCrapsAGame,
						"Here are your stats for this session: " + "\nTotal Games: " + totalGames + "\nTotal Wins: "
								+ totalWins + "\nAverage Rolls Per Game: " + avgNumRollsForShooter,
						"Game Stats", JOptionPane.INFORMATION_MESSAGE);
			}

			/****************************************************
			 * Method     : reset
			 *
			 * Purpose    : the reset method resets all of the game's initial
			 * values and images to their default values and images.
			 *
			 * Parameters : None.
			 *
			 * Returns    : This method does not return a value.
			 *
			 ****************************************************/
			private void reset()
			{
				// reset init values
				sum = 0;
				point = 0;
				isPointRoll = 0;
				btnComeOutRoll.setText("Come Out Roll");
				winLoseLbl.setText("");
				gameStatusTxt.setText("");
				isPointRoll = 0;

				// reset die image labels
				die1ImageLbl.setText("");
				die2ImageLbl.setText("");
				sumImageLbl.setText("");
				die1ImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
				die2ImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
				sumImageLbl.setIcon(new ImageIcon(CrapsGUI.class.getResource("/questionMark.png")));
			}

			/****************************************************
			 * Method     : keepPlaying
			 *
			 * Purpose    : The keepPlayingPoint method is used when the player
			 * decides to keep playing and a point value is in play. This method
			 * does nothing when called.
			 *
			 * Parameters : btnComeOutRoll - The JButton whose text is modified 
			 * indicating a point roll.
			 *              winLoseLbl     - A label whose text is modified.
			 *              gameStatusTxt  - A label whose text is modified.
			 *              isPointRoll    - An int that acts as a boolean, 0
			 *              indicates false, 1 indicates true. Used later in a
			 *              switch.
			 *
			 * Returns    : This method does not return a value.
			 *
			 ****************************************************/
			private void keepPlaying(JButton btnComeOutRoll, JLabel winLoseLbl, JLabel gameStatusTxt, int isPointRoll)
			{
				point = sum;
				btnComeOutRoll.setText("Point Roll");
				winLoseLbl.setText("Point: " + point);
				winLoseLbl.setForeground(Color.DARK_GRAY);
				gameStatusTxt.setText("Continue");
				isPointRoll = 1;
			}

			/****************************************************
			 * Method     : lose
			 *
			 * Purpose    : The lose method changes all of the GUI components
			 * necessary to indicate that the player lost.
			 *
			 * Parameters : btnComeOutRoll - an array of integers
			 *              winLoseLbl     - A label whose text is modified.
			 *              gameStatusTxt  - A label whose text is modified.
			 *              isPointRoll    - An int that acts as a boolean, 0
			 *              indicates false, 1 indicates true. Used later in a
			 *              switch.
			 *
			 * Returns    : This method does not return a value.
			 *
			 ****************************************************/
			private void lose(JButton btnComeOutRoll, JLabel winLoseLbl, JLabel gameStatusTxt, int isPointRoll)
			{
				btnComeOutRoll.setText("Play again");
				winLoseLbl.setText("You Lose.");
				winLoseLbl.setForeground(Color.RED);
				gameStatusTxt.setText("Lost");
				isPointRoll = 0;
			}

			/****************************************************
			 * Method     : win
			 *
			 * Purpose    : The lose method changes all of the GUI components
			 * necessary to indicate that the player won.
			 *
			 * Parameters : btnComeOutRoll - an array of integers
			 *              winLoseLbl     - A label whose text is modified.
			 *              gameStatusTxt  - A label whose text is modified.
			 *              isPointRoll    - An int that acts as a boolean, 0
			 *              indicates false, 1 indicates true. Used later in a
			 *              switch.
			 *
			 * Returns    : This method does not return a value.
			 *
			 ****************************************************/
			private void win(JButton btnComeOutRoll, JLabel winLoseLbl, JLabel gameStatusTxt, int isPointRoll)
			{
				btnComeOutRoll.setText("Come Out Roll");
				winLoseLbl.setText("WINNER!");
				winLoseLbl.setForeground(Color.GREEN);
				gameStatusTxt.setText("Win");
				isPointRoll = 0;
				totalWins++;
			}
		});
		btnComeOutRoll.setFont(new Font("Noto Sans UI", Font.BOLD, 15));
		btnComeOutRoll.setBounds(445, 156, 150, 44);
		frmCrapsAGame.getContentPane().add(btnComeOutRoll);
	}

	/****************************************************
	 * Method     : namePromptAndUpdate
	 *
	 * Purpose    : The namePromptAndUpdate method prompts the user
	 * for their name and updates their name on the GUI.
	 *
	 * Parameters : None.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	private void namePromptAndUpdate()
	{
		name = JOptionPane.showInputDialog(frmCrapsAGame, "Please enter your name:", "Shooter's Name",
				JOptionPane.QUESTION_MESSAGE);
		if(name == null)
		{
			System.exit(0);
		}
		shooterNameLbl.setText(name);
		totalRolls = 0;
		avgNumRollsForShooter = 0;
	}
	
}
