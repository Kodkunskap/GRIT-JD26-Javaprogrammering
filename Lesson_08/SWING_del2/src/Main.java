import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {

    Main() {
        setSize(640, 480);
        setTitle("SWING del 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //testAnonymousClasses();
        //noLayoutManager();
        //flowLayout();
        //gridLayout();
        //gridBagLayout();
        //borderLayout();

        //boxLayout();
        //cardLayout();
        //dynamicExample();
        //adapterExample();

        //pack();     // Metod i JFrame -- använd inte med noLayout!

        setLocationRelativeTo(null);    // Centrera fönstret på skärmen
        setVisible(true);
    }


    private void adapterExample() {
        // An anonymous class can also extend a class, not only implement an interface.
        // WindowAdapter implements WindowListener with empty methods,
        // so we only override the method we care about.
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int answer = JOptionPane.showConfirmDialog(Main.this,
                        "Vill du verkligen avsluta?", "Avsluta", JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        add(new JLabel("Försök stänga fönstret", SwingConstants.CENTER));
    }

    private void dynamicExample() {
        setLayout(new BorderLayout());

        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(itemPanel), BorderLayout.CENTER);

        JButton addButton = new JButton("Lägg till rad");
        add(addButton, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            itemPanel.add(new JLabel("Rad " + (itemPanel.getComponentCount() + 1)));
            // The window is already visible -> tell Swing to lay out and paint again.
            // Try removing these two lines and see what happens.
            itemPanel.revalidate();
            itemPanel.repaint();
        });
    }

    private void cardLayout() {
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);

        JButton page1 = new JButton("This is page 1 - click for next");
        add(page1, "PAGE1");

        JButton page2 = new JButton("This is page 2 - click for next");
        add(page2, "PAGE2");

        JButton page3 = new JButton("This is page 3 - click to go to first page");
        add(page3, "PAGE3");

        // The first argument is the container that uses the CardLayout.
        // For a JFrame that is the content pane, not the JFrame itself.
        // Main.this = the Main object (inside the anonymous class, "this" is the ActionListener)
        page1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(Main.this.getContentPane());
            }
        });
        page2.addActionListener(e -> cardLayout.next(getContentPane()));
        page3.addActionListener(e -> cardLayout.first(getContentPane()));

        // Show a card by name (other methods: first, last, next, previous)
        cardLayout.show(getContentPane(), "PAGE1");
    }

    private void boxLayout() {
        // BoxLayout needs the container it is laying out. For a JFrame that is the
        // content pane - new BoxLayout(this, ...) gives "BoxLayout can't be shared".
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("This is label 1");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label1);

        add(Box.createVerticalStrut(10));          // Fixed space of 10 pixels

        JButton button1 = new JButton("This is button 1");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(button1);

        add(Box.createVerticalGlue());             // Takes up all extra space

        JLabel label2 = new JLabel("This is label 2");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label2);

        add(Box.createRigidArea(new Dimension(0, 20))); // Fixed size area

        JButton button2 = new JButton("This is button 2");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(button2);

        // Try: change one of the components to LEFT_ALIGNMENT or RIGHT_ALIGNMENT.
        // BoxLayout aligns the components relative to each other,
        // so mixing alignments gives a staggered result.
    }

    private void borderLayout() {
        setLayout(new BorderLayout(5, 5)); // hgap, vgap = space between the areas

        JLabel label1 = new JLabel("This is label 1 (NORTH)");
        add(label1, BorderLayout.NORTH);   // Preferred height, full width

        JButton button1 = new JButton("This is button 1 (WEST)");
        add(button1, BorderLayout.WEST);   // Preferred width, full height

        JButton button3 = new JButton("EAST");
        add(button3, BorderLayout.EAST);

        JLabel label2 = new JLabel("This is label 2 (SOUTH)");
        add(label2, BorderLayout.SOUTH);

        JButton button2 = new JButton("This is button 2 (CENTER)");
        add(button2, BorderLayout.CENTER); // Gets all the space that is left

        // Each area can only hold ONE component. Uncomment and button2 disappears:
        //add(new JButton("Another CENTER button"), BorderLayout.CENTER);
        // Need more components in one area? Put them in a JPanel first.
    }

    private void gridBagLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);

        JLabel label1 = new JLabel("This is label 1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        add(label1, gbc);

        JButton button1 = new JButton("This is button 1");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(button1, gbc);

        JButton button2 = new JButton("This is label 2");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;  // Spawn two columns
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(button2, gbc);

    }

    private void gridLayout() {
        setLayout(new GridLayout(2, 2, 5, 5)); // rows, columns, hgap, vgap
        // new GridLayout(0, 3) = any number of rows, 3 columns

        JLabel label1 = new JLabel("This is label 1");
        add(label1);

        JButton button1 = new JButton("This is button 1");
        add(button1);

        JLabel label2 = new JLabel("This is label 2");
        add(label2);

        JButton button2 = new JButton("This is button 2");
        button2.setBounds(300, 40, 120, 20); // Ignored! The layout manager decides
        add(button2);
    }

    private void flowLayout() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 5));

        JLabel label1 = new JLabel("This is my first label");
        add(label1);
        JLabel label2 = new JLabel("This is my second label");
        add(label2);
        JButton button1 = new JButton("Button 1");
        add(button1);
        JButton button2 = new JButton("Button 2");
        add(button2);
    }

    private void noLayoutManager() {
        setLayout(null);

        JLabel label1 = new JLabel("This is label 1");
        label1.setBounds(10, 10, 100, 20);
        add(label1);

        JButton button1 = new JButton("This is button 1");
        button1.setBounds(200, 10, 120, 20);
        add(button1);

        JLabel label2 = new JLabel("This is label 2");
        label2.setBounds(150, 40, 100, 20);
        add(label2);

        JButton button2 = new JButton("This is button 2");
        button2.setBounds(300, 40, 120, 20);
        add(button2);
    }

    private void testAnonymousClasses() {

        final String mySpecialColor = "yellow";

        Veggie myCucumber = new Veggie()
        {

            final String myColor = "green";

            @Override
            public String getColor() {
                if (!mySpecialColor.isBlank()) {
                    return mySpecialColor;
                }
                return myColor;
            }
        };

        System.out.println("Min gurka är " + myCucumber.getColor());

    }

    public static void main() {
        //Main main = new Main();
        //SwingUtilities.invokeLater(Main::new);
        SwingUtilities.invokeLater(GuessTheNumber::new);
    }

}