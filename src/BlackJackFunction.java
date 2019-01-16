package blackJack;

import java.util.Scanner;

public class BlackJackFunction
{
	// Dealer at 0 and user at 1
	Player[] players = new Player[2];
	Deck deck = new Deck();
	boolean userTurn = true;

	public BlackJackFunction()
	{

	}

	/**
	 * Deals card to the players the first two cards are for the dealer and the last
	 * two cards are for the user.
	 */
	public Player[] dealStart()
	{
		// fill and shuffle deck
		deck.fillDeck();
		deck.shuffleDeck();
		players[0] = new Player("Group4");
		players[1] = new Player("The Dealer");

		players[0].addCardToHand(deck.drawCard());
		players[1].addCardToHand(deck.drawCard());
		players[0].addCardToHand(deck.drawCard());
		players[1].addCardToHand(deck.drawCard());
		
		userTurn = true;
		
		return players;
	}

	/**
	 * If hit is true, deal another card to user/dealer if hit is false change turn
	 * to dealer or end the hand
	 * 
	 * If player hits return true else return false
	 */
	public Player hitStay(boolean hit)
	{
		if (!userTurn)
		{
			if (players[1].getPlayersHandTotal() < 17)
			{
				players[1].addCardToHand(deck.drawCard());
			} else
			{
				userTurn = true;
			}
			return players[1];
		}
		
		if (userTurn)
		{
			if (hit)
			{
				players[0].addCardToHand(deck.drawCard());
			}
			if (!hit)
			{
				userTurn = false;
			}
			return players[0];
		}

		return null;
	}
}