package Controleur;

import Constants.Constantes;
import Modele.Date;
import Modele.Evenement;
import Vue.PanelAffichage;
import Vue.PanelCreation;
import Vue.PanelFormulaire;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
    //champs
    PanelCreation panelCreation;
    PanelAffichage panelAffichage;
    Date dateDebut;
    Date dateFin;
    String intitule;
    String cheminFichier;
    //Agenda agenda;

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
            dateDebut = new Date(panelCreation.getJourDebut().getSelectedIndex(),
                    panelCreation.getMoisDebut().getSelectedIndex(),
                    panelCreation.getAnneeDebut().getItemAt(panelCreation.getAnneeDebut().getSelectedIndex()));
            Constantes.DATEDEBUT = dateDebut;

            dateFin  = new Date(panelCreation.getJourFin().getSelectedIndex(),
                    panelCreation.getMoisFin().getSelectedIndex(),
                    panelCreation.getAnneeFin().getItemAt(panelCreation.getAnneeFin().getSelectedIndex()));
            Constantes.DATEFIN = dateFin;

            intitule = panelCreation.getEntreeIntitule().getText();
            Constantes.INTITULEFRISE = intitule;

            cheminFichier = panelCreation.getEntreeCheminFichier().getText();
            Constantes.CHEMINFICHIER = cheminFichier;

            panelCreation.showFormulaire(this);
        }

        if(e.getSource() == panelCreation.getPanelForm().getValider()) {
            Date dateEvt = new Date(panelCreation.getPanelForm().getEntreeJour().getSelectedIndex(),
                    panelCreation.getPanelForm().getEntreeMois().getSelectedIndex(),
                    panelCreation.getPanelForm().getEntreeAnnee().getItemAt(panelCreation.getPanelForm().getEntreeAnnee().getSelectedIndex()));

            Evenement evt = new Evenement(dateEvt, panelCreation.getPanelForm().getEntreeNomEvenement().getText(),
                    panelCreation.getPanelForm().getEntreeDescription().getText(), panelCreation.getPanelForm().getEntreeCheminImage().getText(),
                    panelCreation.getPanelForm().getEntreePoids().getItemAt(panelCreation.getPanelForm().getEntreePoids().getSelectedIndex()));
        }
    }
}
