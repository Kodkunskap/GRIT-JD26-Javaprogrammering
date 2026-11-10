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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        panel.add(Box.createVerticalGlue());    // Lägg överblivet utrymme här

        JLabel header = new JLabel("Gissa talet mellan 1 och 100!");
        header.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(header);
        panel.add(Box.createVerticalStrut(10));
        result = new JLabel("Du har gissat: 0 gånger");
        result.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(result);
        panel.add(Box.createVerticalStrut(10));

        guess = new JTextField("", 25);
        guess.setMaximumSize(guess.getPreferredSize());
        guess.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        guess.addActionListener(this);  // When user hit's enter -- this event will be called
        panel.add(guess);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        guessButton = new JButton("Gissa");
        guessButton.addActionListener(this);
        buttonPanel.add(guessButton);
        restartButton = new JButton("Starta om");
        restartButton.addActionListener(this);
        buttonPanel.add(restartButton);

        buttonPanel.setMaximumSize(buttonPanel.getPreferredSize());
        panel.add(buttonPanel);
        panel.add(Box.createVerticalStrut(10));

        message = new JLabel(" ");
        message.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.add(message);

        panel.add(Box.createVerticalGlue());

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

        guess.setText("");              // Empty the guess input
        guess.requestFocusInWindow();   // Set the focus to the guess input
    }

    private void onRestartBtnClicked() {
        secretNumber = random.nextInt(1, 101);
        numberOfGuesses = 0;
        result.setText("Du har gissat: " + numberOfGuesses + " gånger");
        message.setText("Jag har valt ett nytt hemligt tal!");
        guess.setText("");              // Empty the guess input
        guess.requestFocusInWindow();   // Set the focus to the guess input
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
            Both button press and enter in guess box
            should trigger guess-logic
         */
        if(e.getSource() == guessButton || e.getSource() == guess) {
            onGuessBtnClicked();
        }
        if(e.getSource() == restartButton) {
            onRestartBtnClicked();
        }

    }

}
