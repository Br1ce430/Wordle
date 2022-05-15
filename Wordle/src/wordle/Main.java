package wordle;

import java.util.Random;

import javax.swing.JOptionPane;
//Main class which houses all the code, including the main method and other methods to compute various actions.
public class Main {
	
	public static String cheat;
	//This method uses the guess and the correct word to output symbols to tell the user what letters are correct, incorrect, or in the wrong position.
	public static String getHint(String word, String guess){
		String hint = "";
		for (int i = 0; i < guess.length(); i++){
			if (guess.substring(i,i+1).equals(word.substring(i,i+1))){
				hint += guess.substring(i,i+1);
			} else if (word.indexOf(guess.substring(i,i+1))!= -1){
				hint += "|+|";
			} else {
				hint += "|*|";
			}
		}
		return hint;
	}
	//This method gets the guess thaqt the user imputed and return it if the guess is 5 letters.
	public static String guess()
	{
		boolean runGuess = true;
		String guess = null;
		while (runGuess)
		{
			guess = JOptionPane.showInputDialog(null, "Enter a 5 letter word:");
			if (guess.length() == 5)
				runGuess = false;
		}
		return guess;
	}
	//This is the main method which runs the game based off of different guesses made by the user.
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Welcome to bootleg Wordle!");
		JOptionPane.showMessageDialog(null, "Key:\n|+| = Letter is in word, but in different position\n|*| = Letter is not in word\n|letter| = Correct letter in correct position");
		cheat = JOptionPane.showInputDialog(null, "Enter \"Rico\" to show word bank (Click OK to skip): ");
		if (cheat.equalsIgnoreCase("Rico")){
			JOptionPane.showMessageDialog(null, "Hello Mr.Rico, here are all the possible words:\ntable, paper, games, cable, crane, apple, watch, ruler, shoes, paint\nHope this helps!");
		}
		String[] library = {"table", "paper", "games", "cable", "crane", "apple", "watch", "ruler", "shoes", "paint"};
		
		Random rand = new Random();
		int r = rand.nextInt(10);
		String word = library[r];
		boolean showLose = true;
		int tries = 0;
		for(int i = 0; i < 6; i++)
		{
			String guess = guess();
			tries++;
			String print = getHint(word, guess);
			boolean showMessage = true;
			if(print.equals(word))
			{
				i = 6;
				JOptionPane.showMessageDialog(null, "You guessed it in " + tries + " attempts!");
				showLose = false;
				showMessage = false;
			}
			if (showMessage)
				JOptionPane.showMessageDialog(null, print + "\n" + "You have "+ (5 - i) + " guesses left");
		}
		if(showLose)
			JOptionPane.showMessageDialog(null, "Out of guesses! the word was: "+ word);
	}
}
