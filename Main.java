
//header Holden Weber this is my own work. This is the game yahtzee

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Yahtzee yahtzee = new Yahtzee();

    yahtzee.rollAllDice();
    System.out.println(yahtzee.showDice());
    System.out.println(yahtzee.getScoreCard());
    yahtzee.getRerollNumbers();
    System.out.println(yahtzee.showDice());
    System.out.println(yahtzee.getScoreCard());
    yahtzee.getRerollNumbers();
    System.out.println(yahtzee.showDice());
    System.out.println(yahtzee.getScoreCard());
  }
}