package controleur;

import modele.Operation;
import modele.Equipement;

public class AjoutOperationControleur {

    public void creerOperation(String ref, String des, String dureeStr, Equipement equipement) throws Exception {
        try {
        int duree = Integer.parseInt(dureeStr);

        if (ref == null || ref.isEmpty()) {
            throw new Exception("La référence ne peut pas être vide.");
        }

        if (equipement == null) {
            throw new Exception("Veuillez sélectionner un équipement valide.");
        }

        Operation o = new Operation(ref, des, duree, equipement);
        System.out.println("Opération créée : " + o);

        } catch (NumberFormatException e) {
            throw new Exception("Veuillez entrer une valeur valide pour la durée.");
        }
    }
}

