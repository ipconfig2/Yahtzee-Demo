//class 2

import java.util.Random;
import java.util.Scanner;

public class Yahtzee {

  //instance variables
  private Die[] d;
  private int[] count = new int[6];
public Yahtzee()
{

d = new Die[5];
for(int i = 0; i < 5; i++)//make the 5 dice
  d[i] = new Die();
}
 public void getRerollNumbers()
{
  Scanner rerollInput = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter die number(s) to keep (separated by a space):");
    String userKeep = rerollInput.nextLine();  // Read user input
      if (userKeep.contains("1") == false)
      {
        rollADie(1);
      }
      if (userKeep.contains("2") == false)
      {
        rollADie(2);
      }
      if (userKeep.contains("3") == false)
      {
        rollADie(3);
      }
      if (userKeep.contains("4") == false)
      {
        rollADie(4);
      }
      if (userKeep.contains("5") == false)
      {
        rollADie(5);
      }
}

//This method rolls all the dice
  public void rollAllDice() {
    for (int i = 0; i < 5; i++) {
      d[i].roll();
    }
    updateCount();//Updates the count
  }

//This method rolls a die based off the number you give
  public void rollADie(int dieNumber) {
    d[dieNumber - 1].roll();
    updateCount();//Updates the count
  }

//This get a current die's number based on what you put in
  public int getADie(int dieNumber) {
    return d[dieNumber - 1].getValue();
  }

//This methods outputs the data of the dices current state
  public String showDice() {
    String Dice = "+------+---+---+---+---+---+\n| Dice | 1 | 2 | 3 | 4 | 5 |\n+------+---+---+---+---+---+\n| Face | "
        + d[0].getValue() + " | " + d[1].getValue() + " | " + d[2].getValue() + " | " + d[3].getValue() + " | " + d[4].getValue() + " |\n+------+---+---+---+---+---+";
    return Dice;

  }

  //This method is used to count up the the number of numbers in the method and then outputs the um of that number
  private int countUp(int value)
	{
//This method returns the number of n dice rolls that have the value
    int counter = 0;
    int num = 0;
	  for (int i = 0; i <= 4; i++)
    {
      num = d[i].getValue();
        if( num == value){
        counter++;
        }
    }
    return counter;

	}
	//This method updates the count
	public void updateCount()
	{

		for (int i = 0; i < 6; i++){
			count[i] = countUp(i + 1);
      // Test update count: System.out.println("Number of " + (i + 1) + "s rolled: " + count[i]);
    }
	}
	//This is a method that tells you how many one's you have then adds them up
	public int getScoreOnes()
	{
    return countUp(1);
	}

	//This is a method that tells you how many Two's you have then adds them up
	public int getScoreTwos()
	{
    return countUp(2) * 2;
	}

	//This is a method that tells you how many Three's you have then adds them up
	public int getScoreThrees()
	{
    return countUp(3) * 3;
	}

	//This is a method that tells you how many four's you have then adds them up
	public int getScoreFours()
	{
    return countUp(4) * 4;
	}

	//This is a method that tells you how many five's you have then adds them up
	public int getScoreFives()
	{
   return countUp(5) * 5;
	}

	//This is a method that tells you how many six's you have then adds them up
	public int getScoreSixes()
	{
    return countUp(6) * 6;
	}
	//If a roll contains at least three of the same die faces, simply total all the die faces and that is the score of this category.
	public int getScoreThreeOfAKind()
	{
		for (int i = 0; i <= 6; i++)
    {
     if( countUp(i) >= 3)
     {
       return countUp(i) * i;
     }
    }
    return 0;
	}

	//The scoring of this category is the same as the Three of a Kind (total all the die faces) except that you must have at least four of the same die faces.
	public int getScoreFourOfAKind()
	{
		for (int i = 0; i <= 6; i++)
    {
     if( countUp(i) >= 4)
     {
       return countUp(i) * i;
     }
    }
    return 0;
	}
	//If you have three of a kind and a pair (e.g., 5, 3, 5, 5, 3), the score of this category is 25.
	public int getScoreFullHouse()
	{
    for (int i = 0; i <= 6; i++)
    {
      if( countUp(i) == 3)
     {
       for (int j = 0; j <= 6; j++)
    {
       if( countUp(j) == 2)
     {
       return 25;
     }
    }
     }
    }
    return 0;
    }

	//If you have a sequence of 4 consecutive die faces (e.g., 2, 4, 3, 4, 5), 30 points.
	public int getScoreSmallStraight()
	{
    int countThing = 0;
		for (int i = 0; i <= 6; i++){
      if (countUp(i) == 1)
      {
        countThing++;
      }
    }
    if (countThing == 3){
      for (int i = 0; i <= 6; i++){
        if ( countUp(i) == 2){
          countThing++;
        }
      }
    }
    if (countThing == 4)
    {
      return 30;
    }
    return 0;
	}
	//If you have a sequence of 5 consecutive die faces, 40 points.
	public int getScoreLargeStraight()
	{
		int countThing = 0;
		for (int i = 0; i <= 6; i++){
      if (countUp(i) == 1)
      {
        countThing++;
      }
    }
    if (countThing == 5)
    {
      return 40;
    }
    return 0;
	}

	//For this category, simply total all the die faces values.
	public int getScoreChance()
	{
		return getScoreOnes() + getScoreTwos() + getScoreThrees() + getScoreFours() + getScoreFives() + getScoreSixes();
	}
	//The point of this method is to output your current score in a crad like format
	public int getScoreYahtzee()
	{
			for (int i = 0; i <= 6; i++)
    {
     if( countUp(i) == 5)
     {
       return 50;
     }
    }
    return 0;
	}

	//This method return a score card of the current roll in the form of a String (similarly to the showDice() method).
	public String getScoreCard()
	{
		String scoreCard = "Ones: " + getScoreOnes() + "\nTwos: " + getScoreTwos() + "\nThrees: " + getScoreThrees() +"\nFours: " + getScoreFours() + "\nFives: " + getScoreFives() + "\nSixes: " + getScoreSixes() + "\n" + "\nThree of a Kind: " + getScoreThreeOfAKind() + "\nFour of a Kind: " + getScoreFourOfAKind() + "\nFull House: " + getScoreFullHouse() + "\nSmall Straight: " + getScoreSmallStraight() + "\nLarge Straight: " + getScoreLargeStraight() + "\nChance: " + getScoreChance() +"\nYahtzee: " + getScoreYahtzee();
    return scoreCard;
	}

}
/*
+------+---+---+---+---+---+
| Dice | 1 | 2 | 3 | 4 | 5 |
+------+---+---+---+---+---+
| Face | 5 | 2 | 6 | 1 | 1 |
+------+---+---+---+---+---+
Ones: 2
Twos: 2
Threes: 0
Fours: 0
Fives: 5
Sixes: 6

Three of a Kind: 0
Four of a Kind: 0
Full House: 0
Small Straight: 0
Large Straight: 0
Chance: 15
Yahtzee: 0
Enter die number(s) to keep (separated by a space):
2
+------+---+---+---+---+---+
| Dice | 1 | 2 | 3 | 4 | 5 |
+------+---+---+---+---+---+
| Face | 3 | 2 | 2 | 5 | 6 |
+------+---+---+---+---+---+
Ones: 0
Twos: 4
Threes: 3
Fours: 0
Fives: 5
Sixes: 6

Three of a Kind: 0
Four of a Kind: 0
Full House: 0
Small Straight: 0
Large Straight: 0
Chance: 18
Yahtzee: 0
Enter die number(s) to keep (separated by a space):
3
+------+---+---+---+---+---+
| Dice | 1 | 2 | 3 | 4 | 5 |
+------+---+---+---+---+---+
| Face | 5 | 6 | 2 | 4 | 3 |
+------+---+---+---+---+---+
Ones: 0
Twos: 2
Threes: 3
Fours: 4
Fives: 5
Sixes: 6

Three of a Kind: 0
Four of a Kind: 0
Full House: 0
Small Straight: 0
Large Straight: 40
Chance: 20
Yahtzee: 0
*/