package blackJack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BlackJackGame extends JPanel {
	private static final long serialVersionUID = 1L;

	BlackJackFunction game;
	int money;
	boolean gamePlay = true;
	int currentBet = 0;
	Player[] players;
	Card downFace = new Card(0, "down", "back.png");

	public BlackJackGame() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(960, 960));
		this.repaint();
	}

	/**
	 * Creates a new game of blackJack resets all variable and scores
	 */
	public void newGame() {
		this.gamePlay = true;
		players = new Player[2];
		players[1] = new Player("Dealer");
		players[0] = new Player("User");

		game = new BlackJackFunction();
		money = 0;
		boolean getMoney = true;
		// add JOptionPane for value of starting money
		while (getMoney) {
			try {
				money = Integer.parseInt(JOptionPane.showInputDialog(this,
						"Enter how much money you want to start with:"));
				System.out.println(money);
				getMoney = false;
			} catch (NumberFormatException e) {
				getMoney = true;
			}
			if (money <= 0) {
				JOptionPane.showMessageDialog(this,
						"That was an invalid input. Please enter a number greater than 0.",
						"ParseInt error", JOptionPane.OK_OPTION);
				getMoney = true;
			}
		}
		this.gamePlay();
	}

	public void gamePlay() {
		while (gamePlay == true)
			handPlay();
	}

	public void handPlay() {
		// initial bet
		int bet = 0;
		boolean tryBet = true;

		while (tryBet) {
			try {
				bet = Integer.parseInt(JOptionPane.showInputDialog(this,
						"You have: $" + money
								+ "\nEnter how much money you want to bet:"));
				if (money - bet < 0) {
					JOptionPane.showMessageDialog(this,
							"You don't have enough money to make that bet.",
							"Ya broke.", JOptionPane.OK_OPTION);
				}else if(bet <= 0)
				{
					JOptionPane.showMessageDialog(this,
							"That was an invalid input. Please enter a number greater than 0.",
							"ParseInt error", JOptionPane.OK_OPTION);
				}
				else {
					money = money - bet;
					tryBet = false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,
						"That was an invalid input. Please enter a number greater than 0.",
						"ParseInt error", JOptionPane.OK_OPTION);
			}
		}
		// start the game
		players = game.dealStart();
		ArrayList<Card> playerCards = players[0].getHand();
		ArrayList<Card> dealerCards = players[1].getHand();

		// add player cards to GUI
		int x = 100;
		int y = 500;

		playerCards.get(0).setLocation(x, y);
		playerCards.get(0).setSize(125, 175);
		add(playerCards.get(0));

		x += 150;

		playerCards.get(1).setLocation(x, y);
		playerCards.get(1).setSize(125, 175);
		add(playerCards.get(1));

		// add dealer cards to GUI
		int xD = 100;
		int yD = 20;

		dealerCards.get(0).setLocation(xD, yD);
		dealerCards.get(0).setSize(125, 175);
		add(dealerCards.get(0));

		xD += 150;

		downFace.setLocation(xD, yD);
		downFace.setSize(125, 175);
		add(downFace);

		repaint();

		// doubles the bet after dealing
		if (money >= bet)
			if (0 == JOptionPane.showConfirmDialog(this,
					"Would you like to double down?", "Double Down",
					JOptionPane.YES_NO_OPTION)) {
				money -= bet;
				bet *= 2;
			}

		boolean bust = false;
		boolean user = true;
		int count = 2;

		// User turn
		while (user) {
			// Hit or stay
			if (0 == JOptionPane.showConfirmDialog(
					this,
					"Would you like to hit?\nYour hand value: "
							+ players[0].getPlayersHandTotal(), "Hit or stay",
					JOptionPane.YES_NO_OPTION)) {
				players[0] = game.hitStay(true);
				playerCards = players[0].getHand();

				x += 150;

				playerCards.get(count).setLocation(x, y);
				playerCards.get(count).setSize(125, 175);
				add(playerCards.get(count));

				repaint();
				count++;

				if (players[0].getPlayersHandTotal() > 21) {
					user = false;
					bust = true;
				}
			} else {
				game.hitStay(false);
				user = false;
			}
		}

		remove(downFace);
		dealerCards.get(1).setLocation(xD, yD);
		dealerCards.get(1).setSize(125, 175);
		add(dealerCards.get(1));
		repaint();

		// Dealer turn
		count = 2;
		while (!user && !bust) {
			// dealer doesn't go if their hand == 17 or their hand is already
			// greater than the players
			if (players[1].getPlayersHandTotal() < 17
					&& players[1].getPlayersHandTotal() < players[0]
							.getPlayersHandTotal()) {
				players[1] = game.hitStay(true);
				JOptionPane.showMessageDialog(this, "Dealer hits",
						"Dealer hit", JOptionPane.OK_OPTION);
				dealerCards = players[1].getHand();
				xD += 150;

				dealerCards.get(count).setLocation(xD, yD);
				dealerCards.get(count).setSize(125, 175);
				add(dealerCards.get(count));

				repaint();
				count++;
			} else {
				game.hitStay(false);
				user = true;
			}

		}
		if (bust) {
			JOptionPane.showMessageDialog(this, "Bust! Dealer wins.", "Bust",
					JOptionPane.OK_OPTION);
		}

		else if (players[1].getPlayersHandTotal() > 21) {
			JOptionPane.showMessageDialog(this, "Dealer bust!", "Hand won",
					JOptionPane.OK_OPTION);
			money += bet * 2;
		} else if (players[1].getPlayersHandTotal() < players[0]
				.getPlayersHandTotal() && players[0].getPlayersHandTotal() < 21) {
			JOptionPane.showMessageDialog(
					this,
					"You won the hand!\nYour card value"
							+ players[0].getPlayersHandTotal()
							+ "\nDealer card value: "
							+ players[1].getPlayersHandTotal(), "Hand won",
					JOptionPane.OK_OPTION);
			money += bet * 2;
		} else if (players[0].getPlayersHandTotal() == 21
				&& players[1].getPlayersHandTotal() != 21) {
			JOptionPane.showMessageDialog(this, "You got Black Jack!",
					"Black Jack", JOptionPane.OK_OPTION);
			money += bet * 2;
			money += bet / 2;
		} else if (players[1].getPlayersHandTotal() == players[0]
				.getPlayersHandTotal()) {
			JOptionPane.showMessageDialog(this, "You tied with the dealer",
					"Stand-off", JOptionPane.OK_OPTION);
			money += bet;
		} else {
			JOptionPane.showMessageDialog(
					this,
					"House won the hand\nYour card value: "
							+ players[0].getPlayersHandTotal()
							+ "\nDealer card value: "
							+ players[1].getPlayersHandTotal(), "Hand lost",
					JOptionPane.OK_OPTION);
		}

		for (Card c : dealerCards)
			remove(c);
		for (Card c : playerCards)
			remove(c);
		if (money == 0) {
			JOptionPane.showMessageDialog(this, "You're out of money.",
					"Game over.", JOptionPane.OK_OPTION);
			gamePlay = false;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(6, 138, 26));
		g.fillRect(0, 0, 960, 960);
	}
}
