import javax.swing.*;

public class MenuFrame extends JFrame {

    MenuFrame(){
        this.add(new MenuPanel());
        this.setTitle("MEMORY GAME");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}