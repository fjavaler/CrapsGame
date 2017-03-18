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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Frederick Javalera
 */
public class CrapsGUI
{
	
	private JFrame frmCrapsAGame;
	private JLabel lblDie;
	private JLabel lblDie2;
	private JLabel lblSum;
	private JLabel die1ImageLbl;
	private JLabel die2ImageLbl;
	private JLabel sumImageLbl;
	private JLabel shooterNameLbl;
	private JLabel winLoseLbl;
	private JLabel gameStatusTxt;
	private JButton btnComeOutRoll;
	private Die die1 = new Die();
	private Die die2 = new Die();
	private int sum = 0;
	private int point = 0;
	private int isPointRoll = 0;
	private int numRolls = 0;
	private ArrayList<Integer> rolls = new ArrayList<Integer>();
	private String name;
	private int totalGames = 1;
	private int totalWins = 0;

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
		mntmSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Game stats
				displayStats();
				// name prompt
				namePromptAndUpdate();
				// reset rolls
				rolls = new ArrayList<Integer>();
				// reset game
				reset();
			}

			private void displayStats()
			{
				JOptionPane.showMessageDialog(frmCrapsAGame,
						"Here are your stats for this session: " + "\nTotal Games: " + totalGames + "\nTotal Wins: "
								+ totalWins + "\nAverage Rolls Per Game: " + numRolls / totalGames,
						"Game Stats", JOptionPane.INFORMATION_MESSAGE);
			}

			private void reset()
			{
				// reset init values
				sum = 0;
				point = 0;
				isPointRoll = 0;
				numRolls = 0;
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
				JOptionPane.showMessageDialog(frmCrapsAGame, "Average Number of Rolls per Game: " + numRolls / totalGames,
						"Average Rolls", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnGameStats.add(mntmAvgRollsgame);

		JMenuItem mntmSummary = new JMenuItem("Summary");
		mntmSummary.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(frmCrapsAGame, "Here are your stats for this session: " + "\nTotal Games: " + totalGames + "\nTotal Wins: "
						+ totalWins + "\nAverage Rolls Per Game: " + numRolls / totalGames, "Summary", JOptionPane.INFORMATION_MESSAGE);
			}
		});
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

		shooterNameLbl = new JLabel("Shooter");
		// namePrompt();
		// name = JOptionPane.showInputDialog(frmCrapsAGame, "Please enter your
		// name:", "Shooter's Name",
		// JOptionPane.QUESTION_MESSAGE);
		// shooterNameLbl = new JLabel(name);
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
			private int rollDie(Die die)
			{
				die.roll();
				return die.getValue();
			}

			private void updateDieOnGUI(JLabel dieLabel, int dieValue)
			{
				dieLabel.setIcon(null);
				dieLabel.setText("" + dieValue);
			}

			public void actionPerformed(ActionEvent e)
			{

				// roll 'em
				int die1Value = rollDie(die1);
				int die2Value = rollDie(die2);

				// update die roll value appear on GUI
				updateDieOnGUI(die1ImageLbl, die1Value);
				updateDieOnGUI(die2ImageLbl, die2Value);

				// make sum of both rolls appear on GUI
				sum = die1Value + die2Value;
				updateDieOnGUI(sumImageLbl, sum);

				// add to roll value array
				rolls.add(sum);
				numRolls++;

				// logic
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
						else
						{
							keepPlayingPoint(btnComeOutRoll, winLoseLbl, gameStatusTxt, isPointRoll);
							break;
						}
					}
				}
			}

			private void prompt()
			{
				int reply = JOptionPane.showConfirmDialog(frmCrapsAGame, "Would you like to play again?");
				if (reply == JOptionPane.YES_OPTION)
				{
					reset();
				}
				else if (reply == JOptionPane.CANCEL_OPTION)
				{
					
				}
				else if (reply == JOptionPane.NO_OPTION)
				{
					displayStats();
					System.exit(0);
				}
			}

			private void displayStats()
			{
				JOptionPane.showMessageDialog(frmCrapsAGame,
						"Here are your stats for this session: " + "\nTotal Games: " + totalGames + "\nTotal Wins: "
								+ totalWins + "\nAverage Rolls Per Game: " + numRolls / totalGames,
						"Game Stats", JOptionPane.INFORMATION_MESSAGE);
			}

			private void reset()
			{
				// reset init values
				sum = 0;
				point = 0;
				isPointRoll = 0;
				numRolls = 0;
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
				totalGames++;
			}

			private void keepPlayingPoint(JButton btnComeOutRoll, JLabel winLoseLbl, JLabel gameStatusTxt,
					int isPointRoll)
			{
				// Do Nothing
			}

			private void keepPlaying(JButton btnComeOutRoll, JLabel winLoseLbl, JLabel gameStatusTxt, int isPointRoll)
			{
				point = sum;
				btnComeOutRoll.setText("Point Roll");
				winLoseLbl.setText("Point: " + point);
				winLoseLbl.setForeground(Color.DARK_GRAY);
				gameStatusTxt.setText("Continue");
				isPointRoll = 1;
			}

			private void lose(JButton btnComeOutRoll, JLabel winLoseLbl, JLabel gameStatusTxt, int isPointRoll)
			{
				btnComeOutRoll.setText("Play again");
				winLoseLbl.setText("You Lose.");
				winLoseLbl.setForeground(Color.RED);
				gameStatusTxt.setText("Lost");
				isPointRoll = 0;
			}

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

	private void namePromptAndUpdate()
	{
		name = JOptionPane.showInputDialog(frmCrapsAGame, "Please enter your name:", "Shooter's Name",
				JOptionPane.QUESTION_MESSAGE);
		shooterNameLbl = new JLabel(name);
	}

	public int getNumRolls()
	{
		return numRolls;
	}

	public ArrayList<Integer> getRolls()
	{
		return rolls;
	}

}
