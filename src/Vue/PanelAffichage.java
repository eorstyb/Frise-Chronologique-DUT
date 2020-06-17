package Vue;

import javax.swing.*;
import Controleur.Controleur;
import Modele.Agenda;
import Modele.Date;
import Modele.Evenement;
import Modele.Frise;

import javax.swing.JPanel;

public class PanelAffichage extends JPanel {
    //champs
    private PanelDiapo panelDiapo;
    private PanelFrise panelFrise;
    private Frise frise;
    private Agenda agenda;
    private Controleur controleur;

    //constructeur
    public PanelAffichage() {

    }
    public PanelAffichage(Frise parFrise) {
        frise = parFrise;
        agenda = frise.getAgenda();
        agenda.ajout(new Evenement(new Date(16,3,2020),"Confinement","<html><br>waw<br></html>" ,"images/confinement.jpg", 3));
        panelDiapo = new PanelDiapo(agenda,this);
        panelFrise = new PanelFrise(frise,this);
        enregistreEcouteur(controleur);
        this.add(panelDiapo);
        this.add(panelFrise);
    }

    public void setFrise(Frise parFrise) {
        frise = parFrise;
        agenda = frise.getAgenda();
        panelDiapo = new PanelDiapo(agenda, this);
    }

    //méthodes
    public void enregistreEcouteur(Controleur controleur){
        this.controleur = controleur;
        panelDiapo.enregistreEcouteur(controleur);
        panelFrise.enregistreEcouteur(controleur);
    }

    public PanelDiapo getPanelDiapo() {
        return panelDiapo;
    }

    public PanelFrise getPanelFrise() {
        return panelFrise;
    }


}