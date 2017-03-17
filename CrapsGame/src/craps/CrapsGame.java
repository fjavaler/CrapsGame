//CS1410
//Play Craps game
package craps;

import java.util.Scanner;

public class CrapsGame
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		char again = 'Y';
		Craps game = new Craps();

		do
		{
			game.play(); // play one game of craps
			System.out.print("\nPlay again (Y/N): ");
			again = Character.toUpperCase(input.nextLine().charAt(0));
			System.out.println();
		}
		while (again == 'Y');
		input.close();
	} // end main
} // end class CrapsTest