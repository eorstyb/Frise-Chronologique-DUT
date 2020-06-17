package Modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * La classe Date permet de construire une date
 */
public class Date implements Serializable {
    //champs
    private static final long serialVersionUID = 5789866515461L;
    private int jour;
    private int mois;
    private int annee;
    private int jourSemaine;

//constructeurs

    public Date() {
        GregorianCalendar today = new GregorianCalendar();
        annee = today.get(Calendar.YEAR);
        mois = today.get(Calendar.MONTH) + 1;
        jour = today.get(Calendar.DAY_OF_MONTH);
        jourSemaine = today.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public Date(int parJour, int parMois, int parAnnee) {
        jour = parJour;
        mois = parMois;
        annee = parAnnee;
    }

    /**
     * retourne la date du lendemain de la date courante
     *
     * @return une date
     */
    public Date dateDuLendemain() {
        if (jour < dernierJourDuMois(mois, annee))
            return new Date(jour + 1, mois, annee);
        else if (mois < 12)
            return new Date(1, mois + 1, annee);
        else return new Date(1, 1, annee + 1);
    }

    /**
     * retourne le premier jour de la semaine contenant la date courante
     *
     * @return une date
     */
    public Date dateDeLaVeille() {
        if (jour > 1)
            return new Date(jour - 1, mois, annee);
        else if (mois > 1)
            return new Date(Date.dernierJourDuMois(mois - 1, annee), mois - 1, annee);
        else return new Date(31, 12, annee - 1);
    }

    public String toString () {
        String chaine = new String();
        switch (jourSemaine) {
            case 7: chaine = "dimanche"; break;
            case 1: chaine = "lundi"; break;
            case 2: chaine = "mardi"; break;
            case 3: chaine = "mercredi"; break;
            case 4: chaine = "jeudi"; break;
            case 5: chaine = "vendredi"; break;
            case 6: chaine = "samedi"; break;
        }
        chaine += " " + jour + " ";
        switch (mois) {
            case 1: chaine += "janvier"; break;
            case 2: chaine += "février"; break;
            case 3: chaine += "mars"; break;
            case 4: chaine += "avril"; break;
            case 5: chaine += "mai"; break;
            case 6: chaine += "juin"; break;
            case 7: chaine += "juillet"; break;
            case 8: chaine += "août"; break;
            case 9: chaine += "septembre"; break;
            case 10: chaine += "octobre"; break;
            case 11: chaine += "novembre"; break;
            case 12: chaine += "décembre"; break;
        }
        chaine += " " + annee;
        return chaine;
    }

    /**
     * permet de retourner le dernier jour selon le mois et l'année donnés.
     *
     * @param parMois  le mois choisi
     * @param parAnnee l'année choisi
     * @return un entier
     */
    public static int dernierJourDuMois(int parMois, int parAnnee) {
        switch (parMois) {
            case 2:
                if (estBissextile(parAnnee)) return 29;
                else return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }  // switch
    }

    /**
     * retourner un booléen afin de savoir si l'année en paramètre est une
     * année bissextile.
     *
     * @param parAnnee Année selectionnée
     * @return un booléen
     */
    private static boolean estBissextile(int parAnnee) {
        return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
    }

    /**
     * @return
     */

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public int getJourSemaine() {
        return jourSemaine;
    }


    //méthodes
    public int compareTo(Date parDate) {
        if (annee < parDate.annee)
            return -1;
        if (annee > parDate.annee)
            return 1;
        // les ann�es sont =
        if (mois < parDate.mois)
            return -1;
        if (mois > parDate.mois)
            return 1;
        // les mois sont =
        if (jour < parDate.jour)
            return -1;
        if (jour > parDate.jour)
            return 1;
        return 0;
    }
}