package blackJack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class BlackJack extends JFrame
{
    private BlackJackGame game;

	private static final long serialVersionUID = 1L;

	public BlackJack()
    {
		//initializes, sets size etc
		
		game = new BlackJackGame();
        this.setSize(960, 960);
        setTitle("BlackJack");
        makeMenu();
        setVisible(true);

        //creates a listener to confirm exit when exit button is clicked
        WindowListener exitListener = new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the game?",
                        "Exit Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
                if (result == 0)
                    System.exit(0);
            }
        };

        this.addWindowListener(exitListener);
        
        //allows screen to pop up on the middle of the screen
        this.setLocationRelativeTo(null);
        this.add(game);
        setVisible(true);
        this.revalidate();
    }

    public void makeMenu()
    {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JButton newGame = new JButton("New Game");

        menuBar.add(newGame);

        newGame.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                game.newGame();
            }
        });
    }

    public static void main(String args[])
    {
        new BlackJack();
    }
}
