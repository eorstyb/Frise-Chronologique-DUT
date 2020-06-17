package Modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Un agenda qui contient des évenéments
 * @see Evenement
 */
public class Agenda implements Serializable {

    /**
     * Un tableau d'événements
     * Il est possible d'ajouter des événements, de chercher un événement, de faire des tris etc
     *
     * @see Agenda#ajout(Evenement)
     * @see Agenda#sort()
     * @see Agenda#triInsertion()
     */
    private Evenement[] tabEvenements = new Evenement[15];


    private static final long serialVersionUID = 2565864553245L;

    /**
     * Entier permettant de connaître le nombre d'événements dans l'objet agenda
     */
    private int nbEvenements = 0;

    /**
     * Une ArrayList d'événements
     * @see Agenda#fusion(ArrayList, ArrayList)
     */
    ArrayList<Evenement> listEvenements = new ArrayList();

    /**
     * Constructeur de la classe Agenda vide car les champs sont déjà instanciés
     */
    public Agenda() {
    }

    /**
     * Méthode d'ajout d'un événement dans le tableau d'événements et dans l'ArrayList
     *
     * @param parEvt l'événement à ajouter
     * @see Agenda#tabEvenements
     * @see Agenda#listEvenements
     */
    public void ajout(Evenement parEvt) {
        this.tabEvenements[this.nbEvenements++] = parEvt;
        this.listEvenements.add(parEvt);
    }

    /**
     * Vérifie si un événement appartient à l'agenda
     *
     * @param parEvt l'événement a chercher
     * @return l'indice dans le tableau si l'événement a été trouvé sinon retourne -1
     */
    public int getEvenement(Evenement parEvt) {
        int indice = 0;
        boolean trouve = false;

        while (!trouve && indice < this.nbEvenements) {
            if (this.tabEvenements[indice].compareTo(parEvt) == 0) {
                trouve = true;
            } else {
                ++indice;
            }
        }
        return trouve ? indice : -1;
    }

    /**
     * Retourne l'agenda sous forme de texte
     *
     * @return une chaîne de caractères
     */
    public String toString() {
        String chaine = "";

        for (int i = 0; i < this.nbEvenements; ++i) {
            chaine = chaine + this.tabEvenements[i].toString() + "\n";
        }

        return chaine;
    }

    /**
     * Fait un tri par insertion sur le tableau d'événements
     *
     * @see Agenda#tabEvenements
     */
    public void triInsertion() {
        for (int i = 1; i < this.nbEvenements; ++i) {
            Evenement aInserer = this.tabEvenements[i];

            int j;
            for (j = i; j > 0 && this.tabEvenements[j - 1].compareTo(aInserer) > 0; --j) {
                this.tabEvenements[j] = this.tabEvenements[j - 1];
            }

            this.tabEvenements[j] = aInserer;
        }

    }

    /**
     * Tri le tableau d'événements
     */
    public void sort() {
        Arrays.sort(this.tabEvenements);
    }

    /**
     * Renvoie le nombre d'événements dans l'agenda
     *
     * @return un entier
     */
    public int getLongueur() {
        return tabEvenements.length;
    }

    /**
     * Fait un tri fusion sur le tableau d'événements grâce à une méthode triFusion
     *
     * @see Agenda#triFusion(Comparable[], int, int)
     */
    public void triFusion() {
        Object[] obj = this.triFusion((Comparable[]) this.tabEvenements, 0, this.nbEvenements).toArray();
        this.tabEvenements = Arrays.copyOf(obj, obj.length, Evenement[].class);
    }

    /**
     * Fait un tri fusion sur le tableau donné en paramètre et retourne une ArrayList
     *
     * @param tab         le tableau d'événements
     * @param indiceDebut l'indice de début
     * @param longueur    la longueur du tableau
     * @return une ArrayList
     * @see Agenda#listEvenements
     * @see Agenda#fusion(ArrayList, ArrayList)
     */
    public ArrayList<Comparable> triFusion(Comparable[] tab, int indiceDebut, int longueur) {
        if (longueur == 1) {
            ArrayList<Comparable> arrayList = new ArrayList();
            arrayList.add(tab[indiceDebut]);
            return arrayList;
        } else {
            return this.fusion(this.triFusion(tab, indiceDebut, longueur / 2), this.triFusion(tab, indiceDebut + longueur / 2, longueur - longueur / 2));
        }
    }

    /**
     * Fusionne deux listes
     *
     * @param liste1 Première liste à fusionner
     * @param liste2 Deuxième liste à fusionner
     * @return une Arraylist
     */
    public ArrayList<Comparable> fusion(ArrayList<Comparable> liste1, ArrayList<Comparable> liste2) {
        if (liste1.isEmpty()) {
            return liste2;
        } else if (liste2.isEmpty()) {
            return liste1;
        } else {
            new ArrayList();
            Comparable premierDeListe1 = liste1.get(0);
            Comparable premierDeListe2 = liste2.get(0);
            ArrayList arrayList;
            if (premierDeListe1.compareTo(premierDeListe2) <= 0) {
                liste1.remove(0);
                arrayList = this.fusion(liste1, liste2);
                arrayList.add(0, premierDeListe1);
            } else {
                liste2.remove(0);
                arrayList = this.fusion(liste1, liste2);
                arrayList.add(0, premierDeListe2);
            }

            return arrayList;
        }
    }

    public Evenement[] getTabEvenements() {
        return tabEvenements;
    }

    public ArrayList<Evenement> getListEvenements() {
        return listEvenements;
    }
}