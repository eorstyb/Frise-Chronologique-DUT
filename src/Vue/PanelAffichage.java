package Vue;

import javax.swing.*;
import Controleur.Controleur;
import Modele.Agenda;
import Modele.Date;
import Modele.Evenement;

import javax.swing.JPanel;

public class PanelAffichage extends JPanel {
    //champs
    private PanelEvenement panelEvenement;
    private PanelFrise panelFrise;


    //constructeur
    public PanelAffichage() {

        Agenda agenda = new Agenda();
        agenda.ajout(new Evenement(new Date(16,3,2020),"Confinement","<br>waw<br>" ,"images/confinement.jpg", 3));


        panelEvenement = new PanelEvenement(agenda);
        panelFrise = new PanelFrise();
        this.add(panelEvenement);
        this.add(panelFrise);
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
