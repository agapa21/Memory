import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel{

    static final int SCREEN_WIDTH = 700;
    static final int SCREEN_HEIGHT = 500;

    String level;

    MenuPanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setFocusable(true);
        this.setLayout(null);

        menuButtonEasy();
        menuButtonHard();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        menuText(g);
    }

    public void menuText(Graphics g)
    {
        g.setColor(Color.black);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("MEMORY GAME",(SCREEN_WIDTH - metrics.stringWidth("MEMORY GAME"))/2, SCREEN_HEIGHT/5);

        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Choose difficulty level",(SCREEN_WIDTH - metrics2.stringWidth("Choose difficulty level"))/2, 2*SCREEN_HEIGHT/5);
    }

    public void menuButtonEasy() {
        JButton buttonEasy = new JButton("EASY");
        buttonEasy.setBounds(SCREEN_WIDTH / 2 - 50, 3 * SCREEN_HEIGHT / 5 - 35, 100, 70);
        buttonEasy.setFont(new Font("Ink Free", Font.BOLD, 20));
        add(buttonEasy);
        buttonEasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EasyFrame easyFrame = new EasyFrame();
                setLevel("EASY");
            }
        });
    }

    public void menuButtonHard(){
        JButton buttonHard = new JButton("HARD");
        buttonHard.setBounds(SCREEN_WIDTH / 2 - 50, 4 * SCREEN_HEIGHT / 5 - 35, 100, 70);
        buttonHard.setFont(new Font("Ink Free", Font.BOLD, 20));
        add(buttonHard);
        buttonHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HardFrame hardFrame = new HardFrame();
                setLevel("HARD");
            }
        });
    }

    public void setLevel(String lvl)
    {
        level = lvl;
    }

    public String getLevel()
    {
        return level;
    }
}
