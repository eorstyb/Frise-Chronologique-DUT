package Vue;

import Controleur.Controleur;
import Modele.Frise;
import javax.swing.*;
import java.awt.*;
import static Vue.Constantes.*;

import static Vue.CouleurConstantes.SOBRE;
import static Vue.CouleurConstantes.TEST;

public class PanelAccueil extends JPanel {
    private Frise[] tabFrises;
    private Controleur controleur;
    private JLabel label;
    private JPanel panelAccueil;
    private JButton[] tabBoutons = new JButton[20];

    public PanelAccueil() {

    }

    public PanelAccueil(Frise[] frise, Controleur parControleur) {
        this.setLayout(new GridBagLayout());
<<<<<<< HEAD
        this.setBackground(SOBRE);

=======
>>>>>>> 0a10ebc940f353230259a3713634f0144c0c20cc
        tabFrises = frise;
        controleur = parControleur;
        label = new JLabel("Voulez-vous changer de frises ?");
        panelAccueil = new JPanel();
        GridBagConstraints contrainte = new GridBagConstraints();

        contrainte.insets = new Insets(20, 20, 20, 20);
        contrainte.gridx = 0;
        contrainte.gridy = 0;
        contrainte.anchor = GridBagConstraints.CENTER;

        panelAccueil.add(label, contrainte);

        this.add(panelAccueil);
        this.add(panelAccueil);
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