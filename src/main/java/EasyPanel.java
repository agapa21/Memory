import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class EasyPanel extends JPanel {

    JLabel chansesTextField = new JLabel();
    JLabel levelTextField = new JLabel();
    JButton[] buttons = new JButton[8];
    private int lastButton;
    private int previousButton;
    private int counter = 0;
    int pairs = 4;
    int cards = pairs * 2;
    int chanses = 10;
    private int pairsMatched = 0;
    ArrayList<Integer> positions = new ArrayList<Integer>();
    Words words = new Words();
    Integer[] wordsGrid;

    EasyPanel() {
        this.setPreferredSize(new Dimension(700, 300));
        this.setFocusable(true);
        this.setLayout(new GridLayout(5, 2));
        setLevelTextField();
        this.add(levelTextField);
        setChansesTextfield();
        this.add(chansesTextField);
        addButtons();
        randomizePosition();
    }

    public void addButtons() {
        for (int i = 0; i < cards; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Ink Free", Font.BOLD, 12));
            buttons[i].setText("");
            add(buttons[i]);
            buttons[i].addActionListener(this::buttonClicked);
        }
    }

    public void setChansesTextfield()
    {
        chansesTextField.setText("Guess chances: " + chanses);
        chansesTextField.setFont(new Font("Ink Free",Font.BOLD,27));
        chansesTextField.setHorizontalAlignment(JLabel.CENTER);
    }

    public void setLevelTextField()
    {
        levelTextField.setText("Level: EASY");
        levelTextField.setFont(new Font("Ink Free",Font.BOLD,27));
        levelTextField.setHorizontalAlignment(JLabel.CENTER);
    }

    public void buttonClicked(ActionEvent e) {

        for (int i = 0; i < cards; i++) {
            if (e.getSource() == buttons[i]) {
                buttons[i].setText(words.allWords[wordsGrid[i]]);
                previousButton = lastButton;
                lastButton = i;
            }
        }
        countClicks();
    }

    public void comparePair() {

        if (buttons[previousButton].getText()==buttons[lastButton].getText() && buttons[previousButton]!=buttons[lastButton]) {
            JOptionPane.showMessageDialog(null, "Success!!! :D", "MESSAGE", JOptionPane.PLAIN_MESSAGE);
            buttons[previousButton].setVisible(false);
            buttons[lastButton].setVisible(false);

            previousButton = 0;
            lastButton = 0;

            pairsMatched++;
            checkWin();
        }
        else{
            JOptionPane.showMessageDialog(null, "No match :(","MESSAGE", JOptionPane.PLAIN_MESSAGE);
            buttons[previousButton].setText("");
            buttons[lastButton].setText("");

            countChances();
        }
    }

    public void randomizePosition () {
        Random randomGenerator = new Random();

        while (positions.size() < cards) {

            int random = randomGenerator.nextInt(cards);

            if (!positions.contains(random)) {
                positions.add(random);
            }
        }

        words.randomizeWords(pairs);

        for (int i = 0; i < cards; i++) {
            wordsGrid = words.returnWordsNumber();
        }
    }

    public void countClicks()
    {
        counter++;
        if(counter == 2){
            comparePair();
            counter = 0;
        }
    }

    public void countChances()
    {
        chanses--;
        setChansesTextfield();
        if(chanses == 0){
            gameOverFailure();
        }
    }

    public void gameOverFailure()
    {
        JOptionPane.showMessageDialog(null, "You lose :(");
        System.exit(0);
    }

    public void checkWin()
    {
        if(pairsMatched == pairs)
        {
            JOptionPane.showMessageDialog(null, "You win :)");
            System.exit(0);
        }
    }
}