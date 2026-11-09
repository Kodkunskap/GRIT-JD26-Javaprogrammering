import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    GUI() {

        JFrame frame = new JFrame("My window title");    // Skapar fönstret (syns inte)
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Skapa en "panel" för att hålla flera komponenter
        JPanel panel = new JPanel();
        frame.add(panel);

        // Skapar en knapp
        JButton button = new JButton("Jag är en knapp!");
        panel.add(button);

        JLabel label = new JLabel("Jag är en etikett!");
        panel.add(label);

        JTextArea textArea = new JTextArea("Jag är en JTextArea", 1, 25);
        textArea.setLineWrap(false);
        textArea.setWrapStyleWord(true);
        panel.add(textArea);

        /*
                För att hantera events så måste vi koppla en ActionListener till
                komponenten
         */
        ActionListener actionListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("actionPerformed - knappen blev tryckt");
            }    
        };
        button.addActionListener(actionListener);

        frame.setVisible(true);
    }

}
