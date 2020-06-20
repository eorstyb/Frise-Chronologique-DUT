package Vue;

import Modele.Date;
import Modele.Evenement;
import javax.swing.*;
import java.awt.*;

import static Vue.Constantes.TITRE;

public class PanelEvenement extends JPanel {

    //champs
    private Evenement evenement;
    private JLabel titre;
    private JLabel date;
    private JLabel description;
    private JLabel labelImage;

    public PanelEvenement(Evenement parEvenement) {
        this.setLayout(new GridBagLayout());
        JPanel panelWest = new JPanel();
        panelWest.setLayout(new GridBagLayout());
        GridBagConstraints constraints1 = new GridBagConstraints();
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints1.insets = new Insets(10,15,10,15);
        constraints2.insets = new Insets(10,15,10,15);
        evenement = parEvenement;
        titre = new JLabel(evenement.getTitre());
        titre.setFont(TITRE);
        date = new JLabel(evenement.getDate().toString());
        description = new JLabel(evenement.getDescription());
        description.setPreferredSize(new Dimension(200,100));
        labelImage = new JLabel();
        labelImage.setIcon(new ImageIcon(new ImageIcon(evenement.getChemin_image()).getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT)));

        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.anchor = GridBagConstraints.LINE_START;
        this.add(labelImage,constraints1);

        constraints1.gridx = 1;
        constraints1.gridy = 0;
        constraints1.anchor = GridBagConstraints.LINE_START;
        this.add(panelWest,constraints1);

        constraints2.gridx = 0;
        constraints2.gridy = 0;
        constraints2.anchor = GridBagConstraints.LINE_START;
        panelWest.add(titre,constraints2);

        constraints2.gridy = 1;
        constraints2.gridwidth = 2;
        panelWest.add(date,constraints2);

        constraints2.gridy = 2;
        panelWest.add(description,constraints2);
    }

    //getter
    public Date getEvenementDate(){ return evenement.getDate();}
}

