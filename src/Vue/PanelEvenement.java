package Vue;

import Modele.Date;
import Modele.Evenement;
import javax.swing.*;

public class PanelEvenement extends JPanel {

    //champs
    private Evenement evenement;
    private JLabel titre;
    private JLabel date;
    private JLabel description;
    private ImageIcon image;
    private JLabel labelImage;

    public PanelEvenement(Evenement parEvenement) {
        evenement = parEvenement;
        titre = new JLabel(evenement.getTitre());
        date = new JLabel(evenement.getDate().toString());
        description = new JLabel(evenement.getDescription());
        image = new ImageIcon(evenement.getChemin_image());
        labelImage = new JLabel(image);

        this.add(labelImage);
        this.add(titre);
        this.add(date);
        this.add(description);
    }

    //getter
    public Date getEvenementDate(){ return evenement.getDate();}
}

