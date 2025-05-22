package controleur;

import java.time.LocalDate;
import java.time.LocalTime;
import modele.Evenement;
import modele.Operateur;

public class AjoutEvenementControleur {

    public void creerEvenement(String dateStr, String heureStr, String dureeStr, Operateur o, String cause) throws Exception {
        try {
            LocalDate date = LocalDate.parse(dateStr);
            LocalTime heure = LocalTime.parse(heureStr);
            int duree = Integer.parseInt(dureeStr);

            //if (id == null || id.isEmpty()) {
           //     throw new Exception("L'identifiant ne peut pas être vide.");
            //}

            // Création de la machine
            Evenement e = new Evenement(date, heure, duree, o, cause);

            // Ici tu peux ajouter la machine à une liste ou base de données

            // Message console utile pour debug
            System.out.println("Évènement créé : " + e);

        } catch (NumberFormatException e) {
            throw new Exception("Veuillez entrer des valeurs valides");
        }
    }
}