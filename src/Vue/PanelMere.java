package Vue;

import Controleur.Controleur;
import Modele.Frise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMere extends JPanel implements ActionListener {
    //champs
    private PanelCreation panelCrea;
    private PanelAffichage panelAff;
    private FenetreMere fenetreMere;
    private Controleur controleur;
    private JPopupMenu popupMenu;
    private JLabel labelMenu;
    private Frise frise;

    public PanelMere(FenetreMere parFenetreMere) {
        this.setLayout(new CardLayout());
        panelCrea = new PanelCreation();
        panelAff = new PanelAffichage();
        fenetreMere = parFenetreMere;
        controleur = new Controleur(panelCrea, panelAff);


        this.add("Création",panelCrea);
        this.add("Affichage",panelAff);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(fenetreMere.getItemCreation()))
            ((CardLayout) getLayout()).show(this,"Creation");

        if(e.getSource().equals(fenetreMere.getItemAffichage()))
            ((CardLayout) getLayout()).show(this,"Affichage");

        if(e.getSource().equals(fenetreMere.getItemFermer())) {
            int quitter = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter l'application ?", "Fermer", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (quitter == JOptionPane.OK_OPTION)
                fenetreMere.dispose();
        }
    }
}
