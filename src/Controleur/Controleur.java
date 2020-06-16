package Controleur;

import Modele.Agenda;
import Modele.Date;
import Modele.Evenement;
import Modele.Frise;
import Vue.PanelAffichage;
import Vue.PanelCreation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
    //champs
    private PanelCreation panelCreation;
    private PanelAffichage panelAffichage;
    private Date dateDebut;
    private Date dateFin;
    private String intitule;
    private String cheminFichier;
    private Frise frise;

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

            dateFin  = new Date(panelCreation.getJourFin().getSelectedIndex(),
                    panelCreation.getMoisFin().getSelectedIndex(),
                    panelCreation.getAnneeFin().getItemAt(panelCreation.getAnneeFin().getSelectedIndex()));

            intitule = panelCreation.getEntreeIntitule().getText();

            cheminFichier = panelCreation.getEntreeCheminFichier().getText();

            frise = new Frise(new Agenda(), dateDebut, dateFin, intitule, cheminFichier);
            panelCreation.setFrise(frise);
            panelCreation.showFormulaire(this);
        }

        if(e.getSource() == panelCreation.getPanelForm().getValider()) {
            Date dateEvt = new Date(panelCreation.getPanelForm().getEntreeJour().getSelectedIndex(),
                    panelCreation.getPanelForm().getEntreeMois().getSelectedIndex(),
                    panelCreation.getPanelForm().getEntreeAnnee().getItemAt(panelCreation.getPanelForm().getEntreeAnnee().getSelectedIndex()));

            Evenement evt = new Evenement(dateEvt, panelCreation.getPanelForm().getEntreeNomEvenement().getText(),
                    panelCreation.getPanelForm().getEntreeDescription().getText(), panelCreation.getPanelForm().getEntreeCheminImage().getText(),
                    panelCreation.getPanelForm().getEntreePoids().getItemAt(panelCreation.getPanelForm().getEntreePoids().getSelectedIndex()));

            frise.getAgenda().ajout(evt);
        }
    }
}
