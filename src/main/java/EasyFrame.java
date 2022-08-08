import javax.swing.*;
import java.awt.*;

public class EasyFrame extends JFrame {

    EasyFrame(){
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(new EasyPanel());
        this.setTitle("EASY LEVEL");
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}