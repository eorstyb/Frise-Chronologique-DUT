package Modele;

public class Evenement {
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

    //méthodes
}
