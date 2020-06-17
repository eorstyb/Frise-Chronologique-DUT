/**
 * @author Ethan
 */


package Vue;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class FenetreMere extends JFrame{
    //champs
    private PanelMere panelMere;
    private JMenuBar menu = new JMenuBar();
    private JMenuItem itemAccueil = new JMenuItem("Accueil");
    private JMenuItem itemCreation = new JMenuItem("Création");
    private JMenuItem itemAffichage = new JMenuItem("Affichage");
    private JMenuItem itemFermer = new JMenuItem("Fermer");
    private JMenuItem itemAide = new JMenuItem("?");

    public FenetreMere() throws IOException {
        super("Frise chronologique Corona");
        panelMere = new PanelMere(this);
        this.setVisible(true);
        this.setContentPane(this.panelMere);
        this.setBackground(new Color(23, 23, 23));
        this.setDefaultCloseOperation(3);
        this.setSize(1600, 900);

        this.setJMenuBar(menu);
        itemAccueil.addActionListener(panelMere);
        itemCreation.addActionListener(panelMere);
        itemAffichage.addActionListener(panelMere);
        itemFermer.addActionListener(panelMere);
        itemAide.addActionListener(panelMere);

        menu.add(itemAccueil);
        menu.add(itemCreation);
        menu.add(itemAffichage);
        menu.add(itemFermer);
        menu.add(itemAide);
    }

    //getter
    public JMenuItem getItemCreation() {
        return itemCreation;
    }

    public JMenuItem getItemAffichage() {
        return itemAffichage;
    }

    public JMenuItem getItemFermer() {
        return itemFermer;
    }

    public JMenuItem getItemAccueil() {
        return itemAccueil;
    }

    public JMenuItem getItemAide() {
        return itemAide;
    }
}