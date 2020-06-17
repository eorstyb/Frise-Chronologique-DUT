package Vue;

import Controleur.Controleur;
import Modele.*;

import javax.swing.*;
import java.awt.*;

public class PanelCreation extends JPanel {
    //
    private PanelFormulaire panelForm;
    private JLabel labelTitre = new JLabel("Création de la frise");
    private String cheminFichierSauvegarde;
    private JLabel labelIntitule = new JLabel("Intitulé");
    private JTextField entreeIntitule = new JTextField(15);
    private JLabel labelDateDebut = new JLabel("Date de début");
    private JComboBox<Integer> jourDebut = new JComboBox<Integer>();
    private JComboBox<String> moisDebut = new JComboBox<String>();
    private JComboBox<Integer> anneeDebut = new JComboBox<Integer>();
    private JLabel labelDateFin = new JLabel("Date de fin");
    private JComboBox<Integer> jourFin = new JComboBox<Integer>();
    private JComboBox<String> moisFin = new JComboBox<String>();
    private JComboBox<Integer> anneeFin = new JComboBox<Integer>();
    private JLabel labelCheminFichier = new JLabel("Chemin du fichier de sauvegarde");
    private JTextField entreeCheminFichier = new JTextField(15);
    private JButton valider = new JButton("Valider");
    private String[] MOIS = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
    private Frise frise;

    //constructeur
    public PanelCreation(Frise frise, Controleur controleur) {
        panelForm = new PanelFormulaire(frise);
        this.add(panelForm);
        enregistreEcouteur(controleur);
    }

    public PanelCreation() {
        setLayout(new GridBagLayout());
        GridBagConstraints contrainte = new GridBagConstraints();
        contrainte.insets = new Insets(20, 20, 20, 20);

        contrainte.gridx = 0;
        contrainte.gridy = 0;
        contrainte.anchor = GridBagConstraints.CENTER;
        this.add(labelTitre, contrainte);

        contrainte.gridx = 0;
        contrainte.gridy = 1;
        contrainte.anchor = GridBagConstraints.LINE_START;
        this.add(labelIntitule, contrainte);

        contrainte.gridx = 1;
        contrainte.gridwidth=3;
        this.add(entreeIntitule, contrainte);

        contrainte.gridx = 0;
        contrainte.gridy = 2;
        contrainte.gridwidth=1;
        contrainte.anchor = GridBagConstraints.LINE_START;
        this.add(labelDateDebut, contrainte);

        for(int i = 1; i < 32; i++) {
            jourDebut.addItem(i);
            jourFin.addItem(i);
        }
        contrainte.gridx = 1;
        this.add(jourDebut, contrainte);

        for(int i = 0; i < 12; i++) {
            moisDebut.addItem(MOIS[i]);
            moisFin.addItem(MOIS[i]);
        }
        contrainte.gridx = 2;
        this.add(moisDebut, contrainte);

        for(int i = 2000; i < 2021; i++) {
            anneeDebut.addItem(i);
            anneeFin.addItem(i);
        }
        contrainte.gridx = 3;
        contrainte.anchor = GridBagConstraints.LINE_END;
        this.add(anneeDebut, contrainte);

        contrainte.gridx = 0;
        contrainte.gridy = 3;
        contrainte.anchor = GridBagConstraints.LINE_START;
        this.add(labelDateFin, contrainte);

        contrainte.gridx = 1;
        this.add(jourFin, contrainte);

        contrainte.gridx = 2;
        this.add(moisFin, contrainte);

        contrainte.gridx = 3;
        contrainte.anchor = GridBagConstraints.LINE_END;
        this.add(anneeFin, contrainte);

        contrainte.gridy = 4;
        contrainte.gridx = 0;
        contrainte.anchor = GridBagConstraints.LINE_START;
        this.add(labelCheminFichier, contrainte);

        contrainte.gridy = 4;
        contrainte.gridx = 1;
        contrainte.gridwidth=3;
        this.add(entreeCheminFichier, contrainte);

        contrainte.gridy = 5;
        contrainte.gridx = 4;
        contrainte.anchor = GridBagConstraints.PAGE_END;
        contrainte.gridwidth=1;
        this.add(valider, contrainte);
    }


    public void showFormulaire(Controleur controleur) {
        panelForm = new PanelFormulaire(frise);
        this.removeAll();
        this.add(panelForm);
        panelForm.enregistreEcouteur(controleur);
        validate();
        repaint();
    }

    //méthodes
    public void enregistreEcouteur(Controleur controleur) {
        System.out.println("enregistreEcouteur");
        this.valider.addActionListener(controleur);
        if(panelForm != null)
            panelForm.getValider().addActionListener(controleur);
    }

    public JButton getValider() {
        return valider;
    }

    public JTextField getEntreeIntitule() {
        return entreeIntitule;
    }

    public JComboBox<Integer> getJourDebut() {
        return jourDebut;
    }

    public JComboBox<String> getMoisDebut() {
        return moisDebut;
    }

    public JComboBox<Integer> getAnneeDebut() {
        return anneeDebut;
    }

    public JComboBox<Integer> getJourFin() {
        return jourFin;
    }

    public JComboBox<String> getMoisFin() {
        return moisFin;
    }

    public JComboBox<Integer> getAnneeFin() {
        return anneeFin;
    }

    public JTextField getEntreeCheminFichier() {
        return entreeCheminFichier;
    }

    public PanelFormulaire getPanelForm() {
        return panelForm;
    }

    public void setFrise(Frise frise) {
        this.frise = frise;
    }
}