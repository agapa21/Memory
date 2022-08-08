import javax.swing.*;
import java.awt.*;

public class HardFrame extends JFrame {

    HardFrame(){
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(new HardPanel());
        this.setTitle("HARD LEVEL");
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}