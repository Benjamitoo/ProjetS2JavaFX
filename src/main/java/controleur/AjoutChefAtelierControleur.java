package controleur;

import modele.ChefAtelier;

public class AjoutChefAtelierControleur {

    public void creerChefAtelier(String id, String nom, String prenom) throws Exception {
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
            ChefAtelier chefAtelier = new ChefAtelier(id, nom, prenom);

            // Ici tu peux ajouter la machine à une liste ou base de données

            // Message console utile pour debug
            System.out.println("Chef d'atelier créé : " + chefAtelier);

        } catch (NumberFormatException e) {
            throw new Exception("Veuillez entrer des valeurs numériques valides pour coût, x et y.");
        }
    }
}