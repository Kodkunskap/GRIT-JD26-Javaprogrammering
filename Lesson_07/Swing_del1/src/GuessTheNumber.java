import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessTheNumber extends JFrame implements ActionListener {

    private JTextField guess;
    private JLabel message;
    private JLabel result;
    private JButton guessButton, restartButton;
    private int secretNumber;
    private int numberOfGuesses = 0;
    private Random random;

    GuessTheNumber() {
        super("Gissa talet");
        initGUI();

        random = new Random();
        secretNumber = random.nextInt(1, 101);
    }

    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JPanel panel = new JPanel();
        add(panel);

        JLabel header = new JLabel("Gissa talet mellan 1 och 100!");
        panel.add(header);
        result = new JLabel("Du har gissat: 0 gånger");
        panel.add(result);

        guess = new JTextField("", 25);
        panel.add(guess);

        guessButton = new JButton("Gissa");
        guessButton.addActionListener(this);
        panel.add(guessButton);
        restartButton = new JButton("Starta om");
        restartButton.addActionListener(this);
        panel.add(restartButton);

        message = new JLabel("");
        panel.add(message);

        setVisible(true);
    }

    private void onGuessBtnClicked() {
        String input = guess.getText();
        int guessNumber = Integer.parseInt(input);

        if(guessNumber > secretNumber) {
            message.setText("Mitt tal är mindre!");
        } else if(guessNumber < secretNumber) {
            message.setText("Mitt tal är större!");
        } else {
            message.setText("Du har gissat rätt!");
        }

        numberOfGuesses++;
        result.setText("Du har gissat: " + numberOfGuesses + " gånger");
    }

    private void onRestartBtnClicked() {
        secretNumber = random.nextInt(1, 101);
        numberOfGuesses = 0;
        result.setText("Du har gissat: " + numberOfGuesses + " gånger");
        message.setText("Jag har valt ett nytt hemligt tal!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == guessButton) {
            onGuessBtnClicked();
        }
        if(e.getSource() == restartButton) {
            onRestartBtnClicked();
        }
    }

}
