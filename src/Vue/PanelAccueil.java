package Vue;

import Controleur.Controleur;
import Modele.Frise;
import javax.swing.*;
import java.awt.*;

public class PanelAccueil extends JPanel {
    private Frise[] tabFrises;
    private Controleur controleur;
    private JLabel label;
    private JButton[] tabBoutons = new JButton[20];

    public PanelAccueil() {

    }

    public PanelAccueil(Frise[] frise, Controleur parControleur) {
        this.setLayout(new FlowLayout());
        tabFrises = frise;
        controleur = parControleur;
        label = new JLabel("Voulez-vous changer de frises ?");
        this.add(label);
        int i = 0;
        while (tabFrises[i] != null) {
            tabBoutons[i] = new JButton(tabFrises[i].getIntituleFrise());
            tabBoutons[i].setPreferredSize(new Dimension(250,50));
            tabBoutons[i].addActionListener(controleur);
            this.add(tabBoutons[i]);
            i += 1;
        }
    }
}