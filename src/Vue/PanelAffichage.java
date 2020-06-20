package Vue;

import Controleur.Controleur;
import Modele.Agenda;
import Modele.Date;
import Modele.Evenement;
import Modele.Frise;

import javax.swing.JPanel;

import static Vue.Constantes.SOBRE;

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
        this.setBackground(SOBRE);
        frise = parFrise;
        agenda = frise.getAgenda();
        panelDiapo = new PanelDiapo(frise,this);
        panelFrise = new PanelFrise(frise,this);
        enregistreEcouteur(controleur);
        this.add(panelDiapo);
        this.add(panelFrise);
    }

    public void setFrise(Frise parFrise) {
        frise = parFrise;
        agenda = frise.getAgenda();
        panelDiapo = new PanelDiapo(frise, this);
        panelFrise = new PanelFrise(frise, this);
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