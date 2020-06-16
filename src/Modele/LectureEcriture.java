package Modele;

import java.io.*;

/**
 * La classe LectureEcriture permet de lire un fichier ou d'écrire dans un fichier
 */
public class LectureEcriture {

    /**
     * Cette méthode renvoie la lecture du fichier de la classe File donnée en paramètre
     * @param parFichier le fichier à lire
     * @return un objet de la classe Objet
     */
    public static Object lecture (File parFichier) {
        ObjectInputStream flux;
        Object objetLu = null;

        // Ouverture du fichier en mode lecture

        try {
            flux = new ObjectInputStream(new FileInputStream(parFichier));
            objetLu = flux.readObject();
            flux.close();
        }

        catch (ClassNotFoundException | FileNotFoundException parException) {
            System.err.println(parException.toString());
            System.exit(1);
        }

        catch (IOException parException) {
            System.err.println("Erreur lecture du fichier " + parException.toString());
            System.exit(1);
        }

        return objetLu;
    }

    /**
     * Ecris dans un fichier
     * @param parFichier le fichier à modifier
     * @param parObjet l'objet à écrire dans le fichier
     */
    public static void ecriture (File parFichier, Object parObjet) {
        ObjectOutputStream flux = null;
        try {
            flux = new ObjectOutputStream(new FileOutputStream(parFichier));
            flux.writeObject(parObjet);
            flux.flush();
            flux.close();
        }

        catch (IOException parException) {
            System.err.println("Probleme a l'ecriture\n" + parException.toString());
            System.exit(1);
        }
    }
}