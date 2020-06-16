package Vue;

import Modele.Agenda;
import Modele.Date;
import Modele.Evenement;

import javax.swing.*;

public class PanelEvenement extends JPanel {

    //champs
    private Evenement evenement;
    private JLabel titre;
    private Date date;
    private JLabel description;

    public PanelEvenement(Evenement parEvenement) {
        evenement = parEvenement;
        titre = new JLabel(evenement.getTitre());
        date = new Date(evenement.getDate());
        description = new JLabel(evenement.getDescription());
    }
}
