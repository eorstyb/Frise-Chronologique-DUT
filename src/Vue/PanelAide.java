package Vue;

import javax.swing.*;
import java.awt.*;

public class PanelAide extends JPanel {
    public PanelAide() {
        this.setLayout(new GridLayout(10,10));
        JLabel presentation = new JLabel("Bonjour et bienvenue notre application de frise chronologique !");
        this.add(presentation);
    }
}
