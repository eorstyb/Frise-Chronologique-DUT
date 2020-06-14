package Modele;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * La classe Date permet de construire une date
 */
public class Date {
    //champs
    private int jour;
    private int mois;
    private int annee;
    private int jourSemaine;

//constructeurs

    public Date(Date date){
        GregorianCalendar today = new GregorianCalendar ();
        annee = today.get (Calendar.YEAR);
        mois = today.get (Calendar.MONTH)+1;
        jour = today.get (Calendar.DAY_OF_MONTH);
        jourSemaine = today.get (Calendar.DAY_OF_WEEK)-1;
    }

    public Date(int parJour, int parMois, int parAnnee) {
        jour = parJour;
        mois = parMois;
        annee = parAnnee;
    }

    /**
     * retourne la date du lendemain de la date courante
     * @return une date
     */
    public Date dateDuLendemain ()   {
        if (jour < dernierJourDuMois(mois,annee))
            return  new Date (jour+1,mois,annee);
        else if (mois < 12)
            return new Date (1,mois+1,annee);
        else return new Date (1,1,annee+1);
    }

    /**
     * retourne le premier jour de la semaine contenant la date courante
     * @return une date
     */
    public Date dateDeLaVeille () {
        if (jour > 1)
            return  new Date (jour-1,mois,annee);
        else if (mois > 1)
            return new Date (Date.dernierJourDuMois(mois-1, annee),mois-1,annee);
        else return  new Date (31,12,annee-1);
    }

    /**
     * permet de retourner le dernier jour selon le mois et l'année donnés.
     * @param parMois le mois choisi
     * @param parAnnee l'année choisi
     * @return un entier
     */
    public static int dernierJourDuMois (int parMois, int parAnnee) {
        switch (parMois) {
            case 2 : if (estBissextile (parAnnee))  return 29 ; else return 28 ;
            case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
            default : return 31 ;
        }  // switch
    }

    /**
     * retourner un booléen afin de savoir si l'année en paramètre est une
     * année bissextile.
     * @param parAnnee Année selectionnée
     * @return un booléen
     */
    private static boolean estBissextile(int parAnnee) {
        return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
    }

    /**
     *
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
