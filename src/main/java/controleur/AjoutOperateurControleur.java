package controleur;

import modele.Operateur;

public class AjoutOperateurControleur {

    public void creerOperateur(String id, String nom, String prenom) throws Exception {
        try {
            if (id == null || id.isEmpty()) {
                throw new Exception("Veuillez rentrer un identifiant.");
            }
            if (nom == null || nom.isEmpty()) {
                throw new Exception("Veuillez rentrer un nom.");
            }
            if (prenom == null || prenom.isEmpty()) {
                throw new Exception("Veuiller rentrer un prénom.");
            }

            
            // Création de la machine
            Operateur o = new Operateur(id, nom, prenom);

            // Ici tu peux ajouter la machine à une liste ou base de données

            // Message console utile pour debug
            System.out.println("Operateur créé : " + o);

        } catch (NumberFormatException e) {
            throw new Exception("Veuillez entrer des valeurs numériques valides pour coût, x et y.");
        }
    }
}

