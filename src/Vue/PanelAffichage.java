package Vue;

import javax.swing.*;
import Controleur.Controleur;
import javax.swing.JPanel;

public class PanelAffichage extends JPanel {
    //champs
    private JLabel intituleFrise;
    private PanelEvenement panelEvenement;
    private PanelFrise panelFrise;


    //constructeur
    public PanelAffichage() {
        panelEvenement = new PanelEvenement();
        panelFrise = new PanelFrise();
        //intituleFrise = getEntreeIntitule();
        //this.add(intituleFrise);
        this.add(panelEvenement);
        this.add(panelFrise);
    }

    public JLabel getIntituleFrise() {
        return intituleFrise;
    }

    public Vue.PanelEvenement getPanelEvenement() {
        return panelEvenement;
    }

    public Vue.PanelFrise getPanelFrise() {
        return panelFrise;
    }

    //méthodes
    public void enregistreEcouteur(Controleur controleur){

    }
}
