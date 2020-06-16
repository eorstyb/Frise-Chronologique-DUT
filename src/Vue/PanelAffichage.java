package Vue;

import javax.swing.*;
import Controleur.Controleur;
import Modele.Agenda;
import Modele.Date;
import Modele.Evenement;

import javax.swing.JPanel;

public class PanelAffichage extends JPanel {
    //champs
    private PanelDiapo panelDiapo;
    private PanelFrise panelFrise;


    //constructeur
    public PanelAffichage() {

        Agenda agenda = new Agenda();
        agenda.ajout(new Evenement(new Date(16,3,2020),"Confinement","<html><br>waw<br></html>" ,"images/confinement.jpg", 3));


        panelDiapo = new PanelDiapo(agenda);
        panelFrise = new PanelFrise();
        this.add(panelDiapo);
        this.add(panelFrise);
    }

    public PanelDiapo getPanelDiapo() {
        return panelDiapo;
    }

    public Vue.PanelFrise getPanelFrise() {
        return panelFrise;
    }

    //méthodes
    public void enregistreEcouteur(Controleur controleur){

    }
}
