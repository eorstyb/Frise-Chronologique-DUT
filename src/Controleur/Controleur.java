package Controleur;

import Vue.PanelAffichage;
import Vue.PanelCreation;
import Vue.PanelFormulaire;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
    //champs
    PanelCreation panelCreation;
    PanelAffichage panelAffichage;

    //constructeur
    public Controleur(PanelCreation parPanelCreation, PanelAffichage parPanelAffichage) {
        panelCreation = parPanelCreation;
        panelAffichage = parPanelAffichage;
        panelCreation.enregistreEcouteur(this);
        panelAffichage.enregistreEcouteur(this);
    }

    //méthodes
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panelCreation.getValider()) {
        }
    }
}
