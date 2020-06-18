package Controleur;

import Modele.*;
import Vue.PanelAffichage;
import Vue.PanelCreation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Controleur implements ActionListener {
    //champs
    private PanelCreation panelCreation;
    private PanelAffichage panelAffichage;
    private Date dateDebut;
    private Date dateFin;
    private String intitule;
    private String cheminFichier;
    private Frise frise;
    private Frise[] tabFrises = new Frise[20];
    private File fichier;

    //constructeur
    public Controleur(PanelCreation parPanelCreation, PanelAffichage parPanelAffichage) {
        panelCreation = parPanelCreation;
        panelAffichage = parPanelAffichage;
        panelCreation.enregistreEcouteur(this);
    }

    public Controleur(Frise[] parTabFrises, Frise parFrise, PanelCreation parPanelCreation, PanelAffichage parPanelAffichage) {
        tabFrises = parTabFrises;
        frise = parFrise;
        fichier = new File(frise.getCheminFichier());
        panelCreation = parPanelCreation;
        panelAffichage = parPanelAffichage;
        panelCreation.enregistreEcouteur(this);
        panelAffichage.enregistreEcouteur(this);
    }

    //méthodes
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panelCreation.getValider()) {
            dateDebut = new Date(panelCreation.getJourDebut().getSelectedIndex() + 1,
                    panelCreation.getMoisDebut().getSelectedIndex() + 1,
                    panelCreation.getAnneeDebut().getItemAt(panelCreation.getAnneeDebut().getSelectedIndex()));

            dateFin  = new Date(panelCreation.getJourFin().getSelectedIndex() + 1,
                    panelCreation.getMoisFin().getSelectedIndex() + 1,
                    panelCreation.getAnneeFin().getItemAt(panelCreation.getAnneeFin().getSelectedIndex()));

            intitule = panelCreation.getEntreeIntitule().getText();
            cheminFichier = panelCreation.getEntreeCheminFichier().getText();
            frise = new Frise(new Agenda(), dateDebut, dateFin, intitule, cheminFichier);
            fichier = new File(frise.getCheminFichier());
            int i = 0;
            while(tabFrises[i] != null)
                i += 1;
            tabFrises[i] = frise;
            panelAffichage = new PanelAffichage(frise);
            panelAffichage.enregistreEcouteur(this);
            LectureEcriture.ecriture(fichier, tabFrises);
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
            LectureEcriture.ecriture(fichier, tabFrises);
            panelAffichage.setFrise(frise);
        }
    }
}
