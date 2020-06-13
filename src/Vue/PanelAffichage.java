package Vue;

<<<<<<< HEAD
import javax.swing.*;
=======
import Controleur.Controleur;

import javax.swing.JPanel;
>>>>>>> 67db57f1647fb3930f570639ad14f8d6373946c2

public class PanelAffichage extends JPanel {
    //champs
    private JLabel intituleFrise;
    private PanelEvenement panelEvenement;
    private PanelFrise panelFrise;


    //constructeur
    public PanelAffichage() {
        panelEvenement = new PanelEvenement();
        panelFrise = new PanelFrise();
        intituleFrise =
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
