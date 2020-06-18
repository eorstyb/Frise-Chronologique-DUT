package Vue;

import Modele.Date;
import Modele.Evenement;
import javax.swing.*;
import java.awt.*;

public class PanelEvenement extends JPanel {

    //champs
    private Evenement evenement;
    private JLabel titre;
    private JLabel date;
    private JLabel description;
    private JLabel labelImage;

    public PanelEvenement(Evenement parEvenement) {
        this.setLayout(new BorderLayout());
        evenement = parEvenement;
        titre = new JLabel(evenement.getTitre());
        date = new JLabel(evenement.getDate().toString());
        description = new JLabel(evenement.getDescription());
        labelImage = new JLabel();
        labelImage.setIcon(new ImageIcon(new ImageIcon(evenement.getChemin_image()).getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT)));


        this.add(labelImage,BorderLayout.WEST);
        this.add(titre,BorderLayout.EAST);
        this.add(date,BorderLayout.EAST);
        this.add(description,BorderLayout.EAST);
    }

    //getter
    public Date getEvenementDate(){ return evenement.getDate();}
}

