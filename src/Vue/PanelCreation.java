package Vue;

import Controleur.Controleur;
import Modele.*;

import javax.swing.*;
import java.awt.*;

public class PanelCreation extends JPanel {
    //champs
    private JLabel labelTitre = new JLabel("Création de la frise");
    private PanelFormulaire panelForm;
    private String cheminFichierSauvegarde;
    private JLabel labelIntitule = new JLabel("Intitulé");
    private JTextField entreeIntitule = new JTextField(5);
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

    //constructeur
    public PanelCreation() {
        setLayout(new GridBagLayout());
        GridBagConstraints contrainte = new GridBagConstraints();
        contrainte.fill = 1;
        contrainte.insets = new Insets(20, 20, 20, 25);
        contrainte.anchor = 20;
        contrainte.gridx = 0;
        contrainte.gridy = 0;
        contrainte.gridheight = 1;
        contrainte.gridwidth = 5;
        this.add(labelTitre, contrainte);
        contrainte.gridx = 0;
        contrainte.gridy = 1;
        contrainte.gridwidth = 1;
        this.add(labelIntitule, contrainte);
        contrainte.gridx = 2;
        contrainte.gridwidth = 5;
        this.add(entreeIntitule, contrainte);
        contrainte.gridx = 0;
        contrainte.gridy = 2;
        this.add(labelDateDebut, contrainte);

        for(int i = 1; i < 32; i++) {
            jourDebut.addItem(i);
            jourFin.addItem(i);
        }
        jourDebut.setPreferredSize(new Dimension(100,0));
        contrainte.gridx = 3;
        this.add(jourDebut, contrainte);

        for(int i = 0; i < 12; i++) {
            moisDebut.addItem(MOIS[i]);
            moisFin.addItem(MOIS[i]);
        }
        contrainte.gridx = 6;
        this.add(moisDebut, contrainte);

        for(int i = 2000; i < 2021; i++) {
            anneeDebut.addItem(i);
            anneeFin.addItem(i);
        }
        contrainte.gridx = 15;
        this.add(anneeDebut, contrainte);

        contrainte.gridx = 0;
        contrainte.gridy = 3;
        this.add(labelDateFin, contrainte);

        contrainte.gridx = 3;
        this.add(jourFin, contrainte);

        contrainte.gridx = 6;
        this.add(moisFin, contrainte);

        contrainte.gridx = 15;
        this.add(anneeFin, contrainte);

        contrainte.gridy = 4;
        contrainte.gridx = 0;
        this.add(labelCheminFichier, contrainte);

        contrainte.gridy = 5;
        contrainte.gridx = 0;
        this.add(entreeCheminFichier);

        contrainte.gridy = 6;
        contrainte.gridx = 8;
        this.add(valider, contrainte);

        this.labelCheminFichier.setLabelFor(entreeCheminFichier);
        this.labelDateDebut.setLabelFor(jourDebut);
        this.labelDateFin.setLabelFor(jourFin);
        this.labelIntitule.setLabelFor(entreeIntitule);
    }

    //méthodes
    public void enregistreEcouteur(Controleur controleur) {
        getValider().addActionListener(controleur);
    }

    public JButton getValider() {
        return valider;
    }

    public JTextField getEntreeIntitule() {
        return entreeIntitule;
    }
}

/*    À l’aide d’un formulaire l’utilisateur saisit les données générales qui décrivent la chronologie (intitulé, dates,
        période, adresse du fichier de sauvegarde), puis les données particulières qui décrivent chaque événement :
        titre, date, adresse du fichier image, texte descriptif, poids (le poids de l’événement représente son importance
        dans la chronologie, il correspond dans la table à l’indice de la ligne à laquelle l’événement est affiché, plus
        un poids est élevé, plus l’indice de la ligne est bas, proche de l’en-tête).
*/