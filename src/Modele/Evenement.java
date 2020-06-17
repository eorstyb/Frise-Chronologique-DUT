package Modele;

import java.io.Serializable;

public class Evenement implements Serializable {
    //champs
    private Date date;
    private String titre;
    private String description;
    private String chemin_image;
    private int poids;

    //constructeur
    public Evenement(Date parDate, String parTitre, String parDescription, String parChemin_image, int parPoids) {
        date = parDate;
        titre = parTitre;
        description = parDescription;
        chemin_image = parChemin_image;
        poids = parPoids;
    }

    public int compareTo(Evenement parEvt) {
        int precede = this.date.compareTo(parEvt.date);
        return precede == 0 ? (this.titre).compareTo(parEvt.titre): precede;
    }

    public Date getDate() { return date;}

    public String getTitre(){ return titre;}

    public String getChemin_image() {
        return chemin_image;
    }

    public String getDescription(){ return description;}


    //méthodes
}
