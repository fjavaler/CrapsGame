/********************************************************
 *  
 *  Project :  Craps Game
 *  File    :  Die.java
 *  Name    :  Frederick Javalera
 *  Date    :  Created: 3/18/2017 (Due: 3/13/2017)
 *
 *  Description : (Narrative description, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *    This code is a simulation of a die. It is used as the dice being roled
 *    in CrapsGUI.
 *
 *    2) What data-structures are used.
 *    None.
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *	  A Random number generator was used to randomize the die's rolls.
 *
 *    4) What methods are implemented (optional).
 *    A Main method, an initialize method, and several helper classes.
 *
 *  Changes :  <Description|date of modifications>
 *
 ********************************************************/
package craps;

import java.util.Random;

class Die
{
	// class variables
	private int dieValue_;
	public final static int MAX_DIE_VALUE = 6;
	public final static int MIN_DIE_VALUE = 1;
	private Random r;

	// default constructor
	Die()
	{
		dieValue_ = MIN_DIE_VALUE;
		r = new Random();
	}

	// class methods
	public void roll()
	{
		dieValue_ = MIN_DIE_VALUE + r.nextInt(MAX_DIE_VALUE);
		// dieValue_ = (int)(MIN_DIE_VALUE + Math.random() * MAX_DIE_VALUE);
	}

	public int getValue()
	{
		return dieValue_;
	}

	@Override
	public String toString()
	{
		return "%d" + dieValue_;
	}
}
