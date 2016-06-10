package main.java;

/*
 * In the card game poker, a hand consists of five cards and are ranked, from lowest to 
 * highest, in the following way:
 * 
 * - High Card: Highest value card.
 * - One Pair: Two cards of the same value.
 * - Two Pairs: Two different pairs.
 * - Three of a Kind: Three cards of the same value.
 * - Straight: All cards are consecutive values.
 * - Flush: All cards of the same suit.
 * - Full House: Three of a kind and a pair.
 * - Four of a Kind: Four cards of the same value.
 * - Straight Flush: All cards are consecutive values of same suit.
 * - Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
 * 
 * The cards are valued in the order:
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 * 
 * If two players have the same ranked hands then the rank made up of the highest 
 * value wins; for example, a pair of eights beats a pair of fives (see example 1 below). 
 * But if two ranks tie, for example, both players have a pair of queens, then highest 
 * cards in each hand are compared (see example 4 below); if the highest cards tie then 
 * the next highest cards are compared, and so on.
 * 
 * Consider the following five hands dealt to two players:
 * 
 * Hand   Player 1           Player 2             Winner
 * 1      5H 5C 6S 7S KD     2C 3S 8S 8D TD       Player 2
 *        Pair of Fives      Pair of Eights
 * 2      5D 8C 9S JS AC     2C 5C 7D 8S QH       Player 1
 *        Highest card Ace   Highest card Queen   
 * 3      2D 9C AS AH AC     3D 6D 7D TD QD       Player 2
 *        Three Aces         Flush with Diamonds  
 * 4      4D 6S 9H QH QC     3D 6D 7H QD QS       Player 1
 *        Pair of Queens     Pair of Queens
 *        Highest card Nine  Highest card Seven
 * 5      2H 2D 4C 4D 4S     3C 3D 3S 9S 9D       Player 1
 *        Full House         Full House
 *        With Three Fours   with Three Threes
 *        
 * The file, p054_poker.txt, contains one-thousand random hands dealt to two players. 
 * Each line of the file contains ten cards (separated by a single space): 
 * the first five are Player 1's cards and the last five are Player 2's cards. 
 * You can assume that all hands are valid (no invalid characters or repeated cards), 
 * each player's hand is in no specific order, and in each hand there is a clear winner.
 * 
 * How many hands does Player 1 win?
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P054 extends Problem {

	@Override
	public String solve() {
		int player1wins = 0; // answer to return, number of wins for player 1

		String path = new File("../res/p054_poker.txt").getAbsolutePath();
		String file = "";
		try {
			file = readFile(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			return "ERROR: could not read file: " + e.getMessage();
		}
		
		String hands[] = file.split("\\r?\\n");	// array of hands
		for (String hand : hands) {
			String[] p1 = hand.substring(0, hand.length()/2).split("\\s+"); // player 1's cards
			String[] p2 = hand.substring(hand.length()/2+1).split("\\s+"); // player 2's cards
		
		}

		return Integer.toString(player1wins);
	}

}
